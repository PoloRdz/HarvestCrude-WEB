package com.harvestcrude.model.ticket.gauge;

import java.io.Serializable;

public class TicketGaugeData implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	private int highTemp;
	private int highFeet;
	private int highInches;
	private int highFract;
	private int lowTemp;
	private int lowFeet;
	private int lowInches;
	private int lowFract;
	
	public int getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public int getHighFeet() {
		return highFeet;
	}
	public void setHighFeet(int highFeet) {
		this.highFeet = highFeet;
	}
	public int getHighInches() {
		return highInches;
	}
	public void setHighInches(int highInches) {
		this.highInches = highInches;
	}
	public int getHighFract() {
		return highFract;
	}
	public void setHighFract(int highFract) {
		this.highFract = highFract;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public int getLowFeet() {
		return lowFeet;
	}
	public void setLowFeet(int lowFeet) {
		this.lowFeet = lowFeet;
	}
	public int getLowInches() {
		return lowInches;
	}
	public void setLowInches(int lowInches) {
		this.lowInches = lowInches;
	}
	public int getLowFract() {
		return lowFract;
	}
	public void setLowFract(int lowFract) {
		this.lowFract = lowFract;
	}

}
