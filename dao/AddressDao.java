package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.repo.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address saveAddress(Address address)
	{
		return addressRepository.save(address);
	}
	public Address updateAddress(int id, Address address)
	{
		
		if(addressRepository.findById( id).isPresent())
		{
			address.setId(id);
			return addressRepository.save(address);
		}else {
			return null;
		}
		
	}
	
	public Address deleteAddress(int id)
	{
		if(addressRepository.findById( id).isPresent())
		{
			Address address=addressRepository.findById( id).get();
			 addressRepository.delete(address);
			return address;
		}
		else {
			return null;
		}
	}
	
	public Address getById(int id)
	{
		if(addressRepository.findById( id).isPresent())
		{
			Address address=addressRepository.findById( id).get();
			return address;
		}
		else {
			return null;
		}
	}
	
	public List<Address> getAllHospitals()
	{
		return addressRepository.findAll();
	}
}
