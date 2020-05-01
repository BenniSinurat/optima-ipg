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

}
