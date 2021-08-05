package com.jpa.optima.ipg.model;

import java.io.Serializable;

import javax.xml.datatype.XMLGregorianCalendar;

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
	private String transactionNumber;
	private XMLGregorianCalendar transactionDate;
	private String transactionAmount;
	private String paymentCode;

	public String getDate() {
		return date;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public XMLGregorianCalendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(XMLGregorianCalendar transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
