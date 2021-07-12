package com.jpa.optima.ipg.model;

import java.math.BigDecimal;

public class DirectDebitRequest {
	private String ticketID;
	private String ticketVA;
	private String name;
	private String msisdn;
	private String email;
	private String description;
	private BigDecimal amount;
	private Integer paymentChannel;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(Integer paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

}
