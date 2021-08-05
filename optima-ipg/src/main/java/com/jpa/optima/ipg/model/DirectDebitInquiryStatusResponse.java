package com.jpa.optima.ipg.model;

public class DirectDebitInquiryStatusResponse {
	private String authorizationDate;
	private String authorizationTime;
	private String referenceNumber;
	private String responseCode;
	private String responseMessage;
	private String originResponseCode;
	private String originResponseMessage;

	public String getAuthorizationDate() {
		return authorizationDate;
	}

	public void setAuthorizationDate(String authorizationDate) {
		this.authorizationDate = authorizationDate;
	}

	public String getAuthorizationTime() {
		return authorizationTime;
	}

	public void setAuthorizationTime(String authorizationTime) {
		this.authorizationTime = authorizationTime;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getOriginResponseCode() {
		return originResponseCode;
	}

	public void setOriginResponseCode(String originResponseCode) {
		this.originResponseCode = originResponseCode;
	}

	public String getOriginResponseMessage() {
		return originResponseMessage;
	}

	public void setOriginResponseMessage(String originResponseMessage) {
		this.originResponseMessage = originResponseMessage;
	}

}
