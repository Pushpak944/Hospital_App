package com.ty.springboot_hospital_app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.dto.MedOrder;
import com.ty.springboot_hospital_app.repo.MedOrderRepository;

@Repository
public class MedorderDao {
	
	@Autowired
	private MedOrderRepository repo;
	@Autowired
	private EncounterDao dao2;
	

	public MedOrder saveMedorder(MedOrder medOrder,int eid)
	{
		Encounter encounter=dao2.getEncounterById(eid);
		if(encounter!=null)
		{
			medOrder.setEncounter(encounter);
			MedOrder medOrder2=repo.save(medOrder);
			return medOrder2;
		}
		else
		{
			return null;
		}
	}
	public MedOrder updateMedorder(int mid,MedOrder medOrder)
	{
		if(repo.findById(mid).isPresent())
		{
			MedOrder medOrder2=repo.findById(mid).get();
			medOrder.setId(mid);
			medOrder.setEncounter(medOrder2.getEncounter());
			return repo.save(medOrder);
		}
		else
		{
			return null;
		}
	}
	public MedOrder deleteMedOrder(int id)
	{
		if(repo.findById(id).isPresent())
		{
			MedOrder medOrder=repo.findById(id).get();
			 repo.delete(medOrder);
			 return medOrder;
		}
		else
		{
			return null;
		}
	}
	public MedOrder getMedorderById(int id)
	{
		if (repo.findById(id).isPresent()) {
			MedOrder medOrder = repo.findById(id).get();
			return medOrder;
		} else {
			return null;
		}
	}
}
