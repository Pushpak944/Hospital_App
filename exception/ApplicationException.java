package com.ty.springboot_hospital_app.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mysql.cj.util.DnsSrv.SrvRecord;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(HospitalIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> hospitalidNotFound(HospitalIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("Hospital id is Not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map=new HashMap<String, String>();
		for (ObjectError objectError : errors) {
			String feildname=((FieldError)objectError).getField();
			String message=((FieldError)objectError).getDefaultMessage();
			
			map.put(feildname, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ResponseStructure<String>> constraint(ConstraintViolationException ex){
//		ResponseStructure<String> structure=new ResponseStructure<String>();
//		structure.setMessage(ex.getMessage());
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//
//		structure.setData("Webpage does not exsist");
//		
//		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
//	}
	@ExceptionHandler(BranchIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> BranchidNotFound(BranchIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("Branch id is Not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AddressIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> addressidNotFound(AddressIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("address id is Not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PersonIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> personidNotFound(PersonIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("Person id is Not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EncounterIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> encounteridNotFound(EncounterIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("Encounter id is Not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MedorderIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> medorderidNotFound(MedorderIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("Medorder id is Not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MeditemsIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> meditemsidNotFound(MeditemsIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("Meditems id is Not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintEntityValidationException(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> set=e.getConstraintViolations();
		List<String> list = new ArrayList<String>();
		for (ConstraintViolation<?> cve : set) {
			String name = cve.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list, HttpStatus.BAD_REQUEST);

	}
	
	}

