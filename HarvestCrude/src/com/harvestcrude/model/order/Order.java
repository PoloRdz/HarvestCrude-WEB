package com.harvestcrude.model.order;

import java.io.Serializable;

import com.harvestcrude.model.destination.Destination;
import com.harvestcrude.model.driver.Driver;
import com.harvestcrude.model.lease.plant.LeasePlant;
import com.harvestcrude.model.ticket.Ticket;
import com.harvestcrude.model.truck.Truck;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int orderNumber;
	private LeasePlant leasePlant;
	private Destination destination;
	private OrderStatus orderStatus;
	private Ticket ticket;
	private Driver driver;
	private Truck truck;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public LeasePlant getLeasePlant() {
		return leasePlant;
	}
	public void setLeasePlant(LeasePlant leasePlant) {
		this.leasePlant = leasePlant;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Truck getTruck() {
		return truck;
	}
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
}
