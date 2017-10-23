package com.harvestcrude.model.destination;

import java.io.Serializable;

public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int destinationId;
	private String name;
	private String shortName;
	private String identifier;
	
	public int getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
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
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
