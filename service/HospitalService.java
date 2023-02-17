package com.ty.springboot_hospital_app.service;

import java.util.NoSuchElementException;

import javax.validation.ConstraintDeclarationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.HospitalDao;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.exception.HospitalIdNotFoundException;

import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		Hospital hospital2=dao.saveHospital(hospital);
		if(hospital2!=null){
		structure.setMessage("Hospital saved Sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(hospital2);
		
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
		}else{
			throw new ConstraintDeclarationException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital) 
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		Hospital hospital2=dao.updateHospital(id, hospital);
		if(hospital2!=null)
		{
			structure.setMessage("Hospital Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital2);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);

		}
		else {
//			structure.setMessage("Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.NOT_FOUND);
			
			throw new HospitalIdNotFoundException();
		}

	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		Hospital hospital2=dao.deleteHospital(id);
		if(hospital2!=null)
		{
			structure.setMessage("Hospital Deleted Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital2);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		else {
//			structure.setMessage("Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.NOT_FOUND);
			throw new HospitalIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
		Hospital hospital2=dao.deleteHospital(id);
		if(hospital2!=null)
		{
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital2);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		else
		{
//			structure.setMessage("Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.NOT_FOUND);
			throw new HospitalIdNotFoundException();
		}
	}
	
	
}
