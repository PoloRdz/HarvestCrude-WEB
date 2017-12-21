package com.harvestcrude.model.order.DTO;

import java.io.Serializable;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int orderNumber;
	private int ticketNumber;
	private String leasePlant;
	private String Destination;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getLeasePlant() {
		return leasePlant;
	}
	public void setLeasePlant(String leasePlant) {
		this.leasePlant = leasePlant;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
}
