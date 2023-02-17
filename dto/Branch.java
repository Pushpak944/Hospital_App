package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Branch name should not be null")
	@NotBlank(message="Branch name should not be blank")
	private String name;
	@NotNull(message="Manager name should not be null")
	@NotBlank(message="Manager name should not be blank")
	private String manager;
//	@Pattern(regexp="^[6-9][0-9]{9}$",message="Invalid Phone Number")
	private String phone;
	@ManyToOne
	private Hospital hospital;
	@OneToOne
	private Address address;
	
	
}
