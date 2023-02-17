package com.ty.springboot_hospital_app.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.PersonDao;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.exception.PersonIdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;
	
	public ResponseEntity<ResponseStructure< Person>> savePerson(Person person)
	{
		ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
		responseStructure.setMessage("Person Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData(dao.savePeson(person));
		return new ResponseEntity<ResponseStructure<Person>> (responseStructure,HttpStatus.CREATED);	
	}
	public ResponseEntity<ResponseStructure< Person>> updatePerson(int id,Person person)
	{
		Person persondb = dao.updatePerson(id, person);
		if(persondb != null) {
		ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
		responseStructure.setMessage("Person Is Updated Sucessfully");
		responseStructure.setStatus( HttpStatus.OK.value());
		responseStructure.setData(person);
		return new ResponseEntity<ResponseStructure<Person>> (responseStructure,HttpStatus.OK);
		}
	else {
		throw new PersonIdNotFoundException();
	}
	}
	public ResponseEntity<ResponseStructure< Person>> deletePerson(int id)
	{
		Person persondb = dao.deletePerson(id);
		if(persondb != null) {
		ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
		responseStructure.setMessage("Person Is Deleted Sucessfully");
		responseStructure.setStatus( HttpStatus.OK.value());
		responseStructure.setData(dao.deletePerson(id));
		return new ResponseEntity<ResponseStructure<Person>> (responseStructure,HttpStatus.OK);
		}
	else {
		throw new PersonIdNotFoundException();
	}
	}
	
	public ResponseEntity<ResponseStructure< Person>> getByPersonId(int id)
	{
		Person persondb = dao.getPersonById(id);
		if(persondb != null) {
		ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
		responseStructure.setMessage("Person Is Data Found Sucessfully");
		responseStructure.setStatus( HttpStatus.OK.value());
		responseStructure.setData(dao. getPersonById(id));
		return new ResponseEntity<ResponseStructure<Person>> (responseStructure,HttpStatus.OK);
		}
	else {
		throw new PersonIdNotFoundException();
	}
	}
}
