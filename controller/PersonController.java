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

import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.service.PersonService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	
	@Autowired
	private PersonService service;
	
	@ApiOperation(value="save person", notes="Api is used to save the person")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully created"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(value="update person", notes="Api is used to update the person with given person id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully updated"),
			@ApiResponse(code=404,message="Id not found for the given person id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id,@RequestBody Person person) {
		return service.updatePerson(id,person);
	}
	@ApiOperation(value="delete person", notes="Api is used to delete the person with given person id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully delete"),
			@ApiResponse(code=404,message="Id not found for the given person id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@DeleteMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}
	@ApiOperation(value="get person", notes="Api is used to getpersonbyId with given person id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully fetched with particular Id"),
			@ApiResponse(code=404,message="Id not found for the given person id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@GetMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getByPersonId(id);
	}
}
