package com.ty.springboot_hospital_app.exception;

public class AddressIdNotFoundException extends RuntimeException{

	private String message="Address id not found for given ID";

	
	@Override
	public String getMessage() {
		
		return message;
	}


	public AddressIdNotFoundException(String message) {
		super();
		this.message = message;
	}


	public AddressIdNotFoundException() {
		super();
	}
	
	
}
