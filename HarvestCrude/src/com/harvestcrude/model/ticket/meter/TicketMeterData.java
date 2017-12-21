package com.harvestcrude.model.ticket.meter;

import java.io.Serializable;

public class TicketMeterData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private float meterOff;
	private float meterOn;
	
	public float getMeterOff() {
		return meterOff;
	}
	public void setMeterOff(float meterOff) {
		this.meterOff = meterOff;
	}
	public float getMeterOn() {
		return meterOn;
	}
	public void setMeterOn(float meterOn) {
		this.meterOn = meterOn;
	}

}
