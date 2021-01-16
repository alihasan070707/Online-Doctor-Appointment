package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Appointment;
import com.app.pojos.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findById(Integer patient_id);
	
	Optional<Patient> findByEmailAndPassword(String email, String password);
	
	@Query("Select app from Appointment app where app.patient_id = ?1")
	List<Appointment> findAllAppointments(Integer patient_id);
	
	@Query("Select pres from Prescription pres where pres.patient_id = ?1")
	List<Appointment> findAllPrescriptoins(Integer patient_id);
	
}
