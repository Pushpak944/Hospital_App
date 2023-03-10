package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Person name should not be null")
	@NotBlank(message="Person name should not be blank")
	private String name;
	
	private String email;
//	@Pattern(regexp="^[6-9][0-9]{9}$",message="Invalid Phone Number")
	private String phone;
	
}
