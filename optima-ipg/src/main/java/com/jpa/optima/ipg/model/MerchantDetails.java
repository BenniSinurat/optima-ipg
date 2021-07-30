package com.jpa.optima.ipg.model;

import java.io.Serializable;

public class MerchantDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4648420891508231941L;
	private Integer id;
	private String mid;
	private String username;
	private String password;
	private String tokenRequestorID;
	private String merchantID;
	private String terminalID;
	private String secretKey;
	private String publicKey;
	private Integer transferTypeID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTokenRequestorID() {
		return tokenRequestorID;
	}

	public void setTokenRequestorID(String tokenRequestorID) {
		this.tokenRequestorID = tokenRequestorID;
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

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public Integer getTransferTypeID() {
		return transferTypeID;
	}

	public void setTransferTypeID(Integer transferTypeID) {
		this.transferTypeID = transferTypeID;
	}
}
