package com.jpa.optima.ipg.model;

public class DirectDebitRequest {
	private String ticketID;
	private String ticketVA;
	private String otp;
	private String otpReferenceNo;
	private String referenceNo;

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

	public String getOtpReferenceNo() {
		return otpReferenceNo;
	}

	public void setOtpReferenceNo(String otpReferenceNo) {
		this.otpReferenceNo = otpReferenceNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

}
