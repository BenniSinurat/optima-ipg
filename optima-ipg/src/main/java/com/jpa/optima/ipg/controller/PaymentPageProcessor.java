package com.jpa.optima.ipg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.optima.ipg.helper.AESSecurity;
import com.jpa.optima.ipg.helper.Utils;
import com.jpa.optima.ipg.model.BillingSuccess;
import com.jpa.optima.ipg.model.CreditCardParam;
import com.jpa.optima.ipg.model.DeepLinkRequest;
import com.jpa.optima.ipg.model.DeepLinkResponse;
import com.jpa.optima.ipg.model.DirectDebitCancelTrxRequest;
import com.jpa.optima.ipg.model.DirectDebitCancelTrxResponse;
import com.jpa.optima.ipg.model.DirectDebitInquiryStatusRequest;
import com.jpa.optima.ipg.model.DirectDebitInquiryStatusResponse;
import com.jpa.optima.ipg.model.DirectDebitPurchaseOTPRequest;
import com.jpa.optima.ipg.model.DirectDebitPurchaseOTPResponse;
import com.jpa.optima.ipg.model.DirectDebitPurchaseRequest;
import com.jpa.optima.ipg.model.DirectDebitPurchaseResponse;
import com.jpa.optima.ipg.model.DirectDebitRemoveCardRequest;
import com.jpa.optima.ipg.model.DirectDebitRemoveCardResponse;
import com.jpa.optima.ipg.model.DirectDebitSetTokenLimitRequest;
import com.jpa.optima.ipg.model.DirectDebitSetTokenLimitResponse;
import com.jpa.optima.ipg.model.QRCodeParam;
import com.jpa.optima.ipg.model.QRCodeResponse;
import com.jpa.optima.ipg.model.Ticket;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.bellatrix.services.ws.access.Access;
import org.bellatrix.services.ws.access.AccessService;
import org.bellatrix.services.ws.access.CredentialRequest;
import org.bellatrix.services.ws.access.CredentialResponse;
import org.bellatrix.services.ws.access.Exception_Exception;
import org.bellatrix.services.ws.access.ValidateCredentialRequest;
import org.bellatrix.services.ws.access.ValidateCredentialResponse;
import org.bellatrix.services.ws.billpayments.BillPayment;
import org.bellatrix.services.ws.billpayments.BillPaymentService;
import org.bellatrix.services.ws.billpayments.LoadPaymentChannelByMemberIDRequest;
import org.bellatrix.services.ws.billpayments.LoadPaymentChannelByMemberIDResponse;
import org.bellatrix.services.ws.members.LoadMembersByUsernameRequest;
import org.bellatrix.services.ws.members.LoadMembersResponse;
import org.bellatrix.services.ws.members.Member;
import org.bellatrix.services.ws.members.MemberService;
import org.bellatrix.services.ws.members.Members;
import org.bellatrix.services.ws.message.Message;
import org.bellatrix.services.ws.message.MessageService;
import org.bellatrix.services.ws.message.SendMessageRequest;
import org.bellatrix.services.ws.payments.GeneratePaymentTicketRequest;
import org.bellatrix.services.ws.payments.GeneratePaymentTicketResponse;
import org.bellatrix.services.ws.payments.InquiryRequest;
import org.bellatrix.services.ws.payments.InquiryResponse;
import org.bellatrix.services.ws.payments.Payment;
import org.bellatrix.services.ws.payments.PaymentRequest;
import org.bellatrix.services.ws.payments.PaymentResponse;
import org.bellatrix.services.ws.payments.PaymentService;
import org.bellatrix.services.ws.payments.ReversalRequest;
import org.bellatrix.services.ws.payments.ReversalResponse;
import org.bellatrix.services.ws.payments.TransactionStatusRequest;
import org.bellatrix.services.ws.payments.TransactionStatusResponse;
import org.bellatrix.services.ws.payments.ValidatePaymentTicketRequest;
import org.bellatrix.services.ws.payments.ValidatePaymentTicketResponse;
import org.bellatrix.services.ws.transfertypes.LoadFeesByTransferTypeRequest;
import org.bellatrix.services.ws.transfertypes.LoadFeesByTransferTypeResponse;
import org.bellatrix.services.ws.transfertypes.TransferType;
import org.bellatrix.services.ws.transfertypes.TransferTypeService;
import org.bellatrix.services.ws.virtualaccount.BankVA;
import org.bellatrix.services.ws.virtualaccount.LoadVAByIDRequest;
import org.bellatrix.services.ws.virtualaccount.LoadVAByIDResponse;
import org.bellatrix.services.ws.virtualaccount.LoadVAEventRequest;
import org.bellatrix.services.ws.virtualaccount.LoadVAEventResponse;
import org.bellatrix.services.ws.virtualaccount.UpdateBillingStatusRequest;
import org.bellatrix.services.ws.virtualaccount.VaBankRequest;
import org.bellatrix.services.ws.virtualaccount.VaBankResponse;
import org.bellatrix.services.ws.virtualaccount.VaPaymentRequest;
import org.bellatrix.services.ws.virtualaccount.VaPaymentResponse;
import org.bellatrix.services.ws.virtualaccount.VaRegisterRequest;
import org.bellatrix.services.ws.virtualaccount.VaRegisterResponse;
import org.bellatrix.services.ws.virtualaccount.VirtualAccount;
import org.bellatrix.services.ws.virtualaccount.VirtualAccountService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentPageProcessor {
	@Autowired
	private ContextLoader contextLoader;
	@Autowired
	private JmsTemplate jmsTemplate;
	private Logger logger = Logger.getLogger(getClass());
	// private static final String HMAC_SHA512 = "HmacSHA512";
	// private static final String DEFAULT_ENCODING = "UTF-8";

	public void sendToSettlement(PaymentResponse response, BigDecimal amount) {
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("transferID", response.getId());
		obj.put("transferTypeID", response.getTransferType().getId());
		obj.put("transactionNumber", response.getTransactionNumber());
		obj.put("traceNumber", response.getTraceNumber());
		obj.put("fromUsername", response.getFromMember().getUsername());
		obj.put("toUsername", response.getToMember().getUsername());
		obj.put("amount", amount.toPlainString());
		jmsTemplate.convertAndSend(obj);
	}

	public void sendMessage(String fromUsername, String toUsername, String subject, String body) throws Exception {
		URL url = new URL(contextLoader.getHostWSUrl() + "message?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "MessageService");
		MessageService service = new MessageService(url, qName);
		Message client = service.getMessagePort();

		org.bellatrix.services.ws.message.Header headerPayment = new org.bellatrix.services.ws.message.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.message.Header> headerAuth = new Holder<org.bellatrix.services.ws.message.Header>();
		headerAuth.value = headerPayment;

		SendMessageRequest messageRequest = new SendMessageRequest();
		messageRequest.setFromUsername(fromUsername);
		messageRequest.setToUsername(toUsername);
		messageRequest.setBody(body);
		messageRequest.setSubject(subject);

		client.sendMessage(headerAuth, messageRequest);
	}

	public PaymentResponse doPayment(String ticketID, String to, String invoiceID, String description,
			BigDecimal amount) throws Exception {
		URL url = new URL(contextLoader.getHostWSUrl() + "payments?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "PaymentService");
		PaymentService service = new PaymentService(url, qName);
		Payment client = service.getPaymentPort();

		org.bellatrix.services.ws.payments.Header headerPayment = new org.bellatrix.services.ws.payments.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.payments.Header> headerAuth = new Holder<org.bellatrix.services.ws.payments.Header>();
		headerAuth.value = headerPayment;

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setFromMember(contextLoader.getDokuUsername());
		paymentRequest.setToMember(to);
		paymentRequest.setTraceNumber(contextLoader.getWebserviceID() + ticketID);
		paymentRequest.setDescription("Invoice ID : " + invoiceID + " - " + description);
		paymentRequest.setTransferTypeID(contextLoader.getIPGTransferType());
		paymentRequest.setAmount(amount);
		paymentRequest.setStatus("PENDING");

		PaymentResponse paymentResponse = client.doPayment(headerAuth, paymentRequest);
		return paymentResponse;
	}

	public LoadVAEventResponse loadVAEvent(String ticketID) throws Exception {
		URL url = new URL(contextLoader.getHostWSUrl() + "virtualaccounts?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "VirtualAccountService");
		VirtualAccountService service = new VirtualAccountService(url, qName);
		VirtualAccount client = service.getVirtualAccountPort();

		org.bellatrix.services.ws.virtualaccount.Header headerVA = new org.bellatrix.services.ws.virtualaccount.Header();
		headerVA.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.virtualaccount.Header> vaHeaderAuth = new Holder<org.bellatrix.services.ws.virtualaccount.Header>();
		vaHeaderAuth.value = headerVA;

		LoadVAEventRequest loadVAEventRequest = new LoadVAEventRequest();
		loadVAEventRequest.setTicketID(ticketID);
		LoadVAEventResponse loadVAEventResponse = client.loadVAEventByID(vaHeaderAuth, loadVAEventRequest);
		return loadVAEventResponse;
	}

	public VaRegisterResponse registerVABilling(String username, String billName, String msisdn, String email,
			String description, BigDecimal amount, Integer bankID, String eventID, String callback,
			Integer paymentChannel) throws MalformedURLException, DatatypeConfigurationException, ParseException {
		URL url = new URL(contextLoader.getHostWSUrl() + "virtualaccounts?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "VirtualAccountService");
		VirtualAccountService service = new VirtualAccountService(url, qName);
		VirtualAccount client = service.getVirtualAccountPort();

		org.bellatrix.services.ws.virtualaccount.Header headerVA = new org.bellatrix.services.ws.virtualaccount.Header();
		headerVA.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.virtualaccount.Header> vaHeaderAuth = new Holder<org.bellatrix.services.ws.virtualaccount.Header>();
		vaHeaderAuth.value = headerVA;

		VaRegisterRequest vaRegisterRequest = new VaRegisterRequest();
		vaRegisterRequest.setBankID(bankID);
		vaRegisterRequest.setExpiredDateTime(Utils.stringToXMLGregorianCalendar(DateUtils.addDays(new Date(), 1)));
		vaRegisterRequest.setName(billName);
		vaRegisterRequest.setPersistent(false);
		vaRegisterRequest.setReferenceNumber(msisdn);
		vaRegisterRequest.setUsername(username);

		if (paymentChannel == 2 || paymentChannel == 3) {
			vaRegisterRequest.setCallbackURL(contextLoader.getPaymentVANotifURL());
		} else {
			vaRegisterRequest.setEventID(eventID);
		}

		vaRegisterRequest.setMinimumPayment(BigDecimal.ZERO);
		vaRegisterRequest.setEmail(email);
		vaRegisterRequest.setFullPayment(true);
		vaRegisterRequest.setAmount(amount);
		vaRegisterRequest.setDescription(description);
		VaRegisterResponse vaRegisterResponse = client.registerVA(vaHeaderAuth, vaRegisterRequest);
		return vaRegisterResponse;
	}

	public LoadVAByIDResponse loadVAByID(String ticketID) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "virtualaccounts?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "VirtualAccountService");
		VirtualAccountService service = new VirtualAccountService(url, qName);
		VirtualAccount client = service.getVirtualAccountPort();

		org.bellatrix.services.ws.virtualaccount.Header headerVA = new org.bellatrix.services.ws.virtualaccount.Header();
		headerVA.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.virtualaccount.Header> vaHeaderAuth = new Holder<org.bellatrix.services.ws.virtualaccount.Header>();
		vaHeaderAuth.value = headerVA;
		LoadVAByIDRequest loadVAByIDRequest = new LoadVAByIDRequest();
		loadVAByIDRequest.setTicketID(ticketID);
		LoadVAByIDResponse loadVaByIDResponse = client.loadVAByID(vaHeaderAuth, loadVAByIDRequest);

		return loadVaByIDResponse;
	}

	public List<BankVA> listBankVA(String username) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "virtualaccounts?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "VirtualAccountService");
		VirtualAccountService service = new VirtualAccountService(url, qName);
		VirtualAccount client = service.getVirtualAccountPort();

		org.bellatrix.services.ws.virtualaccount.Header headerVA = new org.bellatrix.services.ws.virtualaccount.Header();
		headerVA.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.virtualaccount.Header> vaHeaderAuth = new Holder<org.bellatrix.services.ws.virtualaccount.Header>();
		vaHeaderAuth.value = headerVA;

		VaBankRequest vaBankRequest = new VaBankRequest();
		vaBankRequest.setUsername(username);

		VaBankResponse vaBankResponse = client.listBankVA(vaHeaderAuth, vaBankRequest);

		List<BankVA> trxList = new ArrayList<>();
		if (vaBankResponse.getBank().size() > 0) {
			for (BankVA va : vaBankResponse.getBank()) {
				BankVA bank = new BankVA();
				bank.setId(va.getId());
				bank.setBankCode(va.getBankCode());
				bank.setBankName(va.getBankName());
				trxList.add(va);
			}
		}
		return trxList;
	}

	public GeneratePaymentTicketResponse generatePaymentTicket(String username, String invoiceID, String name,
			String email, String description, BigDecimal amount) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "payments?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "PaymentService");
		PaymentService service = new PaymentService(url, qName);
		Payment client = service.getPaymentPort();

		org.bellatrix.services.ws.payments.Header headerPayment = new org.bellatrix.services.ws.payments.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.payments.Header> payHeaderAuth = new Holder<org.bellatrix.services.ws.payments.Header>();
		payHeaderAuth.value = headerPayment;

		GeneratePaymentTicketRequest gpt = new GeneratePaymentTicketRequest();
		gpt.setAmount(amount);
		gpt.setDescription(description);
		gpt.setInvoiceNumber(invoiceID);
		gpt.setEmail(email);
		gpt.setName(name);
		gpt.setToMember(username);
		gpt.setTransferTypeID(contextLoader.getIPGTransferType());
		GeneratePaymentTicketResponse gptr = client.generatePaymentTicket(payHeaderAuth, gpt);
		return gptr;
	}

	public ValidatePaymentTicketResponse validatePaymentTicket(String ticketID) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "payments?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "PaymentService");
		PaymentService service = new PaymentService(url, qName);
		Payment client = service.getPaymentPort();

		org.bellatrix.services.ws.payments.Header headerPayment = new org.bellatrix.services.ws.payments.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.payments.Header> payHeaderAuth = new Holder<org.bellatrix.services.ws.payments.Header>();
		payHeaderAuth.value = headerPayment;

		ValidatePaymentTicketRequest vpt = new ValidatePaymentTicketRequest();
		vpt.setTicket(ticketID);
		ValidatePaymentTicketResponse vptr = client.validatePaymentTicket(payHeaderAuth, vpt);
		return vptr;
	}

	public LoadMembersResponse loadMember(String username) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "members?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "MemberService");
		MemberService service = new MemberService(url, qName);
		Member client = service.getMemberPort();

		org.bellatrix.services.ws.members.Header headerMember = new org.bellatrix.services.ws.members.Header();
		headerMember.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.members.Header> memberHeaderAuth = new Holder<org.bellatrix.services.ws.members.Header>();
		memberHeaderAuth.value = headerMember;

		LoadMembersByUsernameRequest lm = new LoadMembersByUsernameRequest();
		lm.setUsername(username);
		LoadMembersResponse lmr = client.loadMembersByUsername(memberHeaderAuth, lm);
		return lmr;
	}

	public CredentialResponse loadCredential(String username, Integer accessTypeID)
			throws Exception_Exception, MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "access?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "AccessService");
		AccessService service = new AccessService(url, qName);
		Access client = service.getAccessPort();

		org.bellatrix.services.ws.access.Header headerMember = new org.bellatrix.services.ws.access.Header();
		headerMember.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.access.Header> accessHeaderAuth = new Holder<org.bellatrix.services.ws.access.Header>();
		accessHeaderAuth.value = headerMember;

		CredentialRequest cr = new CredentialRequest();
		cr.setUsername(username);
		cr.setAccessTypeID(accessTypeID);
		CredentialResponse lmr = client.getCredential(accessHeaderAuth, cr);
		return lmr;
	}

	public CreditCardParam forwardCreditCardPayment(String ticketID, String invoiceID, String name, String email,
			BigDecimal amount, String description) throws IOException {
		String words = DigestUtils
				.sha1Hex(amount + contextLoader.getDokuMallID() + contextLoader.getDokuSharedKey() + invoiceID);
		CreditCardParam param = new CreditCardParam();
		param.setMallID(contextLoader.getDokuMallID());
		param.setChainMerchant("NA");
		param.setAmount(amount);
		param.setTransID(invoiceID);
		param.setRequestDate(Utils.GetDate("yyyyMMddhhmmss"));
		param.setSessionID(ticketID);
		param.setCurrency("360");
		param.setEmail(email);
		param.setName(name);
		param.setWords(words);
		param.setBasket(description + "," + amount + ",1," + amount);
		return param;
	}

	public String sendCheckStatus(String transID, String sessionID) throws IOException {
		String result = "";
		HttpPost post = new HttpPost(contextLoader.getCheckStatusURL());
		String words = DigestUtils.sha1Hex(contextLoader.getDokuMallID() + contextLoader.getDokuSharedKey() + transID);

		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("MALLID", contextLoader.getDokuMallID()));
		urlParameters.add(new BasicNameValuePair("CHAINMERCHANT", "NA"));
		urlParameters.add(new BasicNameValuePair("TRANSIDMERCHANT", transID));
		urlParameters.add(new BasicNameValuePair("SESSIONID", sessionID));
		urlParameters.add(new BasicNameValuePair("WORDS", words));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		return result;
	}

	public String sendVANotification(Ticket t) throws IOException {
		String result = "";
		HttpPost post = new HttpPost(t.getCallback());

		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("merchantID", t.getMerchantID()));
		urlParameters.add(new BasicNameValuePair("invoiceID", t.getInvoiceID()));
		urlParameters.add(new BasicNameValuePair("amount", t.getAmount().toPlainString()));
		urlParameters.add(new BasicNameValuePair("sessionID", t.getSessionID()));
		urlParameters.add(new BasicNameValuePair("currency", t.getCurrency()));
		urlParameters.add(new BasicNameValuePair("name", t.getName()));
		urlParameters.add(new BasicNameValuePair("email", t.getEmail()));
		urlParameters.add(new BasicNameValuePair("msisdn", t.getMsisdn()));
		urlParameters.add(new BasicNameValuePair("description", t.getDescription()));
		urlParameters.add(new BasicNameValuePair("paymentChannel", String.valueOf(t.getPaymentChannel())));
		urlParameters.add(new BasicNameValuePair("words", t.getWords()));
		urlParameters.add(new BasicNameValuePair("status", "PROCESSED"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		logger.info("Param Notification : " + urlParameters);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		return result;
	}

	public String sendVALinkAjaNotification(Ticket t, String trxNumber) throws IOException {
		String result = "";
		HttpPost post = new HttpPost(t.getCallback());

		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("ticketID", t.getEventID()));
		urlParameters.add(new BasicNameValuePair("transactionNumber", trxNumber));
		urlParameters.add(new BasicNameValuePair("merchantID", t.getMerchantID()));
		urlParameters.add(new BasicNameValuePair("invoiceID", t.getInvoiceID()));
		urlParameters.add(new BasicNameValuePair("amount", t.getAmount().toPlainString()));
		urlParameters.add(new BasicNameValuePair("sessionID", t.getSessionID()));
		urlParameters.add(new BasicNameValuePair("currency", t.getCurrency()));
		urlParameters.add(new BasicNameValuePair("name", t.getName()));
		urlParameters.add(new BasicNameValuePair("email", t.getEmail()));
		urlParameters.add(new BasicNameValuePair("msisdn", t.getMsisdn()));
		urlParameters.add(new BasicNameValuePair("description", t.getDescription()));
		urlParameters.add(new BasicNameValuePair("paymentChannel", String.valueOf(t.getPaymentChannel())));
		urlParameters.add(new BasicNameValuePair("words", t.getWords()));
		urlParameters.add(new BasicNameValuePair("status", "PROCESSED"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		return result;
	}

	public String sendVoid(String transID, String sessionID) throws IOException {
		String result = "";
		HttpPost post = new HttpPost(contextLoader.getVoidURL());
		String words = DigestUtils.sha1Hex(contextLoader.getDokuMallID() + contextLoader.getDokuSharedKey() + transID);

		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("MALLID", contextLoader.getDokuMallID()));
		urlParameters.add(new BasicNameValuePair("CHAINMERCHANT", "NA"));
		urlParameters.add(new BasicNameValuePair("TRANSIDMERCHANT", transID));
		urlParameters.add(new BasicNameValuePair("SESSIONID", sessionID));
		urlParameters.add(new BasicNameValuePair("WORDS", words));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		return result;
	}

	public QRCodeResponse forwardQRPayment(QRCodeParam param)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		QRCodeResponse qrRes = new QRCodeResponse();
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(param);

		String words = contextLoader.getLinkAjaCID() + ":" + json + ":" + contextLoader.getLinkAjaSecretKey();

		String sha512Hex = Utils.hmacSHA512Encrypt(words, contextLoader.getLinkAjaSecretKey());

		HttpPost post = new HttpPost(contextLoader.getLinkAjaHostURL());
		post.setHeader("Accept", "application/json");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("cid", contextLoader.getLinkAjaCID());
		post.setHeader("signature", sha512Hex);
		StringEntity entity = new StringEntity(json);
		post.setEntity(entity);

		logger.info("Request to LinkAja Host: " + post.toString());
		logger.info("Request to LinkAja Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		JSONObject jsonResult = new JSONObject(result);
		logger.info("Response from LinkAja: " + jsonResult.toString());
		if (jsonResult.getString("responseCode").equalsIgnoreCase("00")) {
			qrRes.setMerchantTrxID(String.valueOf(jsonResult.getString("merchantTrxID")));
			qrRes.setQrString(String.valueOf(jsonResult.getString("qrString")));
			qrRes.setResponseCode(String.valueOf(jsonResult.getString("responseCode")));
			qrRes.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
		} else {
			qrRes.setResponseCode(String.valueOf(jsonResult.getString("responseCode")));
			qrRes.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
		}

		return qrRes;
	}

	public VaPaymentResponse paymentVA(String paymentCode, String trxNumber, Number amount, String fromMember,
			Integer trfTypeID) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "virtualaccounts?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "VirtualAccountService");
		VirtualAccountService service = new VirtualAccountService(url, qName);
		VirtualAccount client = service.getVirtualAccountPort();

		org.bellatrix.services.ws.virtualaccount.Header headerPayment = new org.bellatrix.services.ws.virtualaccount.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.virtualaccount.Header> payHeaderAuth = new Holder<org.bellatrix.services.ws.virtualaccount.Header>();
		payHeaderAuth.value = headerPayment;

		VaPaymentRequest req = new VaPaymentRequest();
		req.setPaymentCode(paymentCode);
		req.setAmount(new BigDecimal(amount.toString()));
		req.setTraceNumber(trxNumber);
		req.setFromMember(fromMember);
		req.setTransferTypeID(trfTypeID);

		VaPaymentResponse res = client.paymentVA(payHeaderAuth, req);

		return res;
	}

	public void updateBillingStatus(BillingSuccess req, String mid)
			throws MalformedURLException, org.bellatrix.services.ws.virtualaccount.Exception_Exception {
		URL url = new URL(contextLoader.getHostWSUrl() + "virtualaccounts?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "VirtualAccountService");
		VirtualAccountService service = new VirtualAccountService(url, qName);
		VirtualAccount client = service.getVirtualAccountPort();

		org.bellatrix.services.ws.virtualaccount.Header headerVA = new org.bellatrix.services.ws.virtualaccount.Header();
		headerVA.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.virtualaccount.Header> vaHeaderAuth = new Holder<org.bellatrix.services.ws.virtualaccount.Header>();
		vaHeaderAuth.value = headerVA;

		UpdateBillingStatusRequest updateBillingStatusReq = new UpdateBillingStatusRequest();
		updateBillingStatusReq.setUsername(mid);
		updateBillingStatusReq.setTraceNumber(req.getTraceNumber());
		updateBillingStatusReq.setTransactionNumber(req.getTransactionNumber());

		client.updateBillingStatus(vaHeaderAuth, updateBillingStatusReq);
	}

	public LoadPaymentChannelByMemberIDResponse loadPaymentChannelByMember(String username)
			throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "billpayments?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "BillPaymentService");
		BillPaymentService service = new BillPaymentService(url, qName);
		BillPayment client = service.getBillPaymentPort();

		org.bellatrix.services.ws.billpayments.Header headerPayment = new org.bellatrix.services.ws.billpayments.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.billpayments.Header> payHeaderAuth = new Holder<org.bellatrix.services.ws.billpayments.Header>();
		payHeaderAuth.value = headerPayment;

		LoadPaymentChannelByMemberIDRequest req = new LoadPaymentChannelByMemberIDRequest();
		req.setMemberID(((Members) loadMember(username).getMembers().get(0)).getId());

		LoadPaymentChannelByMemberIDResponse res = client.loadPaymentChannelByMemberID(payHeaderAuth, req);

		return res;
	}

	public InquiryResponse validateTransactionInquiry(InquiryRequest req) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "payments?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "PaymentService");
		PaymentService service = new PaymentService(url, qName);
		Payment client = service.getPaymentPort();

		org.bellatrix.services.ws.payments.Header headerPayment = new org.bellatrix.services.ws.payments.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.payments.Header> payHeaderAuth = new Holder<org.bellatrix.services.ws.payments.Header>();
		payHeaderAuth.value = headerPayment;

		InquiryRequest inquiryRequest = new InquiryRequest();
		inquiryRequest.setAmount(req.getAmount());
		inquiryRequest.setFromMember(req.getFromMember());
		inquiryRequest.setToMember(req.getToMember());
		inquiryRequest.setTransferTypeID(req.getTransferTypeID());

		InquiryResponse inqRes = client.doInquiry(payHeaderAuth, inquiryRequest);

		return inqRes;
	}
	
	public TransactionStatusResponse transactionStatus(String traceNumber) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "payments?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "PaymentService");
		PaymentService service = new PaymentService(url, qName);
		Payment client = service.getPaymentPort();
		
		org.bellatrix.services.ws.payments.Header headerPayment = new org.bellatrix.services.ws.payments.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.payments.Header> payHeaderAuth = new Holder<org.bellatrix.services.ws.payments.Header>();
		payHeaderAuth.value = headerPayment;
		
		TransactionStatusRequest req = new TransactionStatusRequest();
		req.setTraceNumber(traceNumber);
		
		TransactionStatusResponse res = client.transactionStatus(payHeaderAuth, req);
		
		return res;
	}

	public ReversalResponse reversePayment(ReversalRequest req) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "payments?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "PaymentService");
		PaymentService service = new PaymentService(url, qName);
		Payment client = service.getPaymentPort();

		org.bellatrix.services.ws.payments.Header headerPayment = new org.bellatrix.services.ws.payments.Header();
		headerPayment.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.payments.Header> payHeaderAuth = new Holder<org.bellatrix.services.ws.payments.Header>();
		payHeaderAuth.value = headerPayment;

		ReversalRequest rreq = new ReversalRequest();
		rreq.setUsername(req.getUsername());
		rreq.setTraceNumber(req.getTraceNumber());
		rreq.setTransactionNumber(req.getTransactionNumber());

		ReversalResponse res = client.reversePayment(payHeaderAuth, rreq);

		return res;
	}

	public LoadFeesByTransferTypeResponse loadFeeByTransferType(Integer trfTypeID) throws MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "transfertypes?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "TransferTypeService");
		TransferTypeService service = new TransferTypeService(url, qName);
		TransferType client = service.getTransferTypePort();

		org.bellatrix.services.ws.transfertypes.Header headerTransferType = new org.bellatrix.services.ws.transfertypes.Header();
		headerTransferType.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.transfertypes.Header> transferTypeAuth = new Holder<org.bellatrix.services.ws.transfertypes.Header>();
		transferTypeAuth.value = headerTransferType;

		LoadFeesByTransferTypeRequest feeReq = new LoadFeesByTransferTypeRequest();
		feeReq.setId(trfTypeID);

		LoadFeesByTransferTypeResponse feeRes = client.loadFeesByTransferType(transferTypeAuth, feeReq);

		return feeRes;
	}

	public ValidateCredentialResponse validateCredential(String username, String pin, Integer accessTypeID)
			throws Exception_Exception, MalformedURLException {
		URL url = new URL(contextLoader.getHostWSUrl() + "access?wsdl");
		QName qName = new QName(contextLoader.getHostWSPort(), "AccessService");
		AccessService service = new AccessService(url, qName);
		Access client = service.getAccessPort();

		org.bellatrix.services.ws.access.Header headerMember = new org.bellatrix.services.ws.access.Header();
		headerMember.setToken(contextLoader.getHeaderToken());
		Holder<org.bellatrix.services.ws.access.Header> accessHeaderAuth = new Holder<org.bellatrix.services.ws.access.Header>();
		accessHeaderAuth.value = headerMember;

		ValidateCredentialRequest cr = new ValidateCredentialRequest();
		cr.setUsername(username);
		cr.setAccessTypeID(accessTypeID);
		cr.setCredential(pin);
		ValidateCredentialResponse lmr = client.validateCredential(accessHeaderAuth, cr);
		return lmr;
	}

	public void sendOTPMessage(String msisdn, String otp) {
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("text", "GUNAKAN OTP : " + otp
				+ " BERLAKU 15 MENIT. JAGA KERAHASIAAN PIN OTP ANDA, JANGAN DIBERIKAN KEPADA SIAPAPUN TERMASUK PETUGAS OPTIMA");
		obj.put("to", msisdn);
		obj.put("from", "OPTIMA");
		jmsTemplate.setDefaultDestinationName("emoney.notification.sms");
		jmsTemplate.convertAndSend(obj);
	}

	public DeepLinkResponse forwardDeepLink(DeepLinkRequest param)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		DeepLinkResponse qrRes = new DeepLinkResponse();
		String result = "";
		String timestamp = StringUtils.rightPad(Long.toString(Utils.getTimestamp()), 16, '0');

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(param);

		HttpPost post = new HttpPost(contextLoader.getLinkAjaDeepLinkHostURL());
		post.setHeader("Content-Type", "Text/plain");
		post.setHeader("Authorization",
				"Basic" + Base64.getEncoder().encodeToString(
						(contextLoader.getLinkAjaDeepLinkUsername() + ":" + contextLoader.getLinkAjaDeepLinkPassword())
								.getBytes()));
		post.setHeader("timestamp", timestamp);
		post.setHeader("User-Agent", "Web");
		StringEntity entity = new StringEntity(
				AESSecurity.encrypt(json, contextLoader.getLinkAjaDeepLinkEncryptKey(), timestamp),
				ContentType.create("text/plain", "UTF-8"));
		post.setEntity(entity);

		logger.info("Request to LinkAja Host: " + post.getURI());
		logger.info("Request to LinkAja Header: " + post.getEntity().toString());
		logger.info("Request to LinkAja Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		JSONObject jsonResult = new JSONObject(result);
		logger.info("Response from LinkAja: " + jsonResult.toString());
		if (jsonResult.getString("status").equalsIgnoreCase("00")) {
			qrRes.setMessage(String.valueOf(jsonResult.getString("message")));
			qrRes.setStatus(String.valueOf(jsonResult.get("status")));
			qrRes.setUrl(String.valueOf(jsonResult.get("url")));
		} else {
			qrRes.setMessage(String.valueOf(jsonResult.getString("message")));
			qrRes.setStatus(String.valueOf(jsonResult.get("status")));
		}

		return qrRes;
	}

	public String getTokenDirectDebit(Ticket t) throws IOException, NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String result = "";
		String timestamp = Utils.GetDate("yyyy-MM-dd HH:mm:ss");

		String words = t.getMerchants().getUsername() + "|" + timestamp;
		String sha512Hex = Utils.hmacSHA512Encrypt(words, t.getMerchants().getPassword());

		HttpGet get = new HttpGet(contextLoader.getDirectDebitHostURL() + "/directDebit/getjwt");
		get.setHeader("Accept", "application/json");
		get.setHeader("X-TIMESTAMP", timestamp);
		get.setHeader("X-MTI-Key", t.getMerchants().getUsername());
		get.setHeader("X-SIGNATURE", sha512Hex);

		logger.info("Request to Direct Debit Host: " + get.getURI());

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		JSONObject jsonResult = new JSONObject(result);
		logger.info("Response from Direct Debit: " + jsonResult.toString());

		return String.valueOf(jsonResult.getString("jwt"));
	}

	public DirectDebitPurchaseOTPResponse directDebitRequestOTP(Ticket t, String key, DirectDebitPurchaseOTPRequest req)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		DirectDebitPurchaseOTPResponse res = new DirectDebitPurchaseOTPResponse();
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(req);

		String signature = Utils.hmacSHA512Encrypt(json, t.getMerchants().getSecretKey());

		HttpPost post = new HttpPost(contextLoader.getDirectDebitHostURL() + "/directDebit/requestOTP");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("requestID", key);
		post.setHeader("journeyID", t.getInvoiceID());
		post.setHeader("tokenRequestorID", t.getMerchants().getTokenRequestorID());
		post.setHeader("Authorization", "Bearer " + getTokenDirectDebit(t));
		post.setHeader("signature", signature);
		StringEntity entity = new StringEntity(json);
		post.setEntity(entity);

		logger.info("Request to Direct Debit OTP Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		logger.info("Response from Direct Debit OTP: " + result);
		JSONObject jsonResult = new JSONObject(result);
		if (jsonResult.getString("responseCode").equalsIgnoreCase("00")) {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
			res.setAuthorizationDate(String.valueOf(jsonResult.get("authorizationDate")));
			res.setAuthorizationTime(String.valueOf(jsonResult.get("authorizationTime")));
			res.setOtpReferenceNumber(String.valueOf(jsonResult.get("otpReferenceNumber")));
			res.setVerificationMethod(String.valueOf(jsonResult.get("verificationMethod")));
			res.setReferenceNumber(String.valueOf(jsonResult.get("referenceNumber")));
		} else {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
		}

		return res;
	}

	public DirectDebitPurchaseResponse directDebitPurchase(Ticket t, String key, DirectDebitPurchaseRequest req)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		DirectDebitPurchaseResponse res = new DirectDebitPurchaseResponse();
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(req);

		String signature = Utils.hmacSHA512Encrypt(json, t.getMerchants().getSecretKey());

		HttpPost post = new HttpPost(contextLoader.getDirectDebitHostURL() + "/directDebit/purchaseSubmit");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("requestID", key);
		post.setHeader("journeyID", t.getInvoiceID());
		post.setHeader("tokenRequestorID", t.getMerchants().getTokenRequestorID());
		post.setHeader("Authorization", "Bearer " + getTokenDirectDebit(t));
		post.setHeader("signature", signature);
		StringEntity entity = new StringEntity(json);
		post.setEntity(entity);

		logger.info("Request to Direct Debit Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		JSONObject jsonResult = new JSONObject(result);
		logger.info("Response from Direct Debit: " + jsonResult.toString());
		if (jsonResult.getString("responseCode").equalsIgnoreCase("00")) {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
			res.setAuthorizationDate(String.valueOf(jsonResult.get("authorizationDate")));
			res.setAuthorizationTime(String.valueOf(jsonResult.get("authorizationTime")));
		} else {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
		}

		return res;
	}

	public String purchaseRequest(String ticketID) throws IOException {
		String result = "";
		HttpPost post = new HttpPost(contextLoader.getDirectDebitPurchaseURL());

		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("ticketID", ticketID));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		return result;
	}

	public String purchaseRedirect(final String ticketID, final String transactionNumber, final String status,
			final String msisdn) throws IOException {
		String result = "";
		HttpGet get = new HttpGet(contextLoader.getDirectDebitPurchaseRedirect() + "?ticketID=" + ticketID
				+ "&transactionNumber=" + transactionNumber + "&status=" + status + "&msisdn=" + msisdn);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		return result;
	}

	public DirectDebitRemoveCardResponse directDebitRemoveCard(Ticket t, String key, DirectDebitRemoveCardRequest req)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		DirectDebitRemoveCardResponse res = new DirectDebitRemoveCardResponse();
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(req);

		String signature = Utils.hmacSHA512Encrypt(json, t.getMerchants().getSecretKey());

		HttpPost post = new HttpPost(contextLoader.getDirectDebitHostURL() + "/directDebit/removeCard");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("requestID", key);
		post.setHeader("journeyID", key);
		post.setHeader("tokenRequestorID", t.getMerchants().getTokenRequestorID());
		post.setHeader("Authorization", "Bearer " + getTokenDirectDebit(t));
		post.setHeader("signature", signature);
		StringEntity entity = new StringEntity(json);
		post.setEntity(entity);

		logger.info("Request to Direct Debit Remove Card Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		logger.info("Response from Direct Debit Remove Card: " + result);
		JSONObject jsonResult = new JSONObject(result);
		if (jsonResult.getString("responseCode").equalsIgnoreCase("00")) {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
			res.setAuthorizationDate(String.valueOf(jsonResult.get("authorizationDate")));
			res.setAuthorizationTime(String.valueOf(jsonResult.get("authorizationTime")));
		} else {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
		}

		return res;
	}

	public DirectDebitCancelTrxResponse directDebitCancelTrx(Ticket t, String key, DirectDebitCancelTrxRequest req)
			throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		DirectDebitCancelTrxResponse res = new DirectDebitCancelTrxResponse();
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(req);

		String signature = Utils.hmacSHA512Encrypt(json, t.getMerchants().getSecretKey());

		HttpPost post = new HttpPost(contextLoader.getDirectDebitHostURL() + "/directDebit/cancelTrx");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("requestID", key);
		post.setHeader("journeyID", key);
		post.setHeader("tokenRequestorID", t.getMerchants().getTokenRequestorID());
		post.setHeader("Authorization", "Bearer " + getTokenDirectDebit(t));
		post.setHeader("signature", signature);
		StringEntity entity = new StringEntity(json);
		post.setEntity(entity);

		logger.info("Request to Direct Debit Cancel Trx Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		logger.info("Response from Direct Debit Cancel Trx: " + result);
		JSONObject jsonResult = new JSONObject(result);
		if (jsonResult.getString("responseCode").equalsIgnoreCase("00")) {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
			res.setAuthorizationDate(String.valueOf(jsonResult.get("authorizationDate")));
			res.setAuthorizationTime(String.valueOf(jsonResult.get("authorizationTime")));
		} else {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
		}

		return res;
	}

	public DirectDebitSetTokenLimitResponse directDebitSetTokenLimit(Ticket t, String key, String journeyID,
			DirectDebitSetTokenLimitRequest req) throws IOException, NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		DirectDebitSetTokenLimitResponse res = new DirectDebitSetTokenLimitResponse();
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(req);

		String signature = Utils.hmacSHA512Encrypt(json, t.getMerchants().getSecretKey());

		HttpPost post = new HttpPost(contextLoader.getDirectDebitHostURL() + "/directDebit/setTokenLimit");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("requestID", key);
		post.setHeader("journeyID", journeyID);
		post.setHeader("tokenRequestorID", t.getMerchants().getTokenRequestorID());
		post.setHeader("Authorization", "Bearer " + getTokenDirectDebit(t));
		post.setHeader("signature", signature);
		StringEntity entity = new StringEntity(json);
		post.setEntity(entity);

		logger.info("Request to Direct Debit Set Token Limit Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		logger.info("Response from Direct Debit Set Token Limit: " + result);
		JSONObject jsonResult = new JSONObject(result);
		if (jsonResult.getString("responseCode").equalsIgnoreCase("00")) {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
			res.setAuthorizationDate(String.valueOf(jsonResult.get("authorizationDate")));
			res.setAuthorizationTime(String.valueOf(jsonResult.get("authorizationTime")));
			res.setReferenceNumber(String.valueOf(jsonResult.get("referenceNumber")));
		} else {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
		}

		return res;
	}

	public DirectDebitInquiryStatusResponse directDebitInquiryTransaction(Ticket t, String key,
			DirectDebitInquiryStatusRequest req) throws IOException, NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		DirectDebitInquiryStatusResponse res = new DirectDebitInquiryStatusResponse();
		String result = "";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(req);

		String signature = Utils.hmacSHA512Encrypt(json, t.getMerchants().getSecretKey());

		HttpPost post = new HttpPost(contextLoader.getDirectDebitHostURL() + "/directDebit/inquiryTransactionStatus");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("requestID", key);
		post.setHeader("journeyID", key);
		post.setHeader("tokenRequestorID", t.getMerchants().getTokenRequestorID());
		post.setHeader("Authorization", "Bearer " + getTokenDirectDebit(t));
		post.setHeader("signature", signature);
		StringEntity entity = new StringEntity(json);
		post.setEntity(entity);

		logger.info("Request to Direct Debit Inquiry Transaction Status Body: " + json);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		Throwable localThrowable6 = null;
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			Throwable localThrowable7 = null;
			try {
				result = EntityUtils.toString(response.getEntity());
			} catch (Throwable localThrowable1) {
				localThrowable7 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (response != null)
					if (localThrowable7 != null)
						try {
							response.close();
						} catch (Throwable localThrowable2) {
							localThrowable7.addSuppressed(localThrowable2);
						}
					else
						response.close();
			}
		} catch (Throwable localThrowable4) {
			localThrowable6 = localThrowable4;
			throw localThrowable4;
		} finally {
			if (httpClient != null)
				if (localThrowable6 != null)
					try {
						httpClient.close();
					} catch (Throwable localThrowable5) {
						localThrowable6.addSuppressed(localThrowable5);
					}
				else
					httpClient.close();
		}
		logger.info("Response from Direct Debit Inquiry Transaction Status: " + result);
		JSONObject jsonResult = new JSONObject(result);
		if (jsonResult.getString("responseCode").equalsIgnoreCase("00")) {
			res.setResponseMessage(String.valueOf(jsonResult.get("responseCode")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
			res.setAuthorizationDate(String.valueOf(jsonResult.get("authorizationDate")));
			res.setAuthorizationTime(String.valueOf(jsonResult.get("authorizationTime")));
			res.setReferenceNumber(String.valueOf(jsonResult.get("referenceNumber")));
			res.setOriginResponseCode(jsonResult.getJSONObject("origin").getString("responseCode"));
			res.setOriginResponseMessage(jsonResult.getJSONObject("origin").getString("responseMessage"));
		} else {
			res.setResponseMessage(String.valueOf(jsonResult.getString("responseMessage")));
			res.setResponseCode(String.valueOf(jsonResult.get("responseCode")));
		}

		return res;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}