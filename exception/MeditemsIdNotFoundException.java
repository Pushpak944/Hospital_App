package com.ty.springboot_hospital_app.exception;

public class MeditemsIdNotFoundException extends RuntimeException{

	private String message="Meditems id not found for given ID";

	
	@Override
	public String getMessage() {
		
		return message;
	}


	public MeditemsIdNotFoundException(String message) {
		super();
		this.message = message;
	}


	public MeditemsIdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
