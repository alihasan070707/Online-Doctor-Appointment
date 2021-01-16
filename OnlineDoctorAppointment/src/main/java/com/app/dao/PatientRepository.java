package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
}
