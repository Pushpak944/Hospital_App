package com.ty.springboot_hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}