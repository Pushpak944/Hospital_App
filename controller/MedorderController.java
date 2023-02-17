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

import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.MedOrder;
import com.ty.springboot_hospital_app.service.MedorderService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedorderController {

	@Autowired
	MedorderService service;
	
	@ApiOperation(value="save Medorder", notes="Api is used to save the Medorder with given Encounter id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully created"),
			@ApiResponse(code=404,message="Id not found for the given Medorder id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<MedOrder>> savemedorder(@RequestBody MedOrder medOrder,@RequestParam int eid)
	{
		return service.saveMedorder(medOrder, eid);
	}
	@ApiOperation(value="update Medorder", notes="Api is used to update the Medorder with given Medorder id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully updated"),
			@ApiResponse(code=404,message="Id not found for the given Medorder id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PutMapping("/order")
	public ResponseEntity<ResponseStructure<MedOrder>> updateBranch(@RequestBody MedOrder medOrder,@RequestParam int mid)
	{
		return service.updateMedorder(medOrder, mid);
	}
	@ApiOperation(value="delete Medorder", notes="Api is used to delete the Medorder with given Medorder id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given Medorder id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@DeleteMapping("/order")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteHospital(@RequestParam int mid)
	{
		return service.deleteMedorder(mid);
	}
	@ApiOperation(value="get Medorder", notes="Api is used to getMedorderbyId with given Medorder id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully fetched with particular Id"),
			@ApiResponse(code=404,message="Id not found for the given Medorder id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@GetMapping("/order")
	public ResponseEntity<ResponseStructure<MedOrder>> getHospitalById(@RequestParam int mid)
	{
		return service.getMedorderById(mid);
	}
	
}
