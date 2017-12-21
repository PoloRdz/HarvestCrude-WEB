package com.harvestcrude.model.order;

import java.io.Serializable;

public class OrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int orderStatusId;
	private String name;
	private String identifier;
	private boolean isCanceled;
	
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
	public boolean getIsCanceled(){
		return isCanceled;
	}
	public void setIsCanceled(boolean isCanceled){
		this.isCanceled = isCanceled;
	}
	
	@Override
	public String toString(){
		return String.format("%s [id=%d]", getClass().getSimpleName(), orderStatusId);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + (isCanceled ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + orderStatusId;
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
		OrderStatus other = (OrderStatus) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (isCanceled != other.isCanceled)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderStatusId != other.orderStatusId)
			return false;
		return true;
	}
}
