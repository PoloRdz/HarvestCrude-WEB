package com.harvestcrude.services.order;

import com.harvestcrude.services.ServiceException;

public class OrderException extends ServiceException {
	private static final long serialVersionUID = 1L;
	
	public OrderException(){
		super();
	}

	public OrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OrderException(String arg0) {
		super(arg0);
	}

	public OrderException(Throwable arg0) {
		super(arg0);
	}

}
