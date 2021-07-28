package com.jpa.optima.ipg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.jpa.optima.ipg.helper.AESSecurity;
import com.jpa.optima.ipg.helper.QRCodeHelper;
import com.jpa.optima.ipg.helper.Utils;
import com.jpa.optima.ipg.model.BillingSuccess;
import com.jpa.optima.ipg.model.CreditCardParam;
import com.jpa.optima.ipg.model.DeepLinkPaymentRequest;
import com.jpa.optima.ipg.model.DeepLinkRequest;
import com.jpa.optima.ipg.model.DeepLinkResponse;
import com.jpa.optima.ipg.model.DirectDebitInqRequest;
import com.jpa.optima.ipg.model.DirectDebitPurchaseNotificationRequest;
import com.jpa.optima.ipg.model.DirectDebitPurchaseNotificationResponse;
import com.jpa.optima.ipg.model.DirectDebitPurchaseOTPRequest;
import com.jpa.optima.ipg.model.DirectDebitPurchaseOTPResponse;
import com.jpa.optima.ipg.model.DirectDebitPurchaseRequest;
import com.jpa.optima.ipg.model.DirectDebitPurchaseResponse;
import com.jpa.optima.ipg.model.DirectDebitRegistrationNotificationRequest;
import com.jpa.optima.ipg.model.DirectDebitRegistrationNotificationResponse;
import com.jpa.optima.ipg.model.DirectDebitRequest;
import com.jpa.optima.ipg.model.FelloInquiryRequest;
import com.jpa.optima.ipg.model.FelloPaymentRequest;
import com.jpa.optima.ipg.model.LinkAjaNotificationRequest;
import com.jpa.optima.ipg.model.LinkAjaNotificationResponse;
import com.jpa.optima.ipg.model.QRCodeParam;
import com.jpa.optima.ipg.model.QRCodeResponse;
import com.jpa.optima.ipg.model.Ticket;
import com.jpa.optima.ipg.model.TransactionInquiryRequest;
import com.jpa.optima.ipg.model.TransactionInquiryResponse;
import com.jpa.optima.ipg.model.Transfer;
import com.jpa.optima.ipg.model.additionalData;
import com.jpa.optima.ipg.process.IPGValidation;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.bellatrix.services.ws.access.CredentialResponse;
import org.bellatrix.services.ws.access.ValidateCredentialResponse;
import org.bellatrix.services.ws.billpayments.LoadPaymentChannelByMemberIDResponse;
import org.bellatrix.services.ws.members.LoadMembersResponse;
import org.bellatrix.services.ws.members.Members;
import org.bellatrix.services.ws.payments.InquiryRequest;
import org.bellatrix.services.ws.payments.InquiryResponse;
import org.bellatrix.services.ws.payments.PaymentResponse;
import org.bellatrix.services.ws.virtualaccount.LoadVAByIDResponse;
import org.bellatrix.services.ws.virtualaccount.VaEvent;
import org.bellatrix.services.ws.virtualaccount.VaPaymentResponse;
import org.bellatrix.services.ws.virtualaccount.VaRegisterResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@org.springframework.web.servlet.config.annotation.EnableWebMvc
public class IPGController {
	@Autowired
	private PaymentPageProcessor paymentPageProcessor;
	@Autowired
	private HazelcastInstance instance;
	@Autowired
	private ContextLoader contextLoader;
	@Autowired
	private IPGValidation ipgValidation;
	private Logger logger = Logger.getLogger(getClass());

	public IPGController() {
	}

