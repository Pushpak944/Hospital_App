package com.ty.springboot_hospital_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.service.EncounterService;
import com.ty.springboot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService encounterService;
	@ApiOperation(value="save Encounter", notes="Api is used to save the Encounter with given person id and branch id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully created"),
			@ApiResponse(code=404,message="Id not found for the given person id or branch id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,
			@RequestParam int pid, @RequestParam int bid) {
		return encounterService.saveEncounter(encounter, pid, bid);
	}
	@ApiOperation(value="update Encounter", notes="Api is used to update the Encounter with given encounter id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully updated"),
			@ApiResponse(code=404,message="Id not found for the given Encounter id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,
			@RequestParam int eid, @RequestParam int bid) {
		return encounterService.updateEncounter(encounter, eid, bid);
	}
	@ApiOperation(value="delete Encounter", notes="Api is used to delete the Encounter with given encounter id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given encounter id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int eid) {
		return encounterService.deleteEncounter(eid);
	}
	@ApiOperation(value="get Encounter", notes="Api is used to getEncounterbyId with given Encounter id")
	@ApiResponses(value={
			@ApiResponse(code=201,message="sucessfully fetched with particular Id"),
			@ApiResponse(code=404,message="Id not found for the given Encounter id"),
			@ApiResponse(code=401,message="Webpage does not exist")
	})
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int eid) {
		return encounterService.getEncounterById(eid);
	}
}
