package com.jpa.optima.ipg.model;

public class topupPaymentResponse {
	private String debitNo;
	private String expiry;
	private String bankCode;
	private String bankName;

	public String getDebitNo() {
		return debitNo;
	}

	public void setDebitNo(String debitNo) {
		this.debitNo = debitNo;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
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

}
