package com.harvestcrude.model.ticket;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ticketNumber;
	private TicketType ticketType;
	private TicketData ticketData;
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	public TicketData getTicketData() {
		return ticketData;
	}
	public void setTicketData(TicketData ticketData) {
		this.ticketData = ticketData;
	}

}
