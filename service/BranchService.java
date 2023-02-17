package com.ty.springboot_hospital_app.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.aspectj.apache.bcel.generic.BranchHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.BarnchDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.exception.BranchIdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BarnchDao dao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch,int hid,int aid)
	{
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Branch branch2=dao.savebranch(branch, hid,aid);
		if(branch2!=null){
		structure.setMessage("Branch saved Sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(branch2);
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
		}else{
			throw new BranchIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch,int bid)
	{
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Branch branch2=dao.updateBranch(branch, bid);
		if(branch2!=null)
		{
			structure.setMessage("Branch Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		else
		{
//			structure.setMessage("Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.NOT_FOUND);
			throw new BranchIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int bid){
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Branch branch2=dao.deleteBranch(bid);
		if(branch2!=null)
		{
			structure.setMessage("Branch Deleted Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		else
		{
//			structure.setMessage("Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.NOT_FOUND);
			throw new BranchIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int bid){
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Branch branch2=dao.getBranchById(bid);
		if(branch2!=null)
		{
			structure.setMessage("Branch Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		else
		{
//			structure.setMessage("Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.NOT_FOUND);
			throw new BranchIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllHospital(int hid) {
		List<Branch> list=dao.getAllBranch(hid);
		ResponseStructure<List<Branch>> structure=new ResponseStructure<List<Branch>>();
		if(list!=null)
		{
			 structure.setMessage("Found");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setData(list);
			 return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFoundException();
		}
		
	}
}
