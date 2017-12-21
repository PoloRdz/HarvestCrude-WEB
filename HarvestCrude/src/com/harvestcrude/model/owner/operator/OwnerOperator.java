package com.harvestcrude.model.owner.operator;

import java.io.Serializable;

import com.harvestcrude.model.mile.rate.MileRate;

public class OwnerOperator implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ownerOperatorId;
	private String name;
	private MileRate mileRate;
	
	public int getOwnerOperatorId() {
		return ownerOperatorId;
	}
	public void setOwnerOperatorId(int ownerOperatorId) {
		this.ownerOperatorId = ownerOperatorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MileRate getMileRate() {
		return mileRate;
	}
	public void setMileRate(MileRate mileRate) {
		this.mileRate = mileRate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mileRate == null) ? 0 : mileRate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ownerOperatorId;
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
		OwnerOperator other = (OwnerOperator) obj;
		if (mileRate == null) {
			if (other.mileRate != null)
				return false;
		} else if (!mileRate.equals(other.mileRate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ownerOperatorId != other.ownerOperatorId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s [ownerOperatorId=%d]", getClass().getSimpleName(), ownerOperatorId);
	}

}
