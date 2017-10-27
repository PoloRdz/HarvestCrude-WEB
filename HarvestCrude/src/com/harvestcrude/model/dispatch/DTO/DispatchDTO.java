package com.harvestcrude.model.dispatch.DTO;

import java.io.Serializable;
import java.util.Date;

public class DispatchDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int dispatchId;
	private Date date;
	private int ordersAmount;
	
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
	public int getOrdersAmount() {
		return ordersAmount;
	}
	public void setOrdersAmount(int ordersAmount) {
		this.ordersAmount = ordersAmount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + dispatchId;
		result = prime * result + ordersAmount;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DispatchDTO other = (DispatchDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dispatchId != other.dispatchId)
			return false;
		if (ordersAmount != other.ordersAmount)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s[dispatchId=%d]", getClass().getSimpleName(), dispatchId);
	}		
}
