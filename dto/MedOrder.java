package com.ty.springboot_hospital_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Medorder should not be null")
	@NotBlank(message="Medorder should not be blank")
	private String name;
	@Min(value=1,message="Invalid age")
	private int age;
	private String date;
	
	@ManyToOne
	private Encounter encounter;
	
}
