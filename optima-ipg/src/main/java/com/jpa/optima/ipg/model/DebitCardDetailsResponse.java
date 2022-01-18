package com.jpa.optima.ipg.model;

public class DebitCardDetailsResponse {
	private DebitCard debitCards;
	private String status;
	private String description;

	public DebitCard getDebitCards() {
		return debitCards;
	}

	public void setDebitCards(DebitCard debitCards) {
		this.debitCards = debitCards;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
