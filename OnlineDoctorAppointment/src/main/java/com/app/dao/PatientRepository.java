package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Patient;
import com.app.pojos.Prescription;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findById(Integer patient_id);
	
	Optional<Patient> findByEmailAndPassword(String email, char[] password);
	
	
	
	
	
	
}
