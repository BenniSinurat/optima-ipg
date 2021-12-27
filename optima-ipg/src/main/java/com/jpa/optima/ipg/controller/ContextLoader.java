package com.jpa.optima.ipg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource("/WEB-INF/app.properties")
public class ContextLoader {

	@Value("${core.ws.id}")
	private String webserviceID;
	@Value("${core.ws.header.token}")
	private String headerToken;
	@Value("${host.ws.url}")
	private String HostWSUrl;
	@Value("${host.ws.port}")
	private String HostWSPort;
	@Value("${ipg.transfer.type.id}")
	private Integer IPGTransferType;
	@Value("${doku.mall.id}")
	private String DokuMallID;
	@Value("${doku.shared.key}")
	private String DokuSharedKey;
	@Value("${doku.receive.url}")
	private String ReceiveURL;
	@Value("${doku.check.status.url}")
	private String CheckStatusURL;
	@Value("${doku.void.url}")
	private String VoidURL;
	@Value("${doku.member.username}")
	private String DokuUsername;
	@Value("${payment.page.url}")
	private String PaymentPageURL;
	@Value("${payment.va.notif.url}")
	private String PaymentVANotifURL;
	@Value("${linkaja.cid}")
	private String LinkAjaCID;
	@Value("${linkaja.secret.key}")
	private String LinkAjaSecretKey;
	@Value("${linkaja.merchant.id}")
	private String LinkAjaMerchantID;
	@Value("${linkaja.transfer.type.id}")
	private Integer LinkAjaTransferTypeID;
	@Value("${linkaja.host.url}")
	private String LinkAjaHostURL;
	@Value("${linkaja.member.username}")
	private String LinkAjaUsername;
	@Value("${ipg.username}")
	private String IPGUsername;
	@Value("${fello.username}")
	private String FelloUsername;
	@Value("${fello.transfer.type.id}")
	private Integer FelloTransferTypeID;
	@Value("${fello.redirect.url}")
	private String FelloRedirectURL;
	@Value("${linkaja.deep.link.host}")
	private String LinkAjaDeepLinkHostURL;
	@Value("${linkaja.deep.link.username}")
	private String LinkAjaDeepLinkUsername;
	@Value("${linkaja.deep.link.password}")
	private String LinkAjaDeepLinkPassword;
	@Value("${linkaja.deep.link.merchant.id}")
	private String LinkAjaDeepLinkMerchantID;
	@Value("${linkaja.deep.link.encryption.key}")
	private String LinkAjaDeepLinkEncryptKey;
	@Value("${direct.debit.host.url}")
	private String DirectDebitHost;
	@Value("${direct.debit.host.registration}")
	private String DirectDebitRegistrationURL;
	@Value("${direct.debit.purchase.url}")
	private String DirectDebitPurchaseURL;
	@Value("${direct.debit.redirect.url}")
	private String DirectDebitPurchaseRedirect;
	@Value("${direct.debit.resend.otp.url}")
	private String DirectDebitResentOTP;
	@Value("${direct.debit.username}")
	private String DirectDebitUsername;
	@Value("${direct.debit.purchase.redirect.url}")
	private String DirectDebitPurchaseRedirectURL;
	@Value("${linkaja.qr.url}")
	private String LinkAjaQRURL;
	@Value("${linkaja.qr.trf.type.id}")
	private Integer LinkAjaQRTransferTypeID;

	public String getPaymentPageURL() {
		return PaymentPageURL;
	}

	public String getHeaderToken() {
		return headerToken;
	}

	public void setHeaderToken(String headerToken) {
		this.headerToken = headerToken;
	}

	public String getHostWSUrl() {
		return HostWSUrl;
	}

	public void setHostWSUrl(String hostWSUrl) {
		HostWSUrl = hostWSUrl;
	}

	public String getHostWSPort() {
		return HostWSPort;
	}

