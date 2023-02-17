package com.ty.springboot_hospital_app.exception;

public class PersonIdNotFoundException extends RuntimeException{

	private String message="Person id not found for given ID";

	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}


	public PersonIdNotFoundException(String message) {
		super();
		this.message = message;
	}


	public PersonIdNotFoundException() {
		super();
	
	}
	
	
}
