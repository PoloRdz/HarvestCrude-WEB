package com.harvestcrude.model.ticket;

import java.io.Serializable;
import java.util.Date;

import com.harvestcrude.model.lease.plant.tank.Tank;
import com.harvestcrude.model.ticket.gauge.TicketGaugeData;
import com.harvestcrude.model.ticket.meter.TicketMeterData;

public class TicketData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private TicketMeterData ticketMeterData;
	private TicketGaugeData ticketGaugeData;
	private float totalBarrels;
	private Tank tank;
	private float gravity;
	private float temp;
	private float bsw;
	private String sealOff;
	private Date sealOffDate;
	private String sealOn;
	private Date sealOnDate;
	private String comments;
	
	public TicketMeterData getTicketMeterData() {
		return ticketMeterData;
	}
	public void setTicketMeterData(TicketMeterData ticketMeterData) {
		this.ticketMeterData = ticketMeterData;
	}
	public TicketGaugeData getTicketGaugeData() {
		return ticketGaugeData;
	}
	public void setTicketGaugeData(TicketGaugeData ticketGaugeData) {
		this.ticketGaugeData = ticketGaugeData;
	}
	public float getTotalBarrels() {
		return totalBarrels;
	}
	public void setTotalBarrels(float totalBarrels) {
		this.totalBarrels = totalBarrels;
	}
	public Tank getTank() {
		return tank;
	}
	public void setTank(Tank tank) {
		this.tank = tank;
	}
	public float getGravity() {
		return gravity;
	}
	public void setGravity(float gravity) {
		this.gravity = gravity;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getBsw() {
		return bsw;
	}
	public void setBsw(float bsw) {
		this.bsw = bsw;
	}
	public String getSealOff() {
		return sealOff;
	}
	public void setSealOff(String sealOff) {
		this.sealOff = sealOff;
	}
	public Date getSealOffDate() {
		return sealOffDate;
	}
	public void setSealOffDate(Date sealOffDate) {
		this.sealOffDate = sealOffDate;
	}
	public String getSealOn() {
		return sealOn;
	}
	public void setSealOn(String sealOn) {
		this.sealOn = sealOn;
	}
	public Date getSealOnDate() {
		return sealOnDate;
	}
	public void setSealOnDate(Date sealOnDate) {
		this.sealOnDate = sealOnDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
