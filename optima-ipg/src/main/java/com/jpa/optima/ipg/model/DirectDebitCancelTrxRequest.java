package com.jpa.optima.ipg.model;

public class DirectDebitCancelTrxRequest {
	private origin origin;
	private String transactionDate;
	private String transactionTime;
	private String merchantID;
	private String terminalID;
	private String reason;

	public origin getOrigin() {
		return origin;
	}

	public void setOrigin(origin origin) {
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
