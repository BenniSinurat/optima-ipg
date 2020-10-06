package com.jpa.optima.ipg.model;

public class QRCodeResponse {
	private String responseCode;
	private String responseMessage;
	private String qrString;
	private String merchantTrxID;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getQrString() {
		return qrString;
	}

	public void setQrString(String qrString) {
		this.qrString = qrString;
	}

	public String getMerchantTrxID() {
		return merchantTrxID;
	}

	public void setMerchantTrxID(String merchantTrxID) {
		this.merchantTrxID = merchantTrxID;
	}

}
