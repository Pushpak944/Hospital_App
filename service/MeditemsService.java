package com.ty.springboot_hospital_app.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.MeditemsDao;
import com.ty.springboot_hospital_app.dao.MedorderDao;
import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.dto.MedOrder;
import com.ty.springboot_hospital_app.exception.MeditemsIdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class MeditemsService {
	
	@Autowired
	private MeditemsDao dao;
	@Autowired
	private MedorderDao dao2;

	public ResponseEntity<ResponseStructure<MedItems>> saveMeditems(MedItems items,int oid)
	{
		MedOrder medOrder=dao2.getMedorderById(oid);
		if(medOrder!=null){
		
		ResponseStructure<MedItems> responseStructure=new ResponseStructure<MedItems>();
		items.setMedOrder(medOrder);
		MedItems medItems =dao.saveMeditems(items, oid);
		responseStructure.setMessage("Meditems Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData(medItems);
		return new ResponseEntity<ResponseStructure<MedItems>> (responseStructure,HttpStatus.CREATED);
		}
		else
		{
			throw new MeditemsIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<MedItems>> updateMeditems(MedItems medItems,int mid)
	{
		ResponseStructure<MedItems> structure=new ResponseStructure<MedItems>();
		MedItems medItems2=dao.updateMeditems(mid, medItems);
		if(medItems2!=null)
		{
			structure.setMessage("Meditems Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItems2);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new MeditemsIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<MedItems>> deleteMeditems(int mid){
		ResponseStructure<MedItems> structure=new ResponseStructure<MedItems>();
		MedItems medItems=dao.deleteMedItems(mid);
		if(medItems!=null)
		{
			structure.setMessage("Meditems Deleted Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new MeditemsIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<MedItems>> getMeditemsById(int mid){
		ResponseStructure<MedItems> structure=new ResponseStructure<MedItems>();
		MedItems medItems=dao.getMedItemsById(mid);
		if(medItems!=null)
		{
			structure.setMessage("Meitems Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new MeditemsIdNotFoundException();
		}
	}
}
