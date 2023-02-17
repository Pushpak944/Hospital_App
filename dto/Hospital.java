package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="hospital name should not be null")
	@NotBlank(message="hospital name should not be blank")
	private String name;
	@NotNull(message="gst should not be null")
	@NotBlank(message="gst should be mandatory")
	private String gst;
	@Email(message="")
	private String email;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gst
	 */
	public String getGst() {
		return gst;
	}
	/**
	 * @param gst the gst to set
	 */
	public void setGst(String gst) {
		this.gst = gst;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", gst=" + gst + ", email=" + email + "]";
	}
	
	
}
