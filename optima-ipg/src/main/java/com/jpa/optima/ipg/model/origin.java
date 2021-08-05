package com.jpa.optima.ipg.model;

public class origin {
	private String transactionDate;
	private String token;
	private String billReferenceNumber;
	private String approvalCode;

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

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

}
