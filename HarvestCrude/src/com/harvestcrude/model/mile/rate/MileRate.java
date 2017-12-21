package com.harvestcrude.model.mile.rate;

import java.io.Serializable;
import java.util.List;

public class MileRate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int mileRateId;
	private String name;
	private String identifier;
	private String description;
	private List<MileRateDefinition> mileRateDefinitions;
	
	public int getMileRateId() {
		return mileRateId;
	}
	public void setMileRateId(int mileRateId) {
		this.mileRateId = mileRateId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<MileRateDefinition> getMileRateDefinitions() {
		return mileRateDefinitions;
	}
	public void setMileRateDefinitions(List<MileRateDefinition> mileRateDefinitions) {
		this.mileRateDefinitions = mileRateDefinitions;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((mileRateDefinitions == null) ? 0 : mileRateDefinitions.hashCode());
		result = prime * result + mileRateId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		MileRate other = (MileRate) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (mileRateDefinitions == null) {
			if (other.mileRateDefinitions != null)
				return false;
		} else if (!mileRateDefinitions.equals(other.mileRateDefinitions))
			return false;
		if (mileRateId != other.mileRateId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s [mileRateId=%d]", getClass().getSimpleName(), mileRateId);
	}

}
