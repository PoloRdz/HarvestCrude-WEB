package com.harvestcrude.services.order;

public class NoSuchOrderException extends OrderException {
	private static final long serialVersionUID = 1L;
	
	public NoSuchOrderException() {
		super();
	}

	public NoSuchOrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchOrderException(String arg0) {
		super(arg0);
	}

	public NoSuchOrderException(Throwable arg0) {
		super(arg0);
	}

}
