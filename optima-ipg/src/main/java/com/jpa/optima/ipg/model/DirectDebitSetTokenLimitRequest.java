package com.jpa.optima.ipg.model;

public class DirectDebitSetTokenLimitRequest {
	private String transactionDate;
	private String transactionTime;
	private String merchantID;
	private String terminalID;
	private String token;
	private String tokenLimit;
	private String currency;
	private String otpTransactionCode;
	private String otpReferenceNumber;
	private String otp;

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

	public String getTokenLimit() {
		return tokenLimit;
	}

	public void setTokenLimit(String tokenLimit) {
		this.tokenLimit = tokenLimit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOtpTransactionCode() {
		return otpTransactionCode;
	}

	public void setOtpTransactionCode(String otpTransactionCode) {
		this.otpTransactionCode = otpTransactionCode;
	}

	public String getOtpReferenceNumber() {
		return otpReferenceNumber;
	}

	public void setOtpReferenceNumber(String otpReferenceNumber) {
		this.otpReferenceNumber = otpReferenceNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
