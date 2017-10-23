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
}
