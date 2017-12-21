package com.harvestcrude.model.ticket;

import java.io.Serializable;

public class TicketType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ticketTypeId;
	private String name;
	private String identifier;
	private Boolean isMeterRequired;
	private Boolean isGaugeRequired;
	private Boolean isRejectReaseonRequired;
	
	public int getTicketTypeId() {
		return ticketTypeId;
	}
	public void setTicketTypeId(int ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
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
	public Boolean getIsMeterRequired() {
		return isMeterRequired;
	}
	public void setIsMeterRequired(Boolean isMeterRequired) {
		this.isMeterRequired = isMeterRequired;
	}
	public Boolean getIsGaugeRequired() {
		return isGaugeRequired;
	}
	public void setIsGaugeRequired(Boolean isGaugeRequired) {
		this.isGaugeRequired = isGaugeRequired;
	}
	public boolean getIsRejectReaseonRequired() {
		return isRejectReaseonRequired;
	}
	public void setIsRejectReaseonRequired(boolean isRejectReaseonRequired) {
		this.isRejectReaseonRequired = isRejectReaseonRequired;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ticketTypeId;
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
		TicketType other = (TicketType) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ticketTypeId != other.ticketTypeId)
			return false;
		return true;
	}

	@Override
	public String toString(){
		return String.format("%s [ticketTypeId=%d]", getClass().getSimpleName(), ticketTypeId);
	}
}
