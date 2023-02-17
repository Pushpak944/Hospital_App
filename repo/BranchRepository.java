package com.ty.springboot_hospital_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.util.ResponseStructure;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

	@Query("select b from Branch b where b.hospital=?1")
	public List<Branch> getAllBranchByHospitalId(Hospital hospital);
}
