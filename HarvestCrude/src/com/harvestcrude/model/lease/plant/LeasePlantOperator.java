package com.harvestcrude.model.lease.plant;

import java.io.Serializable;

public class LeasePlantOperator implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int leasePlantOperatorId;
	private String name;
	private String identifier;
	
	public int getLeasePlantOperatorId() {
		return leasePlantOperatorId;
	}
	public void setLeasePlantOperatorId(int leasePlantOperatorId) {
		this.leasePlantOperatorId = leasePlantOperatorId;
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
}
