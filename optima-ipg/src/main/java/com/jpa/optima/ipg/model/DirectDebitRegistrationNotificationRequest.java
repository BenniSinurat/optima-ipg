package com.jpa.optima.ipg.model;

public class DirectDebitRegistrationNotificationRequest {
	private String authorizationDate;
	private String authorizationTime;
	private String referenceNumber;
	private String token;
	private String maskedCardNumber;
	private String expiredDate;
	private String paymentAccountReference;
	private String bankCode;
	private String bankName;
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

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMaskedCardNumber() {
		return maskedCardNumber;
	}

	public void setMaskedCardNumber(String maskedCardNumber) {
		this.maskedCardNumber = maskedCardNumber;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getPaymentAccountReference() {
		return paymentAccountReference;
	}

	public void setPaymentAccountReference(String paymentAccountReference) {
		this.paymentAccountReference = paymentAccountReference;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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
