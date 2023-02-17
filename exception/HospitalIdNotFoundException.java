package com.ty.springboot_hospital_app.exception;

public class HospitalIdNotFoundException extends RuntimeException {

	String message="Hospital id not found for given ID";

	@Override
	public String getMessage()
	{
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}


	public HospitalIdNotFoundException(String message) {
		this.message = message;
	}


	public HospitalIdNotFoundException() {
		super();
		
	}
	
	
}
