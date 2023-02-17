package com.ty.springboot_hospital_app.repo;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

	public Hospital findByEmail(String email);
}
