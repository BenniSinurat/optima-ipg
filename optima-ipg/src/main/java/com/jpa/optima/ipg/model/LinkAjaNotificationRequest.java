package com.jpa.optima.ipg.model;

public class LinkAjaNotificationRequest {
	private String merchant;
	private String terminal;
	private String pwd;
	private String trx_type;
	private String trx_date;
	private String trx_id;
	private String msisdn;
	private String msg;
	private Number amount;

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTrx_type() {
		return trx_type;
	}

	public void setTrx_type(String trx_type) {
		this.trx_type = trx_type;
	}

	public String getTrx_date() {
		return trx_date;
	}

	public void setTrx_date(String trx_date) {
		this.trx_date = trx_date;
	}

	public String getTrx_id() {
		return trx_id;
	}

	public void setTrx_id(String trx_id) {
		this.trx_id = trx_id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Number getAmount() {
		return amount;
	}

	public void setAmount(Number amount) {
		this.amount = amount;
	}
}