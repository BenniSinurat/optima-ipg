package com.jpa.optima.ipg.model;

public class ValidateDebitCardRequest {
	private String transactionDate;
	private String transactionTime;
	private String merchantID;
	private String terminalID;
	private String encryptedData;
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

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public additionalData getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(additionalData additionalData) {
		this.additionalData = additionalData;
	}

}
