package com.cg.ARS.exceptions;


public class BookingExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	public BookingExceptions(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public BookingExceptions(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BookingExceptions(String message) {
		super(message);
	
	}

	public BookingExceptions(Throwable cause) {
		super(cause);
		
	}

	public BookingExceptions() {
	
	}

}
