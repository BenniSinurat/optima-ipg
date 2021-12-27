package com.jpa.optima.ipg.model;

import java.io.Serializable;

public class DebitCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520582821030196063L;
	private Integer channelID;
	private String msisdn;
	private String token;
	private String maskedCardNumber;
	private String expiredDate;
	private String bankCode;
	private String bankName;

	public Integer getChannelID() {
		return channelID;
	}

	public void setChannelID(Integer channelID) {
		this.channelID = channelID;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMaskedCardNumber() {
		return maskedCardNumber;
	}

	public void setMaskedCardNumber(String maskedCardNumber) {
		this.maskedCardNumber = maskedCardNumber;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
