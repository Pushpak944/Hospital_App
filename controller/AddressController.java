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

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.service.AddressService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	private AddressService addresService;
	
	@ApiOperation(value="save Address", notes="Api is used to save the Address")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully created"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addresService.saveAddress(address);
	}
	
	@ApiOperation(value="update Address", notes="Api is used to update the address with given address id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully updated"),
			@ApiResponse(code=404,message="Id not found for the given address id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateHospital(@RequestParam int id,
			@RequestBody Address address) {
		return addresService.updateAddress(id, address);
	}
	@ApiOperation(value="delete Address", notes="Api is used to delete the address with given address id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully delete"),
			@ApiResponse(code=404,message="Id not found for the given address id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deletehospital(@RequestParam int id) {
		return addresService.deleteAddress(id);
	}
	@ApiOperation(value="get address", notes="Api is used to getaddressbyId with given address id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully fetched with particular Id"),
			@ApiResponse(code=404,message="Id not found for the given address id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getById(@RequestParam int id) {
		return addresService.getById(id);
	}
}
