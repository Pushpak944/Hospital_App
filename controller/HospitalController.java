package com.ty.springboot_hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dao.HospitalDao;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.service.HospitalService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;
	@Autowired
	private HospitalDao dao;
	@ApiOperation(value="save Hospital", notes="Api is used to save the Hospital")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully created"),
			@ApiResponse(code=404,message="Id not found for the given hospital id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Validated @RequestBody Hospital hospital)
	{
		return service.saveHospital(hospital);
	}
	@ApiOperation(value="update hospital", notes="Api is used to update the hospital with given hospital id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully updated"),
			@ApiResponse(code=404,message="Id not found for the given hospital id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital)
	{
		return service.updateHospital(id, hospital);
	}
	@ApiOperation(value="delete Hospital", notes="Api is used to delete the hospital with given hospital id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully deleted"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id)
	{
		return service.deleteHospital(id);
	}
	@ApiOperation(value="get hospital", notes="Api is used to gethospitalbyId with given hospital id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully fetched with particular Id"),
			@ApiResponse(code=404,message="Id not found for the given hospital id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id)
	{
		return service.getHospitalById(id);
	}
	@GetMapping("/hospitali")
	public List<Hospital> getAll()
	{
		return	dao.getAllHospital();
	}
 }
