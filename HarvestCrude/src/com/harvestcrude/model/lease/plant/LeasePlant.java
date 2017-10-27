package com.harvestcrude.model.lease.plant;

import java.io.Serializable;

public class LeasePlant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int leasePlantNumber;
	private String name;
	private String shortName;
	private LeasePlantOperator leasePlantOperator;
	private String identifier;
	
	public int getLeasePlantNumber() {
		return leasePlantNumber;
	}
	public void setLeasePlantNumber(int leasePlantNumber) {
		this.leasePlantNumber = leasePlantNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public LeasePlantOperator getLeasePlantOperator() {
		return leasePlantOperator;
	}
	public void setLeasePlantOperator(LeasePlantOperator leasePlantOperator) {
		this.leasePlantOperator = leasePlantOperator;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + leasePlantNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((shortName == null) ? 0 : shortName.hashCode());
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
		LeasePlant other = (LeasePlant) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (leasePlantNumber != other.leasePlantNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (shortName == null) {
			if (other.shortName != null)
				return false;
		} else if (!shortName.equals(other.shortName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s[leasePlantNumber=%d]", getClass().getSimpleName(), leasePlantNumber);
	}	
}
