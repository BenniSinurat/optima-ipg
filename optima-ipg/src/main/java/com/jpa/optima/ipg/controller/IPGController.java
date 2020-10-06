package com.jpa.optima.ipg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.jpa.optima.ipg.helper.QRCodeHelper;
import com.jpa.optima.ipg.helper.Utils;
import com.jpa.optima.ipg.model.CreditCardParam;
import com.jpa.optima.ipg.model.LinkAjaNotificationRequest;
import com.jpa.optima.ipg.model.LinkAjaNotificationResponse;
import com.jpa.optima.ipg.model.QRCodeParam;
import com.jpa.optima.ipg.model.QRCodeResponse;
import com.jpa.optima.ipg.model.Ticket;
import com.jpa.optima.ipg.model.TransactionInquiryRequest;
import com.jpa.optima.ipg.model.TransactionInquiryResponse;
import com.jpa.optima.ipg.model.Transfer;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.bellatrix.services.ws.access.CredentialResponse;
import org.bellatrix.services.ws.billpayments.LoadPaymentChannelByMemberIDResponse;
import org.bellatrix.services.ws.billpayments.PaymentChannel;
import org.bellatrix.services.ws.members.LoadMembersResponse;
import org.bellatrix.services.ws.members.Members;
import org.bellatrix.services.ws.payments.InquiryRequest;
import org.bellatrix.services.ws.payments.InquiryResponse;
import org.bellatrix.services.ws.payments.PaymentResponse;
import org.bellatrix.services.ws.virtualaccount.LoadVAByIDResponse;
import org.bellatrix.services.ws.virtualaccount.VaEvent;
import org.bellatrix.services.ws.virtualaccount.VaPaymentResponse;
import org.bellatrix.services.ws.virtualaccount.VaRecordView;
import org.bellatrix.services.ws.virtualaccount.VaRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
			String descVal = description == null ? "Payment to " + ((Members) lmr.getMembers().get(0)).getName()
					: description;
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
			t.setMerchantName(((Members) lmr.getMembers().get(0)).getName());
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

			VaRegisterResponse vaRegisterResponse = paymentPageProcessor.registerVABilling(t.getMerchantID(),
					transfer.getName(), transfer.getMsisdn(), transfer.getEmail(), transfer.getDescription(),
					transfer.getAmount(), Integer.valueOf(1), t.getEventID(), t.getCallback());

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
					transfer.getAmount(), Integer.valueOf(1), t.getEventID(), t.getCallback());

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
			model.addAttribute("expiredAt",
					loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
			if (t.getEventID().equalsIgnoreCase("NA")) {
				model.addAttribute("eventName", "");
			} else {
				model.addAttribute("eventName",
					 paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0)
								.getDescription());
			}

			model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
			model.addAttribute("username", lmr.getMembers().get(0).getUsername());
			model.addAttribute("description",
					loadVAByIDResponse.getVaRecord().get(0).getDescription());
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
					transfer.getAmount(), Integer.valueOf(1), t.getEventID(), t.getCallback());

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
			logger.info("AMOUNT===> " + StringUtils.leftPad(ti.getFinalAmount().toString().replace(".", ""), 10, '0')
					+ "/ Ti AMount: " + ti.getFinalAmount().toString().replace(".00", ""));
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
				model.addAttribute("expiredAt",
						loadVAByIDResponse.getVaRecord().get(0).getFormattedExpiredAt());
				if (t.getEventID().equalsIgnoreCase("NA")) {
					model.addAttribute("eventName", "");
				} else {
					model.addAttribute("eventName",
							paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0)
									.getDescription());
				}

				model.addAttribute("username", lmr.getMembers().get(0).getUsername());
				model.addAttribute("eventOrganizer", lmr.getMembers().get(0).getName());
				model.addAttribute("description",
						loadVAByIDResponse.getVaRecord().get(0).getDescription());
				model.addAttribute("qrcode", qrResponse.getQrString());
				tMap.delete(ticketID);
				amMap.delete(ticketID);
				return "qrCodePayment";
			}
			logger.error("RC " + qrResponse.getResponseCode() + " : " + qrResponse.getResponseMessage());
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

	@RequestMapping(value = { "/paymentVANotification" }, method = RequestMethod.POST)
	public String paymentVANotification(@RequestParam(value = "paymentCode", required = true) String paymentCode,
			@RequestParam(value = "amount", required = true) String amount,
			@RequestParam(value = "transactionNumber", required = true) String transactionNumber,
			@RequestParam(value = "notificationDate", required = true) String notificationDate, ModelMap model) {
		try {
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
			VaPaymentResponse payRes = paymentPageProcessor.paymentVA(req.getMsg(), trxNumber, req.getAmount());
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
			Ticket ti =  vaMap.get(transactionInq.getTicketID());

			LoadMembersResponse lmr = paymentPageProcessor.loadMember(t.getMerchantID());
			CreditCardParam response = paymentPageProcessor.forwardCreditCardPayment(transactionInq.getTicketID(),
					t.getInvoiceID(), t.getName(), t.getEmail(), ti.getFinalAmount(), t.getDescription());
			if (t.getEventID().equalsIgnoreCase("NA")) {
				model.addAttribute("eventName", "");
			} else {
				model.addAttribute("eventName",
						paymentPageProcessor.loadVAEvent(t.getEventID()).getEvent().get(0)
								.getDescription());
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

			if (transactionInq.getPaymentChannel().intValue() == 1) {
				logger.info("--KARTU KREDIT--");
				return "creditCardRedirect";
			}
			if (transactionInq.getPaymentChannel().intValue() == 2) {
				logger.info("--TRANSFER BANK--");
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
}