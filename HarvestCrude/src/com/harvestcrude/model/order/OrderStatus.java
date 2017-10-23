package com.harvestcrude.model.order;

import java.io.Serializable;

public class OrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int orderStatusId;
	private String name;
	private String identifier;
	
	public int getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
