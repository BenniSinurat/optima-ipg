package com.jpa.optima.ipg.model;

public class originTrxStatus {
	private String transactionDate;
	private String token;
	private String billReferenceNumber;

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBillReferenceNumber() {
		return billReferenceNumber;
	}

	public void setBillReferenceNumber(String billReferenceNumber) {
		this.billReferenceNumber = billReferenceNumber;
	}

}
