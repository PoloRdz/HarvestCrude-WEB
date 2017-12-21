package com.harvestcrude.model.truck;

import java.io.Serializable;

import com.harvestcrude.model.owner.operator.OwnerOperator;

public class Truck implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int truckNumber;
	private String identifier;
	private OwnerOperator ownerOperator;
	private boolean isDeleted;
	
	public int getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(int truckNumber) {
		this.truckNumber = truckNumber;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public OwnerOperator getOwnerOperator() {
		return ownerOperator;
	}
	public void setOwnerOperator(OwnerOperator ownerOperator) {
		this.ownerOperator = ownerOperator;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((ownerOperator == null) ? 0 : ownerOperator.hashCode());
		result = prime * result + truckNumber;
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
		Truck other = (Truck) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (ownerOperator == null) {
			if (other.ownerOperator != null)
				return false;
		} else if (!ownerOperator.equals(other.ownerOperator))
			return false;
		if (truckNumber != other.truckNumber)
			return false;
		return true;
	}

	@Override
	public String toString(){
		return String.format("%s [truckNumber=%d]", getClass().getSimpleName(), truckNumber);
	}
}
