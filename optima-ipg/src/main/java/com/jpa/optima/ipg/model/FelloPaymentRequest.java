package com.jpa.optima.ipg.model;

public class FelloPaymentRequest {
	private String otp;
	private String msisdn;
	private String ticketID;
	private String ticketVA;

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

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

}
