package com.jpa.optima.ipg.model;

public class DirectDebitPurchaseOTPRequest {
	private String transactionDate;
	private String transactionTime;
	private String merchantID;
	private String terminalID;
	private String token;
	private String otpTransactionCode;
	private String otpReasonCode;
	private String otpReasonMessage;

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOtpTransactionCode() {
		return otpTransactionCode;
	}

	public void setOtpTransactionCode(String otpTransactionCode) {
		this.otpTransactionCode = otpTransactionCode;
	}

	public String getOtpReasonCode() {
		return otpReasonCode;
	}

	public void setOtpReasonCode(String otpReasonCode) {
		this.otpReasonCode = otpReasonCode;
	}

	public String getOtpReasonMessage() {
		return otpReasonMessage;
	}

	public void setOtpReasonMessage(String otpReasonMessage) {
		this.otpReasonMessage = otpReasonMessage;
	}

}
