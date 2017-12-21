package com.harvestcrude.model.lease.plant.tank;

import java.io.Serializable;

public class TankSize implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int tankSizeId;
	private String tankSize;
	private float factor;
	
	public int getTankSizeId() {
		return tankSizeId;
	}
	public void setTankSizeId(int tankSizeId) {
		this.tankSizeId = tankSizeId;
	}
	public String getTankSize() {
		return tankSize;
	}
	public void setTankSize(String tankSize) {
		this.tankSize = tankSize;
	}
	public float getFactor() {
		return factor;
	}
	public void setFactor(float factor) {
		this.factor = factor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(factor);
		result = prime * result + ((tankSize == null) ? 0 : tankSize.hashCode());
		result = prime * result + tankSizeId;
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
		TankSize other = (TankSize) obj;
		if (Float.floatToIntBits(factor) != Float.floatToIntBits(other.factor))
			return false;
		if (tankSize == null) {
			if (other.tankSize != null)
				return false;
		} else if (!tankSize.equals(other.tankSize))
			return false;
		if (tankSizeId != other.tankSizeId)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return String.format("%s [tankSizeId=%d]", getClass().getSimpleName(), tankSizeId);
	}
}
