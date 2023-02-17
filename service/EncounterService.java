package com.ty.springboot_hospital_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.BarnchDao;
import com.ty.springboot_hospital_app.dao.EncounterDao;
import com.ty.springboot_hospital_app.dao.PersonDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.exception.EncounterIdNotFoundException;

import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterdao;
	
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BarnchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = personDao.getPersonById(pid);
		Branch branch = branchDao.getBranchById(bid);
		if (person != null && branch != null) {
			

			List<Branch> list = new ArrayList<Branch>();
			list.add(branch);
			encounter.setList(list);
			encounter.setPerson(person);

			ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
			responseStructure.setMessage("saved Encounter");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(encounterdao.saveEncounter(encounter));

			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new EncounterIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int eid, int bid) {

		Encounter encounterdb = encounterdao.getEncounterById(eid);
		Branch branch = branchDao.getBranchById(bid);
		if(encounterdb != null && branch != null) {
		List<Branch> list = encounterdb.getList();
		list.add(branch);
		encounter.setList(list);;
		encounter.setPerson(encounterdb.getPerson());

		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		responseStructure.setMessage("Encounter is Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterdao.updateencounter(encounter, eid));

		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		}else {
			throw new EncounterIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid) {
		Encounter encounter = encounterdao.deleteEncounter(eid);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
			responseStructure.setMessage("Encounter is Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EncounterIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int eid) {
		Encounter encounter = encounterdao.getEncounterById(eid);
		if (encounter != null) {
			ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
			responseStructure.setMessage("Encounter is found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			throw new  EncounterIdNotFoundException();
		}
	}
}
