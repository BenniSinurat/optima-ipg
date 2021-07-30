package com.jpa.optima.ipg.model;

public class DirectDebitPurchaseOTPResponse {
	private String authorizationDate;
	private String authorizationTime;
	private String referenceNumber;
	private String otpReferenceNumber;
	private String responseCode;
	private String responseMessage;
	private String verificationMethod;
	private additionalData additionalData;

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

	public String getOtpReferenceNumber() {
		return otpReferenceNumber;
	}

	public void setOtpReferenceNumber(String otpReferenceNumber) {
		this.otpReferenceNumber = otpReferenceNumber;
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

	public additionalData getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(additionalData additionalData) {
		this.additionalData = additionalData;
	}

	public String getVerificationMethod() {
		return verificationMethod;
	}

	public void setVerificationMethod(String verificationMethod) {
		this.verificationMethod = verificationMethod;
	}

}
