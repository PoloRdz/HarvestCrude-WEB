package com.harvestcrude.model.dispatch;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.harvestcrude.model.order.Order;

public class Dispatch implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int dispatchId;
	private Date date;
	private List<Order> orders;
	
	public int getDispatchId() {
		return dispatchId;
	}
	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
