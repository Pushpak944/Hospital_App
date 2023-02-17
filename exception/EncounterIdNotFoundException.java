package com.ty.springboot_hospital_app.exception;

public class EncounterIdNotFoundException extends RuntimeException{

	private String message="Encounter id not found for given ID";

	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public EncounterIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EncounterIdNotFoundException() {
		super();
	}
	
	
}
