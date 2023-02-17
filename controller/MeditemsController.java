package com.ty.springboot_hospital_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.service.MeditemsService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MeditemsController {

	@Autowired
	private MeditemsService service;

	@ApiOperation(value="save Meditems", notes="Api is used to save the Meditems with given Medorder id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully created"),
			@ApiResponse(code=404,message="Id not found for the given Meditems id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PostMapping("/items")
	public ResponseEntity<ResponseStructure<MedItems>> saveMeditems(@RequestBody MedItems items,@RequestParam int mid)
	{
		return service.saveMeditems(items,mid);
	}
	@ApiOperation(value="update Meditems", notes="Api is used to update the Meditems with given Meditems id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully updated"),
			@ApiResponse(code=404,message="Id not found for the given Meditems id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PutMapping("/items")
	public ResponseEntity<ResponseStructure<MedItems>> updateItems(@RequestBody MedItems items,@RequestParam int mid)
	{
		return service.updateMeditems(items, mid);
	}
	@ApiOperation(value="delete Meditems", notes="Api is used to delete the Meditems with given Meditems id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given Meditems id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@DeleteMapping("/items")
	public ResponseEntity<ResponseStructure<MedItems>> deleteitems(@RequestParam int mid)
	{
		return service.deleteMeditems(mid);
	}
	@ApiOperation(value="get Meditems", notes="Api is used to getMeditemsbyId with given Meditems id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully fetched with particular Id"),
			@ApiResponse(code=404,message="Id not found for the given Meditems id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@GetMapping("/items")
	public ResponseEntity<ResponseStructure<MedItems>> getItemsById(@RequestParam int mid)
	{
		return service.getMeditemsById(mid);
	}
}
