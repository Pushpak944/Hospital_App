package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.repo.MedItemsRepository;

@Repository
public class MeditemsDao {

	@Autowired
	private MedItemsRepository itemsRepository;
	
	public MedItems saveMeditems(MedItems items,int mid)
	{
		return itemsRepository.save(items);
	}
	
	public MedItems updateMeditems(int mid,MedItems medItems)
	{
		if(itemsRepository.findById(mid).isPresent())
		{
			MedItems medItems2=itemsRepository.findById(mid).get();
			medItems.setId(mid);
			medItems.setMedOrder(medItems2.getMedOrder());
			return itemsRepository.save(medItems);
		}
		else
		{
			return null;
		}
	}
	public MedItems deleteMedItems(int mid)
	{
		if(itemsRepository.findById(mid).isPresent())
		{
			MedItems items=itemsRepository.findById(mid).get();
			 itemsRepository.delete(items);
			return items;
		}
		else
		{
			return null;
		}
	}
	public MedItems getMedItemsById(int id)
	{
		if(itemsRepository.findById(id).isPresent())
		{
			MedItems items=itemsRepository.findById(id).get();
			return items;
		}
		else
		{
			return null;
		}
	}
	 public List<MedItems> getAll()
	 {
		 return itemsRepository.findAll();
	 }
}
