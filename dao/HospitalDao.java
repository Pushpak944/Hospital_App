package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.repo.HospitalRepository;

@Repository
public class HospitalDao {
	
	@Autowired
	private HospitalRepository repo;

	public Hospital saveHospital(Hospital hospital)
	{
	return	repo.save(hospital);
	}
	
	public Hospital updateHospital(int id,Hospital hospital)
	{
		if(repo.findById(id).isPresent())
		{
			hospital.setId(id);
			return repo.save(hospital);
		}
		else
		{
			return null;
		}
	}
	
	public Hospital deleteHospital(int id)
	{
		if(repo.findById(id).isPresent())
		{
			Hospital hospital=repo.findById(id).get();
			repo.delete(hospital);
			return hospital;
		}
		else
		{
			return null;
		}
	}
	
	public Hospital getHospitalById(int id)
	{
		Hospital hospital=repo.findById(id).get();
		repo.getById(id);
		return hospital;
	}
	
	public List<Hospital> getAllHospital()
	{
		return repo.findAll();
	}
	
	public Hospital findByEmail(String email)
	{
		Hospital hospital=repo.findByEmail(email);
		repo.findByEmail(email).getEmail();
		return hospital;
	}
}
