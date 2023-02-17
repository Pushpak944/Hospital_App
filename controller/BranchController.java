package com.ty.springboot_hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dao.BarnchDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.service.BranchService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService service;
	@Autowired
	private BarnchDao dao;
	
	
	@ApiOperation(value="save Branch", notes="Api is used to save the branch with given hospital id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully created"),
			@ApiResponse(code=404,message="Id not found for the given hospital id or Address id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch,@RequestParam int hid,@RequestParam int aid)
	{
		return service.saveBranch(branch, hid,aid);
	}

	@ApiOperation(value="update branch", notes="Api is used to update the branch with given branch id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully updated"),
			@ApiResponse(code=404,message="Id not found for the given branch id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@RequestParam int bid)
	{
		return service.updateBranch(branch, bid);
	}
	
	@ApiOperation(value="delete Branch", notes="Api is used to delete the branch with given branch id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given branch id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteHospital(@RequestParam int bid)
	{
		return service.deleteBranch(bid);
	}

	@ApiOperation(value="get Branch", notes="Api is used to getBranchbyId with given branch id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully fetched with particular Id"),
			@ApiResponse(code=404,message="Id not found for the given branch id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getHospitalById(@RequestParam int bid)
	{
		return service.getBranchById(bid);
	}
	@GetMapping("/branches")
	public List<Branch> getAllBranch()
	{
		return dao.getAll();
	}
	@GetMapping("/branch1")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHid(@RequestParam int hid)
	{
		return service.getAllHospital(hid);
	}
}
