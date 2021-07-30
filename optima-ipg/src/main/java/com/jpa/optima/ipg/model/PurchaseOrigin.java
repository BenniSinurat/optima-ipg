package com.jpa.optima.ipg.model;

import java.io.Serializable;

public class PurchaseOrigin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2509498681276564397L;
	private String date;
	private String token;
	private String billReferenceNumber;
	private String approvalCode;
	private Ticket ticket;
	private String traceNumber;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBillReferenceNumber() {
		return billReferenceNumber;
	}

	public void setBillReferenceNumber(String billReferenceNumber) {
		this.billReferenceNumber = billReferenceNumber;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

}
