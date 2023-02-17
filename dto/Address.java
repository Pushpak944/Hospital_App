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
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="location should not be null")
	@NotBlank(message="location should not be blank")
	private String location;
	@NotNull(message="Street name should not be null")
	@NotBlank(message="Street name should not be blank")
	private String Street;
	@NotNull(message="road name should not be null")
	@NotBlank(message="road name should not be blank")
	private String road_cross;
	@Pattern(regexp="^[5-9][0-9]{6}",message="Invalid  pincode")
	private String pincode;

	
}
