package com.ty.springboot_hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.repo.BranchRepository;

@Repository
public class BarnchDao {
	
	@Autowired 
	BranchRepository repo;
	@Autowired
	HospitalDao dao;
	@Autowired
	AddressDao dao2;

	public Branch savebranch(Branch branch,int hid,int aid)
	{
		Hospital hospital=dao.getHospitalById(hid);
		Address address=dao2.getById(aid);	
		if(hospital!=null && address!=null)
		{
			branch.setAddress(address);
			branch.setHospital(hospital);
			return repo.save(branch);
		}
		else{
			return null;
		}
	}
	
	public Branch updateBranch(Branch branch,int bid)
	{
		
		if(repo.findById(bid).isPresent())
		{
			Branch branch2=repo.findById(bid).get();
			branch.setId(bid);
			branch.setHospital(branch2.getHospital());
			branch.setAddress(branch2.getAddress());
			return repo.save(branch);
		}
		else
		{
			return null;
		}

	}
	public Branch deleteBranch(int bid)
	{
		if(repo.findById(bid).isPresent())
		{
			Branch branch=repo.findById(bid).get();
			repo.delete(branch);
			return branch;
		}
		else
		{
			return null;
		}
	}
	public Branch getBranchById(int bid)
	{
		Branch branch=repo.findById(bid).get();
	//	 repo.getById(bid);
		 return branch;
	}
	public List<Branch> getAll()
	{
	return	repo.findAll();
	}
	public List<Branch> getAllBranch(int hid)
	{
		Hospital hospital=dao.getHospitalById(hid);
		if(hospital!=null)
		{
			return repo.getAllBranchByHospitalId(hospital);
		}
		else
		{
			return null;
		}
	}
}