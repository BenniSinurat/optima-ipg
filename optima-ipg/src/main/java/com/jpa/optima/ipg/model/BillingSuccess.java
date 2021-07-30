package com.jpa.optima.ipg.model;

import java.io.Serializable;

public class BillingSuccess implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1456864568869617716L;
	private String ticketID;
	private String traceNumber;
	private String transactionNumber;
	private String date;
	private String token;

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

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

}
