package com.jpa.optima.ipg.model;

import java.math.BigDecimal;

public class TransactionInquiryResponse {
	private String status;
	private String ticketID;
	private BigDecimal transactionAmount;
	private BigDecimal totalFee;
	private BigDecimal finalAmount;
	private Integer paymentChannel;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public BigDecimal getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Integer getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(Integer paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

}
