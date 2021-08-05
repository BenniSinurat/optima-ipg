package com.jpa.optima.ipg.model;

public class DirectDebitPurchaseRequest {
	private String transactionDate;
	private String transactionTime;
	private String merchantID;
	private String terminalID;
	private String token;
	private String transactionAmount;
	private String currency;
	private String billReferenceNumber;
	private String otp;
	private String otpReferenceNumber;
	private String otpTransactionCode;
	private String productType;
	private additionalData additionalData;

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

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBillReferenceNumber() {
		return billReferenceNumber;
	}

	public void setBillReferenceNumber(String billReferenceNumber) {
		this.billReferenceNumber = billReferenceNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getOtpReferenceNumber() {
		return otpReferenceNumber;
	}

	public void setOtpReferenceNumber(String otpReferenceNumber) {
		this.otpReferenceNumber = otpReferenceNumber;
	}

	public String getOtpTransactionCode() {
		return otpTransactionCode;
	}

	public void setOtpTransactionCode(String otpTransactionCode) {
		this.otpTransactionCode = otpTransactionCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public additionalData getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(additionalData additionalData) {
		this.additionalData = additionalData;
	}

}
