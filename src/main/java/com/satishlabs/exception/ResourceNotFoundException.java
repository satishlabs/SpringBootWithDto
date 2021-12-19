package com.satishlabs.exception;

public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public ResourceNotFoundException(String message, String string, long id) {
		this.message = message;
	}
	
}