	@RequestMapping(value = { "/paymentRequest" }, method = RequestMethod.POST)
	public String payment(@RequestParam(value = "merchantID", required = true) String mid,
			@RequestParam(value = "invoiceID", required = true) String invoiceID,
			@RequestParam(value = "paymentChannel", required = false) Integer channel,
			@RequestParam(value = "amount", required = true) String amount,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "msisdn", required = false) String msisdn,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "callback", required = true) String callback,
			@RequestParam(value = "localDateTime", required = true) String localDateTime,
			@RequestParam(value = "sessionID", required = true) String sessionID,
			@RequestParam(value = "eventID", required = false) String eventID,
			@RequestParam(value = "currency", required = false) String currency,
			@RequestParam(value = "words", required = true) String words,
			@RequestParam(value = "fee", required = false) String fee,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "postalCode", required = false) String postalCode, Model model,
			HttpServletRequest req) throws MalformedURLException {
		if (mid == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : merchantID");
			return "page_exception";
		}

		if (invoiceID == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : invoiceID");
			return "page_exception";
		}

		if (amount == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : amount");
			return "page_exception";
		}

		if (email == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : email");
			return "page_exception";
		}

		if (callback == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : callback");
			return "page_exception";
		}

		if (localDateTime == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : localDateTime");
			return "page_exception";
		}

		if (sessionID == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : sessionID");
			return "page_exception";
		}

		if (words == "") {
			model.addAttribute("httpResponseCode", "400");
			model.addAttribute("status", "Bad Request");
			model.addAttribute("description", "Insufficient Mandatory Parameter : words");
			return "page_exception";
		}

		String cities = city == null ? "Jakarta Selatan" : city;
		String postalcode = postalCode == null ? "12160" : postalCode;
		Integer paymentChannel = Integer.valueOf(channel == null ? 0 : channel.intValue());
		try {
			LoadMembersResponse lmr = paymentPageProcessor.loadMember(mid);
			if (lmr.getMembers().size() == 0) {
				logger.error("[MID Not Found : " + mid + "]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Bad Request");
				model.addAttribute("description", "Merchant Not Found");
				return "page_exception";
			}

			CredentialResponse cr = paymentPageProcessor.loadCredential(mid, Integer.valueOf(2));
			String rawhashing = "";
			rawhashing = mid + invoiceID + amount + callback + cr.getCredential();

			String sha256hex = DigestUtils.sha256Hex(rawhashing);
			logger.info("[Request WORDS : " + words + ", Before Hash : " + rawhashing + ", Hashed WORDS : " + sha256hex
					+ "]");
			if (sha256hex.compareTo(words) != 0) {
				logger.info("[INVALID Words = [Request :" + words + "] [Calculated :" + sha256hex + "]");
				model.addAttribute("httpResponseCode", "401");
				model.addAttribute("status", "Unauthorized");
				model.addAttribute("description", "You have invalid WORDS");

				return "page_exception";
			}

			String refNo = msisdn == null
					? String.valueOf(Utils.getRandomNumberInRange(1111, 9999))
							+ String.valueOf(Utils.getRandomNumberInRange(11111111, 99999999))
					: msisdn;

			BigDecimal feeDef = fee == null ? BigDecimal.ZERO : new BigDecimal(fee);
			String eventId = eventID == null ? "NA" : eventID;
			String descVal = description == null ? "Payment to " + lmr.getMembers().get(0).getName() : description;
			String currencyVal = currency == null ? "360" : currency;
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");

			logger.info("[Request IP Address : " + req.getRemoteAddr() + "]");
			logger.info("[EventID : " + eventId + " SessionID : " + sessionID + "]");
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			String ticket = UUID.randomUUID().toString();
			Ticket t = new Ticket();
			t.setAmount(new BigDecimal(amount));
			t.setDescription(descVal);
			t.setEmail(email);
			t.setInvoiceID(invoiceID);
			t.setName(name);
			t.setMerchantID(mid);
			t.setIpAddress(req.getRemoteAddr());
			t.setMsisdn(refNo);
			t.setPaymentChannel(paymentChannel);
			t.setCallback(callback);
			t.setSessionID(sessionID);
			t.setEventID(eventId);
			t.setCurrency(currencyVal);
			t.setWords(words);
			t.setLocalDateTime(formatter.parse(localDateTime));
			t.setFee(feeDef);
			t.setMerchantName(lmr.getMembers().get(0).getName());
			t.setCity(cities);
			t.setPostalCode(postalcode);
			t.setPaymentChannel(paymentChannel);
			tMap.put(ticket, t);

			String sID = mid + invoiceID + sessionID;
			IMap<String, Ticket> sMap = instance.getMap("PaymentSessionMap");
			sMap.put(sID, t);

			model.addAttribute("ticketID", ticket);
			model.addAttribute("paymentPageURL", contextLoader.getPaymentPageURL());
			return "paymentRequest";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/paymentPage" }, method = RequestMethod.POST)
	public String paymentOption(@RequestParam(value = "ticketID", required = true) String ticketID, Model model,
			HttpServletRequest req) throws Exception {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = (Ticket) tMap.get(ticketID);

			logger.info("[Payment IP Address : " + req.getRemoteAddr() + "]");
			if (!t.getIpAddress().equalsIgnoreCase(req.getRemoteAddr())) {
				logger.error("[IP Address Violation]");
				model.addAttribute("httpResponseCode", "403");
				model.addAttribute("status", "Forbidden");
				model.addAttribute("description", "Invalid RemoteAddress");
				return "page_exception";
			}

			LoadMembersResponse lmr = paymentPageProcessor.loadMember(t.getMerchantID());
			if (t.getEventID().equalsIgnoreCase("NA")) {
				model.addAttribute("eventName", "");
			} else {
				model.addAttribute("eventName",
						paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
			}

			logger.info("Event ID: " + t.getEventID() + "/Amount: " + t.getAmount());

			model.addAttribute("username", lmr.getMembers().get(0).getUsername());
			model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
			model.addAttribute("description", t.getDescription());
			model.addAttribute("amount", t.getAmount());
			model.addAttribute("formattedAmount", Utils.formatAmount(t.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("email", t.getEmail());
			model.addAttribute("msisdn", t.getMsisdn());
			model.addAttribute("name", t.getName());
			model.addAttribute("receiveURL", contextLoader.getReceiveURL());
			model.addAttribute("ticketID", ticketID);

			LoadPaymentChannelByMemberIDResponse ch = paymentPageProcessor
					.loadPaymentChannelByMember(lmr.getMembers().get(0).getUsername());

			if (ch.getPaymentChannel().size() == 0) {
				logger.error("[Payment Channel Not Found]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Payment Not Available");
				model.addAttribute("description", "Payment Not Available");
				return "page_exception";
			}
			if (t.getPaymentChannel().intValue() == 0) {
				model.addAttribute("paymentChannel", ch);
				logger.info("--GENERAL--");
				return "paymentPage";
			}
			model.addAttribute("paymentChannel", t.getPaymentChannel());

			InquiryRequest inqReq = new InquiryRequest();
			inqReq.setAmount(t.getAmount());
			inqReq.setToMember(t.getMerchantID());
			inqReq.setFromMember(contextLoader.getIPGUsername());

			for (int i = 0; i < ch.getPaymentChannel().size(); i++) {
				Boolean checkChannel = Boolean
						.valueOf(ch.getPaymentChannel().get(i).getId().equals(t.getPaymentChannel()));
				if (checkChannel.booleanValue()) {
					inqReq.setTransferTypeID(ch.getPaymentChannel().get(i).getTransferTypeID());

					InquiryResponse inqRes = paymentPageProcessor.validateTransactionInquiry(inqReq);
					if (inqRes.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
						model.addAttribute("transactionAmount", new BigDecimal(
								inqRes.getTransactionAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						model.addAttribute("formattedTransactionAmount",
								Utils.formatAmount(inqRes.getTransactionAmount().setScale(0, RoundingMode.UP), ".", ",",
										"#,##0.00", "Rp.", ",-"));
						model.addAttribute("totalFee",
								new BigDecimal(inqRes.getTotalFees().setScale(0, RoundingMode.UP).toString() + ".00"));
						model.addAttribute("formattedTotalFee", Utils.formatAmount(
								inqRes.getTotalFees().setScale(0, RoundingMode.UP), ".", ",", "#,##0.00", "Rp.", ",-"));
						model.addAttribute("finalAmount",
								new BigDecimal(inqRes.getFinalAmount().setScale(0, RoundingMode.UP).toString())
										+ ".00");
						model.addAttribute("formattedFinalAmount",
								Utils.formatAmount(inqRes.getFinalAmount().setScale(0, RoundingMode.UP), ".", ",",
										"#,##0.00", "Rp.", ",-"));

						IMap<String, Ticket> vaMap = instance.getMap("PaymentAmountMap");
						Ticket ti = new Ticket();
						ti.setTransferTypeID(ch.getPaymentChannel().get(i).getTransferTypeID());
						ti.setAmount(t.getAmount());
						ti.setTotalFee(
								new BigDecimal(inqRes.getTotalFees().setScale(0, RoundingMode.UP).toString() + ".00"));
						ti.setFinalAmount(new BigDecimal(
								inqRes.getFinalAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						ti.setTransactionAmount(new BigDecimal(
								inqRes.getTransactionAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						vaMap.put(ticketID, ti);
					} else {
						model.addAttribute("status", inqRes.getStatus().getDescription());
						model.addAttribute("httpResponseCode", "404");
						model.addAttribute("status", inqRes.getStatus().getMessage());
						model.addAttribute("description", inqRes.getStatus().getDescription());
						return "page_exception";
					}
				}
			}

			return "transactionInquiry";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (IOException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/bankTransfer" }, method = RequestMethod.POST)
	public String submitTransferForm(@Valid @ModelAttribute("transfer") Transfer transfer, BindingResult result,
			ModelMap model) {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(transfer.getTicketID());

			logger.info("-- BANK Transfer Payment Channel : " + transfer.getPaymentChannel());
			Integer bankId = 0;
			if (transfer.getPaymentChannel() == 2) {
				bankId = 1;
			} else {
				bankId = 4;
			}

			VaRegisterResponse vaRegisterResponse = paymentPageProcessor.registerVABilling(t.getMerchantID(),
					transfer.getName(), transfer.getMsisdn(), transfer.getEmail(), transfer.getDescription(),
					transfer.getAmount(), Integer.valueOf(bankId), t.getEventID(), contextLoader.getPaymentVANotifURL(),
					transfer.getPaymentChannel());

			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
				model.addAttribute("ticketID", transfer.getTicketID());
				model.addAttribute("ticketVA", vaRegisterResponse.getTicketID());
				return "redirect:/bankTransferPayment";
			}
			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("DUPLICATE_TRANSACTION")) {
				logger.error("[Ticket Not Found/Expired]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Duplicate Billing");
				model.addAttribute("description", "Your billing already exist with the same billing ID");
				return "page_exception";
			}
			model.addAttribute("status", vaRegisterResponse.getStatus().getDescription());
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", vaRegisterResponse.getStatus().getMessage());
			model.addAttribute("description", vaRegisterResponse.getStatus().getDescription());
			return "page_exception";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (MalformedURLException | DatatypeConfigurationException | ParseException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/bankTransferPayment" }, method = RequestMethod.GET)
	public String transferFormRedirection(ModelMap model,
			@RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "ticketVA", required = true) String ticketVA) {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(ticketID);
			LoadVAByIDResponse loadVAByIDResponse = paymentPageProcessor.loadVAByID(ticketVA);
			if (loadVAByIDResponse.getVaRecord().size() == 0) {
				return "page_404";
			}

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(ticketID);

			IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
			vaMap.put(loadVAByIDResponse.getVaRecord().get(0).getId(), t);
			LoadMembersResponse lmr = paymentPageProcessor
					.loadMember(loadVAByIDResponse.getVaRecord().get(0).getParentUsername());
			model.addAttribute("paymentCode", loadVAByIDResponse.getVaRecord().get(0).getId());
			model.addAttribute("amount", loadVAByIDResponse.getVaRecord().get(0).getAmount());
			model.addAttribute("formattedAmount",
					Utils.formatAmount(ti.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("transactionAmount", ti.getTransactionAmount());
			model.addAttribute("formattedTransactionAmount",
					Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("totalFee", ti.getTotalFee());
			model.addAttribute("formattedTotalFee",
					Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("finalAmount", ti.getFinalAmount());
			model.addAttribute("formattedFinalAmount",
					Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("expiredAt", loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
			if (t.getEventID().equalsIgnoreCase("NA")) {
				model.addAttribute("eventName", "");
			} else {
				model.addAttribute("eventName",
						paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
			}

			model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
			model.addAttribute("username", lmr.getMembers().get(0).getUsername());
			model.addAttribute("description", loadVAByIDResponse.getVaRecord().get(0).getDescription());
			model.addAttribute("paymentChannel", ti.getPaymentChannel());
			tMap.delete(ticketID);
			amMap.delete(ticketID);
			return "bankTransferPayment";
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/retail" }, method = RequestMethod.POST)
	public String submitRetailForm(@Valid @ModelAttribute("retail") Transfer transfer, BindingResult result,
			ModelMap model) {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(transfer.getTicketID());

			VaRegisterResponse vaRegisterResponse = paymentPageProcessor.registerVABilling(t.getMerchantID(),
					transfer.getName(), transfer.getMsisdn(), transfer.getEmail(), transfer.getDescription(),
					transfer.getAmount(), Integer.valueOf(1), t.getEventID(), contextLoader.getPaymentVANotifURL(), 3);

			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
				model.addAttribute("ticketID", transfer.getTicketID());
				model.addAttribute("ticketVA", vaRegisterResponse.getTicketID());
				return "redirect:/retailPayment";
			}
			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("DUPLICATE_TRANSACTION")) {
				logger.error("[Ticket Not Found/Expired]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Duplicate Billing");
				model.addAttribute("description", "Your billing already exist with the same billing ID");
				return "page_exception";
			}
			model.addAttribute("status", vaRegisterResponse.getStatus().getDescription());
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", vaRegisterResponse.getStatus().getMessage());
			model.addAttribute("description", vaRegisterResponse.getStatus().getDescription());
			return "page_exception";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (MalformedURLException | DatatypeConfigurationException | ParseException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/retailPayment" }, method = RequestMethod.GET)
	public String retailFormRedirection(ModelMap model,
			@RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "ticketVA", required = true) String ticketVA) {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(ticketID);
			LoadVAByIDResponse loadVAByIDResponse = paymentPageProcessor.loadVAByID(ticketVA);
			if (loadVAByIDResponse.getVaRecord().size() == 0) {
				return "page_404";
			}

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(ticketID);

			IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
			vaMap.put(loadVAByIDResponse.getVaRecord().get(0).getId(), t);
			LoadMembersResponse lmr = paymentPageProcessor
					.loadMember(loadVAByIDResponse.getVaRecord().get(0).getParentUsername());
			model.addAttribute("paymentCode", loadVAByIDResponse.getVaRecord().get(0).getId());
			model.addAttribute("amount", loadVAByIDResponse.getVaRecord().get(0).getAmount());
			model.addAttribute("formattedAmount",
					Utils.formatAmount(ti.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("transactionAmount", ti.getTransactionAmount());
			model.addAttribute("formattedTransactionAmount",
					Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("totalFee", ti.getTotalFee());
			model.addAttribute("formattedTotalFee",
					Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("finalAmount", ti.getFinalAmount());
			model.addAttribute("formattedFinalAmount",
					Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("expiredAt", loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
			if (t.getEventID().equalsIgnoreCase("NA")) {
				model.addAttribute("eventName", "");
			} else {
				model.addAttribute("eventName",
						paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
			}

			model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
			model.addAttribute("username", lmr.getMembers().get(0).getUsername());
			model.addAttribute("description", loadVAByIDResponse.getVaRecord().get(0).getDescription());
			tMap.delete(ticketID);
			amMap.delete(ticketID);
			return "retailPayment";
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/qrPaymentForm" }, method = RequestMethod.POST)
	public String submitQRForm(@Valid @ModelAttribute("qrcode") Transfer transfer, BindingResult result,
			ModelMap model) {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(transfer.getTicketID());

			VaRegisterResponse vaRegisterResponse = paymentPageProcessor.registerVABilling(t.getMerchantID(),
					transfer.getName(), transfer.getMsisdn(), transfer.getEmail(), transfer.getDescription(),
					transfer.getAmount(), Integer.valueOf(1), t.getEventID(), contextLoader.getPaymentVANotifURL(), 4);

			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
				model.addAttribute("ticketID", transfer.getTicketID());
				model.addAttribute("ticketVA", vaRegisterResponse.getTicketID());
				return "redirect:/qrPayment";
			}
			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("DUPLICATE_TRANSACTION")) {
				logger.error("[Ticket Not Found/Expired]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Duplicate Billing");
				model.addAttribute("description", "Your billing already exist with the same billing ID");
				return "page_exception";
			}
			logger.error(vaRegisterResponse.getStatus().getDescription());
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", vaRegisterResponse.getStatus().getMessage());
			model.addAttribute("description", vaRegisterResponse.getStatus().getDescription());
			return "page_exception";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (MalformedURLException | DatatypeConfigurationException | ParseException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/qrPayment" }, method = RequestMethod.GET)
	public String qrFormRedirection(ModelMap model, @RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "ticketVA", required = true) String ticketVA) {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(ticketID);
			LoadVAByIDResponse loadVAByIDResponse = paymentPageProcessor.loadVAByID(ticketVA);
			if (loadVAByIDResponse.getVaRecord().size() == 0) {
				return "page_404";
			}

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(ticketID);

			QRCodeParam qrParam = new QRCodeParam();
			qrParam.setAmount(StringUtils.leftPad(ti.getFinalAmount().toString().replace(".", ""), 10, '0'));
			qrParam.setCity(t.getCity());
			String fee = StringUtils.leftPad(t.getFee().toString(), 10, '0') + "00";
			qrParam.setFee(fee);
			qrParam.setMerchantCriteria("UME");
			qrParam.setMerchantID(contextLoader.getLinkAjaMerchantID());
			qrParam.setMerchantName(t.getMerchantName());
			qrParam.setMerchantPan("93600911002" + StringUtils.right(contextLoader.getLinkAjaMerchantID(), 7));
			qrParam.setMerchantTrxID(loadVAByIDResponse.getVaRecord().get(0).getId());
			qrParam.setPostalCode(t.getPostalCode());
			qrParam.setPartnerMerchantID("");

			QRCodeResponse qrResponse = paymentPageProcessor.forwardQRPayment(qrParam);
			if (qrResponse.getResponseCode().equalsIgnoreCase("00")) {
				IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
				vaMap.put(loadVAByIDResponse.getVaRecord().get(0).getId(), t);
				LoadMembersResponse lmr = paymentPageProcessor
						.loadMember(loadVAByIDResponse.getVaRecord().get(0).getParentUsername());
				model.addAttribute("paymentCode", loadVAByIDResponse.getVaRecord().get(0).getId());
				model.addAttribute("amount", loadVAByIDResponse.getVaRecord().get(0).getAmount());
				model.addAttribute("formattedAmount",
						Utils.formatAmount(ti.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("transactionAmount", ti.getTransactionAmount());
				model.addAttribute("formattedTransactionAmount",
						Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("totalFee", ti.getTotalFee());
				model.addAttribute("formattedTotalFee",
						Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("finalAmount", ti.getFinalAmount());
				model.addAttribute("formattedFinalAmount",
						Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("expiredAt", loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
				if (t.getEventID().equalsIgnoreCase("NA")) {
					model.addAttribute("eventName", "");
				} else {
					model.addAttribute("eventName",
							paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
				}

				model.addAttribute("username", lmr.getMembers().get(0).getUsername());
				model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
				model.addAttribute("description", loadVAByIDResponse.getVaRecord().get(0).getDescription());
				model.addAttribute("qrcode", qrResponse.getQrString());
				amMap.delete(ticketID);
				tMap.delete(ticketID);
				return "qrCodePayment";
			}

			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "FAILED");
			model.addAttribute("description", qrResponse.getResponseMessage());
			return "page_exception";
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/felloForm" }, method = RequestMethod.POST)
	public String submitFelloForm(@Valid @ModelAttribute("fello") Transfer transfer, BindingResult result,
			ModelMap model) throws Exception {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(transfer.getTicketID());

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(transfer.getTicketID());

			VaRegisterResponse vaRegisterResponse = paymentPageProcessor.registerVABilling(t.getMerchantID(),
					transfer.getName(), transfer.getMsisdn(), transfer.getEmail(), transfer.getDescription(),
					transfer.getAmount(), Integer.valueOf(1), t.getEventID(), contextLoader.getPaymentVANotifURL(), 5);

			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
				model.addAttribute("ticketID", transfer.getTicketID());
				model.addAttribute("ticketVA", vaRegisterResponse.getTicketID());
				if (t.getEventID().equalsIgnoreCase("NA")) {
					model.addAttribute("eventName", "");
				} else {
					model.addAttribute("eventName",
							paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
				}

				LoadMembersResponse lmr = paymentPageProcessor.loadMember(t.getMerchantID());
				model.addAttribute("formattedTransactionAmount",
						Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("formattedTotalFee",
						Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("formattedFinalAmount",
						Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
				model.addAttribute("paymentChannel", transfer.getPaymentChannel());
				return "felloForm";
			}
			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("DUPLICATE_TRANSACTION")) {
				logger.error("[Ticket Not Found/Expired]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Duplicate Billing");
				model.addAttribute("description", "Your billing already exist with the same billing ID");
				return "page_exception";
			}
			logger.error(vaRegisterResponse.getStatus().getDescription());
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", vaRegisterResponse.getStatus().getMessage());
			model.addAttribute("description", vaRegisterResponse.getStatus().getDescription());
			return "page_exception";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (MalformedURLException | DatatypeConfigurationException | ParseException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/felloInquiry" }, method = RequestMethod.POST)
	public String submitFelloInquiry(@Valid @ModelAttribute("felloInquiry") FelloInquiryRequest fello,
			BindingResult result, ModelMap model) throws Exception {

		if (result.hasErrors()) {
			return "page_500";
		}
		logger.info("Ticket VA: " + fello.getTicketVA());
		logger.info("TIcket id: " + fello.getTicketID());

		IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
		Ticket t = tMap.get(fello.getTicketID());
		if (t == null) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		}

		IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
		Ticket ti = amMap.get(fello.getTicketID());
		if (ti == null) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		}

		ValidateCredentialResponse val = paymentPageProcessor.validateCredential(fello.getMsisdn(), fello.getPin(), 1);
		if (val.getStatus().getMessage().equalsIgnoreCase("VALID")) {
			IMap<String, String> otpMap = instance.getMap("OTPRequestMap");
			String otp = Utils.GenerateRandomNumber(6);

			otpMap.put(fello.getTicketVA(), otp);

			paymentPageProcessor.sendOTPMessage("62" + fello.getMsisdn().substring(1), otp);

			if (t.getEventID().equalsIgnoreCase("NA")) {
				model.addAttribute("eventName", "");
			} else {
				model.addAttribute("eventName",
						paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
			}

			LoadMembersResponse lmr = paymentPageProcessor.loadMember(t.getMerchantID());
			model.addAttribute("formattedTransactionAmount",
					Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("formattedTotalFee",
					Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("formattedFinalAmount",
					Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
			model.addAttribute("ticketID", fello.getTicketID());
			model.addAttribute("ticketVA", fello.getTicketVA());
			model.addAttribute("msisdn", fello.getMsisdn());
			model.addAttribute("paymentChannel", fello.getPaymentChannel());
			return "felloOTP";
		} else {
			logger.error("[Credential Not VALID]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", val.getStatus().getMessage());
			model.addAttribute("description", val.getStatus().getDescription());
			return "page_exception";
		}
	}

	@RequestMapping(value = { "/felloPayment" }, method = RequestMethod.POST)
	public String felloFormRedirection(@Valid @ModelAttribute("felloPayment") FelloPaymentRequest fello,
			BindingResult result, ModelMap model) {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, String> otpMap = instance.getMap("OTPRequestMap");
			String otp = otpMap.get(fello.getTicketVA());
			if (!otp.equalsIgnoreCase(fello.getOtp())) {
				logger.error("[OTP Failed]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Invalid OTP");
				model.addAttribute("description", "Expired/Invalid OTP");
				return "page_exception";
			}

			otpMap.delete(fello.getTicketVA());

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(fello.getTicketID());
			LoadVAByIDResponse loadVAByIDResponse = paymentPageProcessor.loadVAByID(fello.getTicketVA());
			if (loadVAByIDResponse.getVaRecord().size() == 0) {
				logger.error("[Ticket Not Found/Expired]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "TicketID Not Found");
				model.addAttribute("description", "Expired/Invalid TicketID");
				return "page_exception";
			}

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(fello.getTicketID());

			IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
			vaMap.put(loadVAByIDResponse.getVaRecord().get(0).getId(), t);

			LoadMembersResponse lmr = paymentPageProcessor
					.loadMember(loadVAByIDResponse.getVaRecord().get(0).getParentUsername());

			String trxNumber = Utils.GetDate("yyyyMMddhhmmss") + Utils.GenerateTransactionNumber();
			VaPaymentResponse payRes = paymentPageProcessor.paymentVA(loadVAByIDResponse.getVaRecord().get(0).getId(),
					trxNumber, ti.getFinalAmount(), fello.getMsisdn(), contextLoader.getFelloTransferTypeID());

			if (payRes.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
				model.addAttribute("paymentCode", loadVAByIDResponse.getVaRecord().get(0).getId());
				model.addAttribute("amount", loadVAByIDResponse.getVaRecord().get(0).getAmount());
				model.addAttribute("formattedAmount",
						Utils.formatAmount(ti.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("transactionAmount", ti.getTransactionAmount());
				model.addAttribute("formattedTransactionAmount",
						Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("totalFee", ti.getTotalFee());
				model.addAttribute("formattedTotalFee",
						Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("finalAmount", ti.getFinalAmount());
				model.addAttribute("formattedFinalAmount",
						Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("expiredAt", loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
				if (t.getEventID().equalsIgnoreCase("NA")) {
					model.addAttribute("eventName", "");
				} else {
					model.addAttribute("eventName",
							paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
				}

				model.addAttribute("username", lmr.getMembers().get(0).getUsername());
				model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
				model.addAttribute("description", loadVAByIDResponse.getVaRecord().get(0).getDescription());
				model.addAttribute("transactionDate", Utils.formatDate(payRes.getTransactionDate()));
				model.addAttribute("transactionNumber", payRes.getTransactionNumber());
				model.addAttribute("status", payRes.getStatus().getMessage());
				model.addAttribute("msisdn", fello.getMsisdn());
				model.addAttribute("ticketID", fello.getTicketID());
				model.addAttribute("redirectURL", contextLoader.getFelloRedirectURL());
				return "felloPayment";
			} else {
				logger.error("[Payment VA Failed]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", payRes.getStatus().getMessage());
				model.addAttribute("description", payRes.getStatus().getDescription());
				return "page_exception";
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/linkAjaForm" }, method = RequestMethod.POST)
	public String submitLinkAjaForm(@Valid @ModelAttribute("linkaja") DeepLinkPaymentRequest deeplink,
			BindingResult result, ModelMap model) {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(deeplink.getTicketID());

			VaRegisterResponse vaRegisterResponse = paymentPageProcessor.registerVABilling(t.getMerchantID(),
					deeplink.getName(), deeplink.getMsisdn(), deeplink.getEmail(), deeplink.getDescription(),
					deeplink.getAmount(), Integer.valueOf(1), t.getEventID(), contextLoader.getPaymentVANotifURL(), 7);

			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
				model.addAttribute("ticketID", deeplink.getTicketID());
				model.addAttribute("ticketVA", vaRegisterResponse.getTicketID());
				return "redirect:/linkAjaPayment";
			}
			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("DUPLICATE_TRANSACTION")) {
				logger.error("[Ticket Not Found/Expired]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Duplicate Billing");
				model.addAttribute("description", "Your billing already exist with the same billing ID");
				return "page_exception";
			}
			logger.error(vaRegisterResponse.getStatus().getDescription());
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", vaRegisterResponse.getStatus().getMessage());
			model.addAttribute("description", vaRegisterResponse.getStatus().getDescription());
			return "page_exception";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (MalformedURLException | DatatypeConfigurationException | ParseException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/linkAjaPayment" }, method = RequestMethod.GET)
	public String linkAjaPaymentRedirection(ModelMap model,
			@RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "ticketVA", required = true) String ticketVA) {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(ticketID);
			LoadVAByIDResponse loadVAByIDResponse = paymentPageProcessor.loadVAByID(ticketVA);
			if (loadVAByIDResponse.getVaRecord().size() == 0) {
				return "page_404";
			}

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(ticketID);

			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHMMSS");

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			DeepLinkRequest param = new DeepLinkRequest();
			param.setItems("");
			param.setMerchantID(contextLoader.getLinkAjaDeepLinkMerchantID());
			param.setPartnerAppLink("");
			param.setPartnerTrxID("jpa01_" + loadVAByIDResponse.getVaRecord().get(0).getId());
			param.setRefData("");
			param.setTerminalID("pg_01");
			param.setTerminalName("Payment Gateway");
			param.setTotalAmount(ti.getFinalAmount().toString());
			param.setTrxDate(sdf.format(timestamp));

			DeepLinkResponse resp = paymentPageProcessor.forwardDeepLink(param);
			if (resp.getStatus().equalsIgnoreCase("00")) {
				IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
				vaMap.put(loadVAByIDResponse.getVaRecord().get(0).getId(), t);
				LoadMembersResponse lmr = paymentPageProcessor
						.loadMember(loadVAByIDResponse.getVaRecord().get(0).getParentUsername());
				model.addAttribute("paymentCode", loadVAByIDResponse.getVaRecord().get(0).getId());
				model.addAttribute("amount", loadVAByIDResponse.getVaRecord().get(0).getAmount());
				model.addAttribute("formattedAmount",
						Utils.formatAmount(ti.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("transactionAmount", ti.getTransactionAmount());
				model.addAttribute("formattedTransactionAmount",
						Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("totalFee", ti.getTotalFee());
				model.addAttribute("formattedTotalFee",
						Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("finalAmount", ti.getFinalAmount());
				model.addAttribute("formattedFinalAmount",
						Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
				model.addAttribute("expiredAt", loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
				if (t.getEventID().equalsIgnoreCase("NA")) {
					model.addAttribute("eventName", "");
				} else {
					model.addAttribute("eventName",
							paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
				}

				model.addAttribute("username", lmr.getMembers().get(0).getUsername());
				model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
				model.addAttribute("description", loadVAByIDResponse.getVaRecord().get(0).getDescription());
				model.addAttribute("applink", resp.getUrl());
				amMap.delete(ticketID);
				tMap.delete(ticketID);
				return "linkAjaToRedirect";
			}

			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "FAILED");
			model.addAttribute("description", resp.getMessage());
			return "page_exception";
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/paymentVANotification" }, method = RequestMethod.POST)
	public String paymentVANotification(@RequestParam(value = "paymentCode", required = true) String paymentCode,
			@RequestParam(value = "amount", required = true) String amount,
			@RequestParam(value = "transactionNumber", required = true) String transactionNumber,
			@RequestParam(value = "notificationDate", required = true) String notificationDate, ModelMap model) {
		try {
			logger.info("[VA Notification Request : " + paymentCode + "]");
			IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
			Ticket t = vaMap.get(paymentCode);
			String res = paymentPageProcessor.sendVANotification(t);
			logger.info("[VA Notification Response : " + res + "]");
			vaMap.delete(paymentCode);
			return "OK";
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/paymentNotification" }, method = RequestMethod.POST)
	public String paymentNotification(@RequestParam(value = "MALLID", required = true) String mallID,
			@RequestParam(value = "AMOUNT", required = true) String amount,
			@RequestParam(value = "TRANSIDMERCHANT", required = true) String transid,
			@RequestParam(value = "SESSIONID", required = true) String sessionID, ModelMap model) {
		try {
			logger.info("[NOTIFY : MallID : " + mallID + "Amount : " + amount + "TransID : " + transid + "SessionID : "
					+ sessionID + "]");
			return "OK";
		} catch (Exception ex) {
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	// LinkAja DeepLink Notification
	@ResponseBody
	@RequestMapping({ "/linkaja/notification" })
	public LinkAjaNotificationResponse linkajaNotification(HttpEntity<String> httpEntity) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException, JSONException, ParseException, IOException {
		LinkAjaNotificationResponse resNotif = new LinkAjaNotificationResponse();

		String json = httpEntity.getBody();
		logger.info("Authorization: " + httpEntity.getHeaders().getFirst("Authorization") + "/Timestamp: "
				+ httpEntity.getHeaders().get("Timestamp") + "Body: " + json);
		String auth = new String(
				Base64.getDecoder().decode(httpEntity.getHeaders().getFirst("Authorization").replace("Basic ", "")));

		if (auth.split(":")[0].equalsIgnoreCase(contextLoader.getLinkAjaDeepLinkUsername())
				&& auth.split(":")[1].equalsIgnoreCase(contextLoader.getLinkAjaDeepLinkPassword())) {
			String decode = AESSecurity.decrypt(json, contextLoader.getLinkAjaDeepLinkEncryptKey(),
					httpEntity.getHeaders().getFirst("Timestamp"));

			JSONObject jsonObject = new JSONObject(decode);
			if (jsonObject.get("status") == "00") {
				Number number = NumberFormat.getInstance().parse(jsonObject.get("totalAmount").toString());
				VaPaymentResponse payRes = paymentPageProcessor.paymentVA(jsonObject.get("partnerTrxID").toString(),
						jsonObject.get("linkAjaRefnum").toString(), number, contextLoader.getLinkAjaUsername(),
						contextLoader.getLinkAjaTransferTypeID());
				if (payRes.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {

					IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
					Ticket t = vaMap.get(jsonObject.get("partnerTrxID"));
					if (t.getMerchantID() == null) {
						logger.error("[Ticket Not Found/Expired]");
						resNotif.setNotificationMessage("Expired/Invalid Trx ID");
						resNotif.setResponseCode("01");
						resNotif.setTransactionID(jsonObject.get("linkAjaRefnum").toString());
						return resNotif;
					}

					String res = paymentPageProcessor.sendVALinkAjaNotification(t,
							jsonObject.get("linkAjaRefnum").toString());
					logger.info("[VA Notification Response : " + res + "]");
					// vaMap.delete(req.getTrx_id());
					resNotif.setNotificationMessage("Success");
					resNotif.setResponseCode("00");
					resNotif.setTransactionID(jsonObject.get("linkAjaRefnum").toString());
					return resNotif;
				}
				logger.error("RC " + payRes.getStatus().getResponseCode() + " : " + payRes.getStatus().getMessage());
				resNotif.setNotificationMessage(payRes.getStatus().getMessage());
				resNotif.setResponseCode("02");
				resNotif.setTransactionID(jsonObject.get("linkAjaRefnum").toString());
				return resNotif;
			}
			return null;
		}
		return null;
	}

	// QRIS LinkAja Notification
	@ResponseBody
	@RequestMapping({ "/linkaja/paymentNotification" })
	public LinkAjaNotificationResponse linkajaPaymentNotification(@RequestBody LinkAjaNotificationRequest req)
			throws JsonProcessingException {
		LinkAjaNotificationResponse resNotif = new LinkAjaNotificationResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.info("Req: " + mapper.writeValueAsString(req));
			if (!req.getMerchant().equalsIgnoreCase(contextLoader.getLinkAjaMerchantID())) {
				logger.error("[Authentication Failed]");
				resNotif.setNotificationMessage("Unauthorized Access");
				resNotif.setResponseCode("03");
				resNotif.setTransactionID(req.getTrx_id());
				logger.info("[" + resNotif.toString() + "]");
				return resNotif;
			}

			IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
			Ticket t = vaMap.get(req.getMsg());
			if (t.getMerchantID() == null) {
				logger.error("[Ticket Not Found/Expired]");
				resNotif.setNotificationMessage("Expired/Invalid Trx ID");
				resNotif.setResponseCode("01");
				resNotif.setTransactionID(req.getTrx_id());
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}
			String trxNumber = Utils.GetDate("yyyyMMddhhmmss") + Utils.GenerateTransactionNumber();
			VaPaymentResponse payRes = paymentPageProcessor.paymentVA(req.getMsg(), trxNumber, req.getAmount(),
					contextLoader.getLinkAjaUsername(), contextLoader.getLinkAjaTransferTypeID());
			if (payRes.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
				String res = paymentPageProcessor.sendVALinkAjaNotification(t, trxNumber);
				logger.info("[VA Notification Response : " + res + "]");
				vaMap.delete(req.getTrx_id());
				resNotif.setNotificationMessage("Success");
				resNotif.setResponseCode("00");
				resNotif.setTransactionID(req.getTrx_id());
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}
			logger.error("RC " + payRes.getStatus().getResponseCode() + " : " + payRes.getStatus().getMessage());
			resNotif.setNotificationMessage(payRes.getStatus().getMessage());
			resNotif.setResponseCode("02");
			resNotif.setTransactionID(req.getTrx_id());
			logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
			return resNotif;
		} catch (Exception ex) {
			ex.printStackTrace();
			resNotif.setNotificationMessage(
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
			resNotif.setResponseCode("05");
			resNotif.setTransactionID(req.getTrx_id());
			logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
		}
		return resNotif;
	}

	@ResponseBody
	@RequestMapping(value = { "/checkStatus" }, method = RequestMethod.POST)
	public String paymentCheckStatus(@RequestParam(value = "merchantID", required = true) String merchantID,
			@RequestParam(value = "invoiceID", required = true) String invoiceID,
			@RequestParam(value = "amount", required = true) String amount,
			@RequestParam(value = "callback", required = true) String callback,
			@RequestParam(value = "words", required = true) String words,
			@RequestParam(value = "sessionID", required = true) String sessionID, HttpServletRequest req) {
		logger.info("[Check Status : MID : " + merchantID + " InvoiceID : " + invoiceID + " SessionID : " + sessionID
				+ "]");
		String sID = merchantID + invoiceID + sessionID;
		try {
			IMap<String, Ticket> sMap = instance.getMap("PaymentSessionMap");
			Ticket t = sMap.get(sID);
			if (!req.getRemoteAddr().equalsIgnoreCase(t.getIpAddress())) {
				return "FORBIDDEN";
			}
			if (t.getWords().equalsIgnoreCase(words)) {
				if (t.getStatus() == null) {
					return "PENDING";
				}
				return t.getStatus();
			}

			return "INVALID_WORDS";
		} catch (NullPointerException ex) {
		}
		return "TICKET_NOT_FOUND";
	}

	// Fello, Direct Debit Redirection
	@RequestMapping(value = { "/paymentRedirect" }, method = RequestMethod.GET)
	public String paymentRedirect(@RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "msisdn", required = true) String msisdn,
			@RequestParam(value = "transactionNumber", required = false) String transactionNumber,
			@RequestParam(value = "status", required = true) String status, ModelMap model, HttpServletRequest req)
			throws Exception {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = (Ticket) tMap.get(ticketID);

			IMap<String, Ticket> vaMap = instance.getMap("PaymentAmountMap");
			Ticket ti = (Ticket) vaMap.get(ticketID);

			logger.info("[Payment IP Address : " + req.getRemoteAddr() + "]");
			if (!t.getIpAddress().equalsIgnoreCase(req.getRemoteAddr())) {
				logger.error("[IP Address Violation]");
				model.addAttribute("httpResponseCode", "403");
				model.addAttribute("status", "Forbidden");
				model.addAttribute("description", "Invalid RemoteAddress");
				return "page_exception";
			}

			CredentialResponse cr = paymentPageProcessor.loadCredential(t.getMerchantID(), Integer.valueOf(2));
			String rawhashing = "";
			rawhashing = t.getMerchantID() + t.getInvoiceID() + ti.getFinalAmount() + t.getCallback()
					+ cr.getCredential();

			String sha256hex = DigestUtils.sha256Hex(rawhashing);

			logger.info("Words: " + sha256hex);

			String sessionMap = t.getMerchantID() + t.getInvoiceID() + t.getSessionID();
			if (status.equalsIgnoreCase("PROCESSED")) {
				t.setPaymentChannel(t.getPaymentChannel());
				t.setStatus("PROCESSED");
				model.addAttribute("merchantID", t.getMerchantID());
				model.addAttribute("invoiceID", t.getInvoiceID());
				model.addAttribute("amount", ti.getFinalAmount());
				model.addAttribute("sessionID", t.getSessionID());
				model.addAttribute("currency", t.getCurrency());
				model.addAttribute("transactionNumber", transactionNumber);
				model.addAttribute("name", t.getName());
				model.addAttribute("email", t.getEmail());
				model.addAttribute("msisdn", t.getMsisdn());
				model.addAttribute("description", t.getDescription());
				model.addAttribute("paymentChannel", t.getPaymentChannel());
				model.addAttribute("ticketID", ticketID);
				model.addAttribute("words", sha256hex);
				model.addAttribute("status", "PROCESSED");
				paymentPageProcessor.sendMessage(msisdn, t.getMerchantID(), "Payment Received " + t.getDescription(),
						"You have received a payment "
								+ Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-")
								+ " using Credit Card from " + t.getName() + " (" + t.getEmail() + ") with Invoice ID "
								+ t.getInvoiceID());
			} else {
				logger.info("[VOID Status ResponseCode : FAILED ]");
				t.setStatus("FAILED");
				model.addAttribute("merchantID", t.getMerchantID());
				model.addAttribute("invoiceID", t.getInvoiceID());
				model.addAttribute("amount", ti.getFinalAmount());
				model.addAttribute("sessionID", t.getSessionID());
				model.addAttribute("currency", t.getCurrency());
				model.addAttribute("paymentChannel", t.getPaymentChannel());
				model.addAttribute("ticketID", ticketID);
				model.addAttribute("words", sha256hex);
				model.addAttribute("status", "FAILED");
				model.addAttribute("description", "Something isn't quite right, We were reversing your payment...");
			}

			IMap<String, Ticket> sMap = instance.getMap("PaymentSessionMap");
			sMap.put(sessionMap, t);
			return "merchantRedirect";
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		}
	}

	// Credit Card Payment Redirection
	@RequestMapping(value = { "/paymentRedirection" }, method = RequestMethod.POST)
	public String paymentRedirection(@RequestParam(value = "AMOUNT", required = true) String amount,
			@RequestParam(value = "TRANSIDMERCHANT", required = true) String transID,
			@RequestParam(value = "SESSIONID", required = true) String sessionID,
			@RequestParam(value = "WORDS", required = true) String words,
			@RequestParam(value = "PAYMENTCHANNEL", required = true) String paymentChannel,
			@RequestParam(value = "STATUSCODE", required = true) String status, ModelMap model) throws IOException {
		try {
			logger.info("[REDIRECT Status : " + status + "]");
			String calculateWords = DigestUtils.sha1Hex(amount + contextLoader.getDokuSharedKey() + transID + status);
			if (calculateWords.compareTo(words) != 0) {
				logger.error("[Invalid Redirect Words]");
				model.addAttribute("httpResponseCode", "403");
				model.addAttribute("status", "FORBIDDEN ACCESS");
				model.addAttribute("description", "Security Violation");
				return "page_exception";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = (Ticket) tMap.get(sessionID);

			IMap<String, Ticket> vaMap = instance.getMap("PaymentAmountMap");
			Ticket ti = (Ticket) vaMap.get(sessionID);

			CredentialResponse cr = paymentPageProcessor.loadCredential(t.getMerchantID(), Integer.valueOf(2));
			String rawhashing = "";
			rawhashing = t.getMerchantID() + t.getInvoiceID() + ti.getFinalAmount() + t.getCallback()
					+ cr.getCredential();

			String sha256hex = DigestUtils.sha256Hex(rawhashing);

			logger.info("Words: " + sha256hex + "Request Words: " + words);

			String sessionMap = t.getMerchantID() + t.getInvoiceID() + t.getSessionID();
			if (status.equalsIgnoreCase("0000")) {
				// add code to create billing va di table billing_va
				PaymentResponse pr = paymentPageProcessor.doPayment(sessionID, t.getMerchantID(), t.getInvoiceID(),
						t.getDescription(), ti.getFinalAmount());
				if (pr.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
					t.setPaymentChannel(Integer.valueOf(1));
					t.setStatus(pr.getStatus().getMessage());
					model.addAttribute("merchantID", t.getMerchantID());
					model.addAttribute("invoiceID", t.getInvoiceID());
					model.addAttribute("amount", ti.getFinalAmount());
					model.addAttribute("sessionID", t.getSessionID());
					model.addAttribute("currency", t.getCurrency());
					model.addAttribute("transactionNumber", pr.getTransactionNumber());
					model.addAttribute("name", t.getName());
					model.addAttribute("email", t.getEmail());
					model.addAttribute("msisdn", t.getMsisdn());
					model.addAttribute("description", t.getDescription());
					model.addAttribute("paymentChannel", t.getPaymentChannel());
					model.addAttribute("ticketID", sessionID);
					model.addAttribute("words", sha256hex);
					model.addAttribute("status", pr.getStatus().getMessage());
					paymentPageProcessor.sendToSettlement(pr, ti.getFinalAmount());
					paymentPageProcessor.sendMessage(pr.getFromMember().getUsername(), pr.getToMember().getUsername(),
							"Payment Received " + t.getDescription(),
							"You have received a payment "
									+ Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-")
									+ " using Credit Card from " + t.getName() + " (" + t.getEmail()
									+ ") with Invoice ID " + t.getInvoiceID());
				} else {
					logger.info("[Credit to Merchant Failed, VOIDING Transaction For MID : " + t.getMerchantID()
							+ " With Invoice : " + transID + "]");
					String responseVoid = paymentPageProcessor.sendVoid(transID, sessionID);
					logger.info("[VOID Status ResponseCode : " + responseVoid + "]");
					t.setStatus("FAILED");
					model.addAttribute("merchantID", t.getMerchantID());
					model.addAttribute("invoiceID", t.getInvoiceID());
					model.addAttribute("amount", ti.getFinalAmount());
					model.addAttribute("sessionID", t.getSessionID());
					model.addAttribute("currency", t.getCurrency());
					model.addAttribute("paymentChannel", t.getPaymentChannel());
					model.addAttribute("ticketID", sessionID);
					model.addAttribute("words", sha256hex);
					model.addAttribute("status", "FAILED");
					model.addAttribute("description", "Something isn't quite right, We were reversing your payment...");
				}
			} else {
				logger.info("[Debit to Customer Failed, VOIDING Transaction For MID : " + t.getMerchantID()
						+ " With Invoice : " + transID + "]");
				String responseVoid = paymentPageProcessor.sendVoid(transID, sessionID);
				logger.info("[VOID Status ResponseCode : " + responseVoid + "]");
				t.setStatus("FAILED");
				model.addAttribute("merchantID", t.getMerchantID());
				model.addAttribute("invoiceID", t.getInvoiceID());
				model.addAttribute("amount", ti.getFinalAmount());
				model.addAttribute("sessionID", t.getSessionID());
				model.addAttribute("eventID", t.getEventID());
				model.addAttribute("currency", t.getCurrency());
				model.addAttribute("paymentChannel", t.getPaymentChannel());
				model.addAttribute("ticketID", sessionID);
				model.addAttribute("words", sha256hex);
				model.addAttribute("status", "FAILED");
				model.addAttribute("description",
						"Oops! Your payment was failed, please consult with your bank and try again");
			}
			IMap<String, Ticket> sMap = instance.getMap("PaymentSessionMap");
			sMap.put(sessionMap, t);
			return "merchantRedirect";
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("[Payment Failed, VOIDING Transaction For SESSIONID : " + sessionID + " With Invoice : "
					+ transID + "]");
			String responseVoid = paymentPageProcessor.sendVoid(transID, sessionID);
			logger.info("[VOID Status ResponseCode : " + responseVoid + "]");
			model.addAttribute("status", "FAILED");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("description", "Something isn't quite right, We were reversing your payment...");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/merchantRedirection" }, method = RequestMethod.POST)
	public ResponseEntity<Object> redirectToExternalUrl(
			@RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "merchantID", required = true) String merchantID,
			@RequestParam(value = "invoiceID", required = true) String invoiceID,
			@RequestParam(value = "amount", required = true) String amount,
			@RequestParam(value = "sessionID", required = false) String sessionID,
			@RequestParam(value = "eventID", required = false) String eventID,
			@RequestParam(value = "currency", required = false) String currency,
			@RequestParam(value = "paymentChannel", required = false) String paymentChannel,
			@RequestParam(value = "words", required = true) String words,
			@RequestParam(value = "status", required = true) String status) throws URISyntaxException {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(ticketID);
			logger.info("[Processing Notification On MID : " + t.getMerchantID() + "]");
			logger.info("[CALLBACK URL : " + t.getCallback() + "]");
			URI url = new URI(t.getCallback());
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(url);
			httpHeaders.set("status", status);
			return new ResponseEntity<>(httpHeaders, HttpStatus.TEMPORARY_REDIRECT);
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			URI url = new URI("/payment/page_exception");
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(url);
			return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = { "/redirectedPostToPost" }, method = RequestMethod.POST)
	public ModelAndView redirectedPostToPost(@RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "merchantID", required = true) String merchantID,
			@RequestParam(value = "invoiceID", required = true) String invoiceID,
			@RequestParam(value = "amount", required = true) String amount,
			@RequestParam(value = "sessionID", required = false) String sessionID,
			@RequestParam(value = "currency", required = false) String currency,
			@RequestParam(value = "paymentChannel", required = false) String paymentChannel,
			@RequestParam(value = "words", required = true) String words,
			@RequestParam(value = "status", required = true) String status, Model model) {
		model.addAttribute("merchantID", merchantID);
		model.addAttribute("invoiceID", invoiceID);
		model.addAttribute("amount", amount);
		model.addAttribute("sessionID", sessionID);
		model.addAttribute("currency", currency);
		model.addAttribute("paymentChannel", paymentChannel);
		model.addAttribute("ticketID", ticketID);
		model.addAttribute("words", words);
		model.addAttribute("status", status);

		return new ModelAndView("testRedirection");
	}

	@RequestMapping(value = { "/qrcode" }, method = RequestMethod.GET)
	public void qrcode(ModelMap model, @RequestParam(value = "data", required = true) String qrString,
			HttpServletResponse response) throws Exception {
		logger.info("QR STRING: " + qrString);
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(QRCodeHelper.getQRCodeImage(qrString, 350, 350));
		outputStream.flush();
		outputStream.close();
	}

	@RequestMapping(value = { "/transactionInquiry" }, method = RequestMethod.POST)
	public String transactionInquiry(
			@Valid @ModelAttribute("transactionInquiry") TransactionInquiryRequest transactionInq, BindingResult result,
			ModelMap model) throws Exception {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(transactionInq.getTicketID());

			InquiryRequest inqReq = new InquiryRequest();
			inqReq.setAmount(transactionInq.getAmount());
			inqReq.setToMember(t.getMerchantID());
			inqReq.setFromMember(contextLoader.getIPGUsername());

			LoadMembersResponse lmr = paymentPageProcessor.loadMember(t.getMerchantID());

			LoadPaymentChannelByMemberIDResponse ch = paymentPageProcessor
					.loadPaymentChannelByMember(lmr.getMembers().get(0).getUsername());

			for (int i = 0; i < ch.getPaymentChannel().size(); i++) {
				if (ch.getPaymentChannel().get(i).getId() == transactionInq.getPaymentChannel()) {
					inqReq.setTransferTypeID(ch.getPaymentChannel().get(i).getTransferTypeID());

					InquiryResponse inqRes = paymentPageProcessor.validateTransactionInquiry(inqReq);

					if (inqRes.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
						model.addAttribute("paymentChannel", transactionInq.getPaymentChannel());
						model.addAttribute("ticketID", transactionInq.getTicketID());
						model.addAttribute("amount", transactionInq.getAmount());
						model.addAttribute("formattedAmount",
								Utils.formatAmount(transactionInq.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
						model.addAttribute("transactionAmount", new BigDecimal(
								inqRes.getTransactionAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						model.addAttribute("formattedTransactionAmount",
								Utils.formatAmount(inqRes.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
						model.addAttribute("totalFee",
								new BigDecimal(inqRes.getTotalFees().setScale(0, RoundingMode.UP).toString() + ".00"));
						model.addAttribute("formattedTotalFee", Utils.formatAmount(
								inqRes.getTotalFees().setScale(0, RoundingMode.UP), ".", ",", "#,##0.00", "Rp.", ",-"));
						model.addAttribute("finalAmount", new BigDecimal(
								inqRes.getFinalAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						model.addAttribute("formattedFinalAmount",
								Utils.formatAmount(inqRes.getFinalAmount().setScale(0, RoundingMode.UP), ".", ",",
										"#,##0.00", "Rp.", ",-"));
						if (t.getEventID().equalsIgnoreCase("NA")) {
							model.addAttribute("eventName", "");
						} else {
							model.addAttribute("eventName",
									((VaEvent) paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0))
											.getDescription());
						}
						model.addAttribute("eventOrganizer", ((Members) lmr.getMembers().get(0)).getName());
						model.addAttribute("description", t.getDescription());
						model.addAttribute("email", transactionInq.getEmail());
						model.addAttribute("msisdn", t.getMsisdn());
						model.addAttribute("name", transactionInq.getName());

						IMap<String, Ticket> vaMap = instance.getMap("PaymentAmountMap");
						Ticket ti = new Ticket();
						ti.setTransferTypeID(ch.getPaymentChannel().get(i).getTransferTypeID());
						ti.setAmount(transactionInq.getAmount());
						ti.setTotalFee(
								new BigDecimal(inqRes.getTotalFees().setScale(0, RoundingMode.UP).toString() + ".00"));
						ti.setFinalAmount(new BigDecimal(
								inqRes.getFinalAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						ti.setTransactionAmount(new BigDecimal(inqRes.getTransactionAmount().toString() + ".00"));
						ti.setPaymentChannel(transactionInq.getPaymentChannel());
						vaMap.put(transactionInq.getTicketID(), ti);
					} else {
						model.addAttribute("status", inqRes.getStatus().getDescription());
						model.addAttribute("httpResponseCode", "404");
						model.addAttribute("status", inqRes.getStatus().getMessage());
						model.addAttribute("description", inqRes.getStatus().getDescription());
						return "page_exception";
					}
				}
			}
			return "transactionInquiry";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/transactionRedirect" }, method = RequestMethod.POST)
	public String transactionRedirect(
			@Valid @ModelAttribute("transactionInquiry") TransactionInquiryRequest transactionInq, Model model,
			HttpServletRequest req) throws Exception {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(transactionInq.getTicketID());

			IMap<String, Ticket> vaMap = instance.getMap("PaymentAmountMap");
			Ticket ti = vaMap.get(transactionInq.getTicketID());

			LoadMembersResponse lmr = paymentPageProcessor.loadMember(t.getMerchantID());
			CreditCardParam response = paymentPageProcessor.forwardCreditCardPayment(transactionInq.getTicketID(),
					t.getInvoiceID(), t.getName(), t.getEmail(), ti.getFinalAmount(), t.getDescription());
			if (t.getEventID().equalsIgnoreCase("NA")) {
				model.addAttribute("eventName", "");
			} else {
				model.addAttribute("eventName",
						paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
			}

			model.addAttribute("username", lmr.getMembers().get(0).getUsername());
			model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
			model.addAttribute("description", t.getDescription());
			model.addAttribute("mallID", response.getMallID());
			model.addAttribute("chainMerchant", response.getChainMerchant());
			model.addAttribute("amount", response.getAmount());
			model.addAttribute("formattedAmount",
					Utils.formatAmount(response.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
			model.addAttribute("transactionAmount", transactionInq.getTransactionAmount());
			model.addAttribute("totalFee", transactionInq.getTotalFee());
			model.addAttribute("finalAmount", transactionInq.getFinalAmount());
			model.addAttribute("transID", response.getTransID());
			model.addAttribute("words", response.getWords());
			model.addAttribute("requestDate", response.getRequestDate());
			model.addAttribute("sessionID", response.getSessionID());
			model.addAttribute("email", response.getEmail());
			model.addAttribute("msisdn", t.getMsisdn());
			model.addAttribute("name", response.getName());
			model.addAttribute("currency", response.getCurrency());
			model.addAttribute("basket", response.getBasket());
			model.addAttribute("receiveURL", contextLoader.getReceiveURL());
			model.addAttribute("ticketID", transactionInq.getTicketID());
			model.addAttribute("transferTypeID", ti.getTransferTypeID());
			model.addAttribute("paymentChannel", transactionInq.getPaymentChannel());

			if (transactionInq.getPaymentChannel().intValue() == 1) {
				logger.info("--KARTU KREDIT--");
				return "creditCardRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 2) {
				logger.info("--TRANSFER BANK MANDIRI--");
				return "bankTransferRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 3) {
				logger.info("--GERAI RETAIL--");
				return "retailRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 4) {
				logger.info("--PEMBAYARAN QRIS--");
				return "qrCodeRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 5) {
				logger.info("--FELLO EMONEY--");
				return "felloRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 6) {
				logger.info("--TRANSFER BANK BCA--");
				return "bankTransferRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 7) {
				logger.info("--LINKAJA DEEP LINK--");
				return "linkAjaRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 8) {
				logger.info("--DIRECT DEBIT--");
				return "directDebitRedirect";
			}
			logger.error("[Payment Channel Not Found]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "Payment Not Available");
			model.addAttribute("description", "Payment Not Available");
			return "page_exception";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (IOException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@ResponseBody
	@RequestMapping(value = { "/merchantTransactionInquiry" }, method = RequestMethod.POST)
	public TransactionInquiryResponse merchantTransactionInquiry(
			@RequestParam(value = "merchantID", required = true) String merchantID,
			@RequestParam(value = "words", required = true) String words,
			@RequestParam(value = "invoiceID", required = true) String invoiceID,
			@RequestParam(value = "ticketID", required = true) String ticketID,
			@RequestParam(value = "amount", required = true) BigDecimal amount,
			@RequestParam(value = "paymentChannel", required = true) Integer paymentChannel,
			@RequestParam(value = "sessionID", required = true) String sessionID, HttpServletRequest req)
			throws MalformedURLException {
		logger.info("[Merchant Transaction Inquiry : MID : " + merchantID + " InvoiceID : " + invoiceID
				+ " SessionID : " + sessionID + "]");
		String sID = merchantID + invoiceID + sessionID;

		TransactionInquiryResponse tInqRes = new TransactionInquiryResponse();
		try {
			IMap<String, Ticket> sMap = instance.getMap("PaymentSessionMap");
			Ticket st = sMap.get(sID);

			if (!req.getRemoteAddr().equalsIgnoreCase(st.getIpAddress())) {
				tInqRes.setStatus("FORBIDDEN");
			} else if (st.getWords().equalsIgnoreCase(words)) {
				IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
				Ticket t = tMap.get(ticketID);

				InquiryRequest inqReq = new InquiryRequest();
				inqReq.setAmount(amount);
				inqReq.setToMember(t.getMerchantID());
				inqReq.setFromMember(contextLoader.getIPGUsername());

				LoadPaymentChannelByMemberIDResponse ch = paymentPageProcessor
						.loadPaymentChannelByMember(t.getMerchantID());

				for (int i = 0; i < ch.getPaymentChannel().size(); i++) {
					if (ch.getPaymentChannel().get(i).getId() == paymentChannel) {
						inqReq.setTransferTypeID(ch.getPaymentChannel().get(i).getTransferTypeID());

						InquiryResponse inqRes = paymentPageProcessor.validateTransactionInquiry(inqReq);
						IMap<String, Ticket> vaMap = instance.getMap("PaymentAmountMap");
						Ticket ti = new Ticket();
						ti.setTransferTypeID(ch.getPaymentChannel().get(i).getTransferTypeID());
						ti.setAmount(amount);
						ti.setTotalFee(
								new BigDecimal(inqRes.getTotalFees().setScale(0, RoundingMode.UP).toString() + ".00"));
						ti.setFinalAmount(new BigDecimal(
								inqRes.getFinalAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						ti.setTransactionAmount(new BigDecimal(
								inqRes.getTransactionAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						ti.setPaymentChannel(paymentChannel);
						vaMap.put(ticketID, ti);

						tInqRes.setStatus("PROCESSED");
						tInqRes.setFinalAmount(new BigDecimal(
								inqRes.getFinalAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
						tInqRes.setPaymentChannel(paymentChannel);
						tInqRes.setTicketID(ticketID);
						tInqRes.setTotalFee(
								new BigDecimal(inqRes.getTotalFees().setScale(0, RoundingMode.UP).toString() + ".00"));
						tInqRes.setTransactionAmount(new BigDecimal(
								inqRes.getTransactionAmount().setScale(0, RoundingMode.UP).toString() + ".00"));
					}
				}
			}

			return tInqRes;
		} catch (NullPointerException ex) {
			tInqRes.setStatus("TICKET_NOT_FOUND");
		}
		return tInqRes;
	}

	@RequestMapping(value = { "/directDebitRegistration" }, method = RequestMethod.POST)
	public String submitDirectDebitRegistration(
			@Valid @ModelAttribute("directDebitRegistration") DirectDebitInqRequest directDebit, BindingResult result,
			ModelMap model) throws Exception {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(directDebit.getTicketID());

			IMap<String, String> dtmap = instance.getMap("TicketIDMap");
			String key = "JAK" + Utils.GenerateRandomNumber(32);
			dtmap.put(key, directDebit.getTicketID());

			additionalData add = new additionalData();
			add.setUserID(t.getMsisdn());
			add.setEmail(t.getEmail());
			add.setMobileNumber(t.getMsisdn());

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(add);

			String signature = contextLoader.getDirectDebitTokenRequestorID() + contextLoader.getDirectDebitMerchantID()
					+ contextLoader.getDirectDebitTerminalID() + contextLoader.getDirectDebitPublicKey() + key + key;

			model.addAttribute("jwt", paymentPageProcessor.getTokenDirectDebit());
			model.addAttribute("requestID", key);
			model.addAttribute("journeyID", key);
			model.addAttribute("tokenRequestorID", contextLoader.getDirectDebitTokenRequestorID());
			model.addAttribute("merchantID", contextLoader.getDirectDebitMerchantID());
			model.addAttribute("terminalID", contextLoader.getDirectDebitTerminalID());
			model.addAttribute("additionalData", json);
			model.addAttribute("publicKey", contextLoader.getDirectDebitPublicKey());
			model.addAttribute("signature",
					Utils.hmacSHA512Encrypt(signature, contextLoader.getDirectDebitSecretKey()));
			model.addAttribute("url", contextLoader.getDirectDebitRegistrationURL());
			model.addAttribute("ticketID", directDebit.getTicketID());

			String valCards = ipgValidation.validateCards(t.getMsisdn(), 1);

			if (valCards == null) {
				return "directDebitRegistrationRedirect";
			} else {
				return "directDebitPurchaseForm";
			}
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		}
	}

	// Direct Debit Registration Callback
	@ResponseBody
	@RequestMapping({ "/directDebit/bind/notification" })
	public DirectDebitRegistrationNotificationResponse directDebitRegistrationCallback(
			@RequestBody DirectDebitRegistrationNotificationRequest req, HttpServletRequest hreq)
			throws JsonProcessingException {
		DirectDebitRegistrationNotificationResponse resNotif = new DirectDebitRegistrationNotificationResponse();
		String res = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.info("Req: " + mapper.writeValueAsString(req));

			if (!hreq.getHeader("tokenRequestorID").equalsIgnoreCase(contextLoader.getDirectDebitTokenRequestorID())) {
				logger.error("[Token Requestor ID Not Found]");
				resNotif.setResponseMessage("Unauthorized Access");
				resNotif.setResponseCode("01");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}

			IMap<String, String> dtmap = instance.getMap("TicketIDMap");
			String ticketID = dtmap.get(hreq.getHeader("journeyID"));
			if (ticketID == null) {
				logger.error("[Token Not Found/Expired]");
				resNotif.setResponseMessage("Unauthorized Access");
				resNotif.setResponseCode("01");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(ticketID);
			if (t == null) {
				logger.error("[Token Not Found/Expired]");
				resNotif.setResponseMessage("Unauthorized Access");
				resNotif.setResponseCode("01");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}

			if (req.getResponseCode().equalsIgnoreCase("00")) {
				logger.info("[Debit Registration Success : " + req.getMaskedCardNumber() + "]");
				ipgValidation.createDebitCards(t.getMsisdn(), req.getToken(), 1);
				
				res = paymentPageProcessor.purchaseRequest(ticketID);
				logger.info("[Debit Purchase Process : " + res + "]");
				
				resNotif.setResponseMessage("Success");
				resNotif.setResponseCode("00");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}

			dtmap.delete(hreq.getHeader("journeyID"));

			logger.error("RC " + req.getResponseCode() + " : " + req.getResponseMessage());
			resNotif.setResponseMessage(req.getResponseMessage());
			resNotif.setResponseCode("02");
			logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
			return resNotif;
		} catch (Exception ex) {
			ex.printStackTrace();
			resNotif.setResponseMessage(
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
			resNotif.setResponseCode("05");
			logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
		}
		return resNotif;
	}

	@RequestMapping(value = { "/directDebitPurchaseForm" }, method = RequestMethod.POST)
	public String directDebitPurchase(@Valid @ModelAttribute("directdebit") DirectDebitRequest directDebit,
			BindingResult result, ModelMap model) throws Exception {
		try {
			if (result.hasErrors()) {
				return "page_500";
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(directDebit.getTicketID());

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(directDebit.getTicketID());

			VaRegisterResponse vaRegisterResponse = paymentPageProcessor.registerVABilling(t.getMerchantID(),
					t.getName(), t.getMsisdn(), t.getEmail(), t.getDescription(), t.getAmount(), Integer.valueOf(1),
					t.getEventID(), contextLoader.getPaymentVANotifURL(), 8);

			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {

				String key = "JAK" + Utils.GenerateRandomNumber(32);

				DirectDebitPurchaseOTPRequest otpReq = new DirectDebitPurchaseOTPRequest();
				otpReq.setMerchantID(contextLoader.getDirectDebitMerchantID());
				otpReq.setOtpReasonCode("97");
				otpReq.setOtpReasonMessage(t.getDescription());
				otpReq.setOtpTransactionCode("02");
				otpReq.setTerminalID(contextLoader.getDirectDebitTerminalID());
				otpReq.setToken(ipgValidation.validateCards(t.getMsisdn(), 1));
				otpReq.setTransactionDate(Utils.GetDate("YYYYMMDD"));
				otpReq.setTransactionTime(Utils.GetDate("HHMMSS"));

				DirectDebitPurchaseOTPResponse otpRes = paymentPageProcessor.directDebitRequestOTP(key, otpReq);
				if (otpRes.getResponseCode().equalsIgnoreCase("00")) {
					model.addAttribute("otpReferenceNo", otpRes.getOtpReferenceNumber());
					model.addAttribute("ticketID", directDebit.getTicketID());
					model.addAttribute("ticketVA", vaRegisterResponse.getTicketID());
					if (t.getEventID().equalsIgnoreCase("NA")) {
						model.addAttribute("eventName", "");
					} else {
						model.addAttribute("eventName",
								paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
					}

					LoadMembersResponse lmr = paymentPageProcessor.loadMember(t.getMerchantID());
					model.addAttribute("formattedTransactionAmount",
							Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
					model.addAttribute("formattedTotalFee",
							Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
					model.addAttribute("formattedFinalAmount",
							Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
					model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
					model.addAttribute("paymentChannel", t.getPaymentChannel());
					return "directDebitPurchaseOTP";
				} else {
					logger.error(otpRes.getResponseMessage());
					model.addAttribute("httpResponseCode", "404");
					model.addAttribute("status", otpRes.getResponseMessage());
					model.addAttribute("description", otpRes.getResponseMessage());
					return "page_exception";
				}
			}
			if (vaRegisterResponse.getStatus().getMessage().equalsIgnoreCase("DUPLICATE_TRANSACTION")) {
				logger.error("[Ticket Not Found/Expired]");
				model.addAttribute("httpResponseCode", "404");
				model.addAttribute("status", "Duplicate Billing");
				model.addAttribute("description", "Your billing already exist with the same billing ID");
				return "page_exception";
			}
			logger.error(vaRegisterResponse.getStatus().getDescription());
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", vaRegisterResponse.getStatus().getMessage());
			model.addAttribute("description", vaRegisterResponse.getStatus().getDescription());
			return "page_exception";
		} catch (NullPointerException ex) {
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (MalformedURLException | DatatypeConfigurationException | ParseException ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	@RequestMapping(value = { "/directDebitPurchase" }, method = RequestMethod.POST)
	public String DirectDebitPurchaseRedirection(@Valid @ModelAttribute("directdebit") DirectDebitRequest directDebit,
			BindingResult result, ModelMap model) {
		try {
			IMap<String, Ticket> tMap = instance.getMap("PaymentRequestMap");
			Ticket t = tMap.get(directDebit.getTicketID());

			LoadVAByIDResponse loadVAByIDResponse = paymentPageProcessor.loadVAByID(directDebit.getTicketVA());
			if (loadVAByIDResponse.getVaRecord().size() == 0) {
				return "page_404";
			}

			IMap<String, Ticket> amMap = instance.getMap("PaymentAmountMap");
			Ticket ti = amMap.get(directDebit.getTicketID());

			String token = ipgValidation.validateCards(t.getMsisdn(), 1);

			additionalData ad = new additionalData();
			ad.setUserID(t.getMsisdn());
			ad.setEmail(t.getEmail());
			ad.setMobileNumber(t.getMsisdn());

			DirectDebitPurchaseRequest req = new DirectDebitPurchaseRequest();
			req.setAdditionalData(ad);
			req.setBillReferenceNumber(loadVAByIDResponse.getVaRecord().get(0).getId());
			req.setCurrency("360");
			req.setMerchantID(contextLoader.getDirectDebitMerchantID());
			req.setTerminalID(contextLoader.getDirectDebitTerminalID());
			req.setProductType("01");
			req.setToken(token);
			req.setTransactionAmount(ti.getFinalAmount().toString());
			req.setTransactionDate(Utils.GetDate("YYYYMMDD"));
			req.setTransactionTime(Utils.GetDate("HHMMSS"));
			req.setOtp(directDebit.getOtp());
			req.setProductType("99");
			req.setOtpReferenceNumber(directDebit.getOtpReferenceNo());

			IMap<String, BillingSuccess> bmap = instance.getMap("TicketIDMap");
			String key = "JAK" + Utils.GenerateRandomNumber(32);

			DirectDebitPurchaseResponse resp = paymentPageProcessor.directDebitPurchase(key, req);

			if (resp.getResponseCode().equalsIgnoreCase("00")) {
				IMap<String, Ticket> vaMap = instance.getMap("PaymentVAMap");
				vaMap.put(loadVAByIDResponse.getVaRecord().get(0).getId(), t);
				LoadMembersResponse lmr = paymentPageProcessor
						.loadMember(loadVAByIDResponse.getVaRecord().get(0).getParentUsername());

				String trxNumber = Utils.GetDate("yyyyMMddhhmmss") + Utils.GenerateTransactionNumber();
				VaPaymentResponse payRes = paymentPageProcessor.paymentVA(
						loadVAByIDResponse.getVaRecord().get(0).getId(), trxNumber, ti.getFinalAmount(),
						contextLoader.getDirectDebitUsrname(), contextLoader.getDirectDebitTrfTypeID());

				if (payRes.getStatus().getMessage().equalsIgnoreCase("PROCESSED")) {
					BillingSuccess b = new BillingSuccess();
					b.setTraceNumber(payRes.getTraceNumber());
					b.setTransactionNumber(payRes.getTransactionNumber());
					b.setTicketID(directDebit.getTicketID());

					bmap.put(key, b);

					model.addAttribute("paymentCode", loadVAByIDResponse.getVaRecord().get(0).getId());
					model.addAttribute("amount", loadVAByIDResponse.getVaRecord().get(0).getAmount());
					model.addAttribute("formattedAmount",
							Utils.formatAmount(ti.getAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
					model.addAttribute("transactionAmount", ti.getTransactionAmount());
					model.addAttribute("formattedTransactionAmount",
							Utils.formatAmount(ti.getTransactionAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
					model.addAttribute("totalFee", ti.getTotalFee());
					model.addAttribute("formattedTotalFee",
							Utils.formatAmount(ti.getTotalFee(), ".", ",", "#,##0.00", "Rp.", ",-"));
					model.addAttribute("finalAmount", ti.getFinalAmount());
					model.addAttribute("formattedFinalAmount",
							Utils.formatAmount(ti.getFinalAmount(), ".", ",", "#,##0.00", "Rp.", ",-"));
					model.addAttribute("expiredAt", loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
					if (t.getEventID().equalsIgnoreCase("NA")) {
						model.addAttribute("eventName", "");
					} else {
						model.addAttribute("eventName",
								paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0).getDescription());
					}

					model.addAttribute("username", lmr.getMembers().get(0).getUsername());
					model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
					model.addAttribute("description", loadVAByIDResponse.getVaRecord().get(0).getDescription());

					return "debitDirectPurchase";
				} else {
					logger.error("[Payment VA Failed]");
					model.addAttribute("httpResponseCode", "404");
					model.addAttribute("status", payRes.getStatus().getMessage());
					model.addAttribute("description", payRes.getStatus().getDescription());
					return "page_exception";
				}
			}

			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "FAILED");
			model.addAttribute("description", resp.getResponseMessage());
			return "page_exception";
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			logger.error("[Ticket Not Found/Expired]");
			model.addAttribute("httpResponseCode", "404");
			model.addAttribute("status", "TicketID Not Found");
			model.addAttribute("description", "Expired/Invalid TicketID");
			return "page_exception";
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("[" + ex.getCause() + "]");
			model.addAttribute("httpResponseCode", "500");
			model.addAttribute("status", "Oops !");
			model.addAttribute("description",
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
		}
		return "page_exception";
	}

	// Direct Debit Purchase Callback
	@ResponseBody
	@RequestMapping({ "/directDebit/purchase/notification" })
	public DirectDebitPurchaseNotificationResponse directDebitPurchaseCallback(
			@RequestBody DirectDebitPurchaseNotificationRequest req, HttpServletRequest hreq)
			throws JsonProcessingException, IOException {
		DirectDebitPurchaseNotificationResponse resNotif = new DirectDebitPurchaseNotificationResponse();
		String res = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.info("Req: " + mapper.writeValueAsString(req));

			if (!hreq.getHeader("tokenRequestorID").equalsIgnoreCase(contextLoader.getDirectDebitTokenRequestorID())) {
				logger.error("[Token Requestor ID Not Found]");
				resNotif.setResponseMessage("Unauthorized Access");
				resNotif.setResponseCode("01");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}

			IMap<String, BillingSuccess> dtmap = instance.getMap("TicketIDMap");
			BillingSuccess billing = dtmap.get(hreq.getHeader("journeyID"));
			if (billing == null) {
				logger.error("[Token Not Found/Expired]");
				resNotif.setResponseMessage("Unauthorized Access");
				resNotif.setResponseCode("01");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}

			IMap<String, Ticket> tMap = instance.getMap("PaymentVAMap");
			Ticket t = tMap.get(billing.getTicketID());
			if (t == null) {
				logger.error("[Token Not Found/Expired]");
				resNotif.setResponseMessage("Unauthorized Access");
				resNotif.setResponseCode("01");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}
			
			if (req.getResponseCode().equalsIgnoreCase("00")) {
				logger.info("[Direct Debit Purchase Callback Success : " + req.getReferenceNumber() + "]");

				paymentPageProcessor.updateBillingStatus(billing);

				res = paymentPageProcessor.purchaseRedirect(billing.getTicketID(), billing.getTransactionNumber(),
						"PROCESSED", t.getMsisdn());
				
				logger.info("[VA Notification Response : " + res + "]");

				resNotif.setResponseMessage("Success");
				resNotif.setResponseCode("00");
				logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
				return resNotif;
			}

			dtmap.delete(hreq.getHeader("journeyID"));
			
			res = paymentPageProcessor.purchaseRedirect(billing.getTicketID(), billing.getTransactionNumber(), "FAILED", t.getMsisdn());
			
			logger.info("[VA Notification Response : " + res + "]");

			logger.error("RC " + req.getResponseCode() + " : " + req.getResponseMessage());
			resNotif.setResponseMessage(req.getResponseMessage());
			resNotif.setResponseCode("02");
			logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
			return resNotif;
		} catch (Exception ex) {
			ex.printStackTrace();
			resNotif.setResponseMessage(
					"We are experiencing some trouble here, but don't worry our team are OTW to solve this");
			resNotif.setResponseCode("05");
			logger.info("[" + mapper.writeValueAsString(resNotif) + "]");
		}
		return resNotif;
	}
}