package com.pal.farm.exception;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = -7249679761684346966L;
	
	private String error;
	
	public InvalidRequestException(String error) {
		super(error);
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		return this.error;
	}

}
