package com.ty.springboot_hospital_app.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.MeditemsDao;
import com.ty.springboot_hospital_app.dao.MedorderDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.dto.MedOrder;

import com.ty.springboot_hospital_app.exception.MedorderIdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class MedorderService {
	
	@Autowired
	private MedorderDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedorder(MedOrder medOrder,int eid)
	{
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		MedOrder medOrder2=dao.saveMedorder(medOrder, eid);
		if(medOrder2!=null){
		structure.setMessage("Medorder saved Sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(medOrder2);
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.CREATED);
		}else{
			throw new MedorderIdNotFoundException();
		}

	}
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedorder(MedOrder medOrder,int mid)
	{
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		MedOrder medOrder2=dao.updateMedorder(mid, medOrder);
		if(medOrder2!=null)
		{
			structure.setMessage("Medorder Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrder2);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new MedorderIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedorder(int mid){
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		MedOrder medOrder=dao.deleteMedOrder(mid);
		if(medOrder!=null)
		{
			structure.setMessage("Medorder Deleted Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new MedorderIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<MedOrder>> getMedorderById(int bid){
		ResponseStructure<MedOrder> structure=new ResponseStructure<MedOrder>();
		MedOrder medOrder=dao.getMedorderById(bid);
		if(medOrder!=null)
		{
			structure.setMessage("Medorder Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new MedorderIdNotFoundException();
		}
	}
}
