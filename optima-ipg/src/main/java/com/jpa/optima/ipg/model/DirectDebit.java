package com.jpa.optima.ipg.model;

import java.io.Serializable;

public class DirectDebit implements Serializable {

	private static final long serialVersionUID = 2754898992480527455L;
	private String debitNo;
	private String expiry;
	private String token;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
