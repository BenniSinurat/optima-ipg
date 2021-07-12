package com.jpa.optima.ipg.model;

public class DeepLinkRequest {
	private String trxDate;
	private String partnerTrxID;
	private String merchantID;
	private String terminalID;
	private String totalAmount;
	private String terminalName;
	private String partnerAppLink;
	private String items;
	private String refData;

	public String getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}

	public String getPartnerTrxID() {
		return partnerTrxID;
	}

	public void setPartnerTrxID(String partnerTrxID) {
		this.partnerTrxID = partnerTrxID;
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

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getPartnerAppLink() {
		return partnerAppLink;
	}

	public void setPartnerAppLink(String partnerAppLink) {
		this.partnerAppLink = partnerAppLink;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getRefData() {
		return refData;
	}

	public void setRefData(String refData) {
		this.refData = refData;
	}

}
