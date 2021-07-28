package com.jpa.optima.ipg.model;

public class DirectDebitPurchaseNotificationRequest {
	private String authorizationDate;
	private String authorizationTime;
	private String referenceNumber;
	private String approvalCode;
	private String isOTPRequired;
	private String otpReason;
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

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getIsOTPRequired() {
		return isOTPRequired;
	}

	public void setIsOTPRequired(String isOTPRequired) {
		this.isOTPRequired = isOTPRequired;
	}

	public String getOtpReason() {
		return otpReason;
	}

	public void setOtpReason(String otpReason) {
		this.otpReason = otpReason;
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
