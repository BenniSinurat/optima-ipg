package com.jpa.optima.ipg.model;

public class DirectDebitSetTokenLimitResponse {
	private String authorizationDate;
	private String authorizationTime;
	private String otpReferenceNumber;
	private String referenceNumber;
	private String responseCode;
	private String responseMessage;

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

	public String getOtpReferenceNumber() {
		return otpReferenceNumber;
	}

	public void setOtpReferenceNumber(String otpReferenceNumber) {
		this.otpReferenceNumber = otpReferenceNumber;
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

}
