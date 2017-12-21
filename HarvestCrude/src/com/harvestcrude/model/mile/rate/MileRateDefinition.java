package com.harvestcrude.model.mile.rate;

import java.io.Serializable;

public class MileRateDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	private int initialMile;
	private int lastMile;
	private float rate;

	public int getInitialMile() {
		return initialMile;
	}

	public void setInitialMile(int initialMile) {
		this.initialMile = initialMile;
	}

	public int getLastMile() {
		return lastMile;
	}

	public void setLastMile(int lastMile) {
		this.lastMile = lastMile;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + initialMile;
		result = prime * result + lastMile;
		result = prime * result + Float.floatToIntBits(rate);
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
		MileRateDefinition other = (MileRateDefinition) obj;
		if (initialMile != other.initialMile)
			return false;
		if (lastMile != other.lastMile)
			return false;
		if (Float.floatToIntBits(rate) != Float.floatToIntBits(other.rate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [initialMile=%d, lastMile=%d, rate=%d]", getClass().getSimpleName(), initialMile,
				lastMile, rate);
	}

}