	public void setHostWSPort(String hostWSPort) {
		HostWSPort = hostWSPort;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public Integer getIPGTransferType() {
		return IPGTransferType;
	}

	public void setIPGTransferType(Integer iPGTransferType) {
		IPGTransferType = iPGTransferType;
	}

	public String getDokuMallID() {
		return DokuMallID;
	}

	public void setDokuMallID(String dokuMallID) {
		DokuMallID = dokuMallID;
	}

	public String getDokuSharedKey() {
		return DokuSharedKey;
	}

	public void setDokuSharedKey(String dokuSharedKey) {
		DokuSharedKey = dokuSharedKey;
	}

	public String getCheckStatusURL() {
		return CheckStatusURL;
	}

	public void setCheckStatusURL(String checkStatusURL) {
		CheckStatusURL = checkStatusURL;
	}

	public String getVoidURL() {
		return VoidURL;
	}

	public void setVoidURL(String voidURL) {
		VoidURL = voidURL;
	}

	public String getDokuUsername() {
		return DokuUsername;
	}

	public void setDokuUsername(String dokuUsername) {
		DokuUsername = dokuUsername;
	}

	public String getWebserviceID() {
		return webserviceID;
	}

	public void setWebserviceID(String webserviceID) {
		this.webserviceID = webserviceID;
	}

	public String getReceiveURL() {
		return ReceiveURL;
	}

	public void setReceiveURL(String receiveURL) {
		ReceiveURL = receiveURL;
	}

	public String getPaymentVANotifURL() {
		return PaymentVANotifURL;
	}

	public void setPaymentVANotifURL(String paymentVANotifURL) {
		PaymentVANotifURL = paymentVANotifURL;
	}

	public void setPaymentPageURL(String paymentPageURL) {
		PaymentPageURL = paymentPageURL;
	}

	public String getLinkAjaCID() {
		return LinkAjaCID;
	}

	public void setLinkAjaCID(String linkAjaCID) {
		LinkAjaCID = linkAjaCID;
	}

	public String getLinkAjaSecretKey() {
		return LinkAjaSecretKey;
	}

	public void setLinkAjaSecretKey(String linkAjaSecretKey) {
		LinkAjaSecretKey = linkAjaSecretKey;
	}

	public String getLinkAjaMerchantID() {
		return LinkAjaMerchantID;
	}

	public void setLinkAjaMerchantID(String linkAjaMerchantID) {
		LinkAjaMerchantID = linkAjaMerchantID;
	}

	public Integer getLinkAjaTransferTypeID() {
		return LinkAjaTransferTypeID;
	}

	public void setLinkAjaTransferTypeID(Integer linkAjaTransferTypeID) {
		LinkAjaTransferTypeID = linkAjaTransferTypeID;
	}

	public String getLinkAjaHostURL() {
		return LinkAjaHostURL;
	}

	public void setLinkAjaHostURL(String linkAjaHostURL) {
		LinkAjaHostURL = linkAjaHostURL;
	}

	public String getLinkAjaUsername() {
		return LinkAjaUsername;
	}

	public void setLinkAjaUsername(String linkAjaUsername) {
		LinkAjaUsername = linkAjaUsername;
	}

	public String getIPGUsername() {
		return IPGUsername;
	}

	public void setIPGUsername(String iPGUsername) {
		IPGUsername = iPGUsername;
	}

	public String getFelloUsername() {
		return FelloUsername;
	}

	public void setFelloUsername(String felloUsername) {
		FelloUsername = felloUsername;
	}

	public Integer getFelloTransferTypeID() {
		return FelloTransferTypeID;
	}

	public void setFelloTransferTypeID(Integer felloTransferTypeID) {
		FelloTransferTypeID = felloTransferTypeID;
	}

	public String getFelloRedirectURL() {
		return FelloRedirectURL;
	}

	public void setFelloRedirectURL(String felloRedirectURL) {
		FelloRedirectURL = felloRedirectURL;
	}

	public String getLinkAjaDeepLinkUsername() {
		return LinkAjaDeepLinkUsername;
	}

	public void setLinkAjaDeepLinkUsername(String linkAjaDeepLinkUsername) {
		LinkAjaDeepLinkUsername = linkAjaDeepLinkUsername;
	}

	public String getLinkAjaDeepLinkPassword() {
		return LinkAjaDeepLinkPassword;
	}

	public void setLinkAjaDeepLinkPassword(String linkAjaDeepLinkPassword) {
		LinkAjaDeepLinkPassword = linkAjaDeepLinkPassword;
	}

	public String getLinkAjaDeepLinkMerchantID() {
		return LinkAjaDeepLinkMerchantID;
	}

	public void setLinkAjaDeepLinkMerchantID(String linkAjaDeepLinkMerchantID) {
		LinkAjaDeepLinkMerchantID = linkAjaDeepLinkMerchantID;
	}

	public String getLinkAjaDeepLinkEncryptKey() {
		return LinkAjaDeepLinkEncryptKey;
	}

	public void setLinkAjaDeepLinkEncryptKey(String linkAjaDeepLinkEncryptKey) {
		LinkAjaDeepLinkEncryptKey = linkAjaDeepLinkEncryptKey;
	}

	public String getLinkAjaDeepLinkHostURL() {
		return LinkAjaDeepLinkHostURL;
	}

	public void setLinkAjaDeepLinkHostURL(String linkAjaDeepLinkHostURL) {
		LinkAjaDeepLinkHostURL = linkAjaDeepLinkHostURL;
	}

	public String getDirectDebitHostURL() {
		return DirectDebitHost;
	}

	public void setDirectDebitHostURL(String directDebitHost) {
		DirectDebitHost = directDebitHost;
	}

	public String getDirectDebitHost() {
		return DirectDebitHost;
	}

	public void setDirectDebitHost(String directDebitHost) {
		DirectDebitHost = directDebitHost;
	}

	public String getDirectDebitRegistrationURL() {
		return DirectDebitRegistrationURL;
	}

	public void setDirectDebitRegistrationURL(String directDebitRegistrationURL) {
		DirectDebitRegistrationURL = directDebitRegistrationURL;
	}

	public String getDirectDebitPurchaseURL() {
		return DirectDebitPurchaseURL;
	}

	public void setDirectDebitPurchaseURL(String directDebitPurchaseURL) {
		DirectDebitPurchaseURL = directDebitPurchaseURL;
	}

	public String getDirectDebitPurchaseRedirect() {
		return DirectDebitPurchaseRedirect;
	}

	public void setDirectDebitPurchaseRedirect(String directDebitPurchaseRedirect) {
		DirectDebitPurchaseRedirect = directDebitPurchaseRedirect;
	}

	public String getDirectDebitResentOTP() {
		return DirectDebitResentOTP;
	}

	public void setDirectDebitResentOTP(String directDebitResentOTP) {
		DirectDebitResentOTP = directDebitResentOTP;
	}

	public String getDirectDebitUsername() {
		return DirectDebitUsername;
	}

	public void setDirectDebitUsername(String directDebitUsername) {
		DirectDebitUsername = directDebitUsername;
	}

	public String getDirectDebitPurchaseRedirectURL() {
		return DirectDebitPurchaseRedirectURL;
	}

	public void setDirectDebitPurchaseRedirectURL(String directDebitPurchaseRedirectURL) {
		DirectDebitPurchaseRedirectURL = directDebitPurchaseRedirectURL;
	}

	public String getLinkAjaQRURL() {
		return LinkAjaQRURL;
	}

	public void setLinkAjaQRURL(String linkAjaQRURL) {
		LinkAjaQRURL = linkAjaQRURL;
	}

	public Integer getLinkAjaQRTransferTypeID() {
		return LinkAjaQRTransferTypeID;
	}

	public void setLinkAjaQRTransferTypeID(Integer linkAjaQRTransferTypeID) {
		LinkAjaQRTransferTypeID = linkAjaQRTransferTypeID;
	}

}
