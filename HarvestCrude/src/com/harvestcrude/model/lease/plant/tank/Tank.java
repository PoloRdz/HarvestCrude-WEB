package com.harvestcrude.model.lease.plant.tank;

import java.io.Serializable;

public class Tank implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int tankId;
	private String name;
	private TankSize tankSize;
	
	public int getTankId() {
		return tankId;
	}
	public void setTankId(int tankId) {
		this.tankId = tankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TankSize getTankSize() {
		return tankSize;
	}
	public void setTankSize(TankSize tankSize) {
		this.tankSize = tankSize;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + tankId;
		result = prime * result + ((tankSize == null) ? 0 : tankSize.hashCode());
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
		Tank other = (Tank) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tankId != other.tankId)
			return false;
		if (tankSize == null) {
			if (other.tankSize != null)
				return false;
		} else if (!tankSize.equals(other.tankSize))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return String.format("%s [tankId=%d]", getClass().getSimpleName(), tankId);
	}
}
