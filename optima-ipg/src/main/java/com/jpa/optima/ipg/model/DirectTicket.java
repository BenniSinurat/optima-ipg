package com.jpa.optima.ipg.model;

import java.io.Serializable;

public class DirectTicket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5300528510267572341L;
	private String id;
	private String ticketID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

}
