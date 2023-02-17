package com.ty.springboot_hospital_app.exception;

public class BranchIdNotFoundException extends RuntimeException{

	private String message="Branch id not found for given ID";

	@Override
	public String getMessage() {
		return message;
	}

	public BranchIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BranchIdNotFoundException() {
		super();
	}
	
	
}
