package com.satishlabs.exception;

public class ResourceNotFoundException extends RuntimeException{
	String message;

	public ResourceNotFoundException(String message, String string, long id) {
		this.message = message;
	}
	
}
