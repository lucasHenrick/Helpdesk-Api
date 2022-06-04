package com.help.desk.services.exception;

public class DataIntegrityVioolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	public DataIntegrityVioolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityVioolationException(String message) {
		super(message);
	}

	

}
