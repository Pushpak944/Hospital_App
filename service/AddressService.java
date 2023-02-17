package com.ty.springboot_hospital_app.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.AddressDao;
import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.exception.AddressIdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure< Address>> saveAddress(Address address)
	{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setMessage("Address Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData( addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>> (responseStructure,HttpStatus.CREATED);	
	}
	public ResponseEntity< ResponseStructure< Address>> updateAddress(int id,  Address address)
	{
		Address addressdb =addressDao.updateAddress(id,  address);
		ResponseStructure< Address> responseStructure=new ResponseStructure<Address>();
		if(addressdb != null) {
			
			responseStructure.setMessage("Sucessfully Address is Update");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity< ResponseStructure< Address>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new AddressIdNotFoundException();
	}
	}
	
	public ResponseEntity< ResponseStructure< Address>> deleteAddress(int id)
	{
		Address addressdb =addressDao.deleteAddress(id);
		ResponseStructure< Address> responseStructure=new ResponseStructure<Address>();
		if(addressdb != null) {
			
			responseStructure.setMessage("Sucessfully Address is deleted");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(addressdb);
			return new ResponseEntity< ResponseStructure< Address>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new AddressIdNotFoundException();
	}
	}
	
	public ResponseEntity< ResponseStructure< Address>> getById(int id)
	{
		Address addressdb =addressDao.getById(id);
		ResponseStructure< Address> responseStructure=new ResponseStructure<Address>();
		if(addressdb != null) {
			
			responseStructure.setMessage("Sucessfully Address  is Found");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(addressdb);
			return new ResponseEntity< ResponseStructure< Address>> (responseStructure, HttpStatus.OK);
		}else {
			 throw new  AddressIdNotFoundException();
	}
		 
	}
}
