package com.pal.farm.exception;

public class AssociationNotPermittedException extends Exception {

	private static final long serialVersionUID = 2747339842585673538L;

	private String error;
	
	public AssociationNotPermittedException(String error) {
		super(error);
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		return this.error;
	}

}
