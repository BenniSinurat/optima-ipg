package com.jpa.optima.ipg.model;

public class DirectDebitInquiryStatusRequest {
	private originTrxStatus origin;
	private String transactionDate;
	private String transactionTime;
	private String merchantID;
	private String terminalID;

	public originTrxStatus getOrigin() {
		return origin;
	}

	public void setOrigin(originTrxStatus origin) {
		this.origin = origin;
	}

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

}
