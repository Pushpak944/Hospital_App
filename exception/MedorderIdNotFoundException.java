package com.ty.springboot_hospital_app.exception;

public class MedorderIdNotFoundException extends RuntimeException{

	private String message="Medorder id not found for given ID";

	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}


	public MedorderIdNotFoundException(String message) {
		super();
		this.message = message;
	}


	public MedorderIdNotFoundException() {
		super();
		
	}
	
	
}
