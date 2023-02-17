package com.ty.springboot_hospital_app.exception;

public class ConstraintViolationException extends RuntimeException{

	private String message="Invalid credentials";

	@Override
	public String getMessage() {
		
		return message;
	}

	public ConstraintViolationException(String message) {
		super();
		this.message = message;
	}

	public ConstraintViolationException() {
		super();
	}
	
	
}
