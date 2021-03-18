package com.jpa.optima.ipg.model;

public class FelloInquiryRequest {
	private String msisdn;
	private String pin;
	private String ticketID;
	private String ticketVA;
	private Integer paymentChannel;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getTicketVA() {
		return ticketVA;
	}

	public void setTicketVA(String ticketVA) {
		this.ticketVA = ticketVA;
	}

	public Integer getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(Integer paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

}
