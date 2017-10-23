package com.harvestcrude.model.order;

import java.io.Serializable;

import com.harvestcrude.model.destination.Destination;
import com.harvestcrude.model.lease.plant.LeasePlant;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String orderNumber;
	private LeasePlant leasePlant;
	private Destination destination;
	private OrderStatus orderStatus;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
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
}
