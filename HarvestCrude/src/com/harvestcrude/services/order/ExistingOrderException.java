package com.harvestcrude.services.order;

public class ExistingOrderException extends OrderException {
	private static final long serialVersionUID = 1L;

	public ExistingOrderException() {
		super();
	}

	public ExistingOrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExistingOrderException(String arg0) {
		super(arg0);
	}

	public ExistingOrderException(Throwable arg0) {
		super(arg0);
	}
}
