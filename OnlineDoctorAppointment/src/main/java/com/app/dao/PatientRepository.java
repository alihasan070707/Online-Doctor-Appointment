package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Appointment;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findById(Integer patient_id);
	
	Optional<Patient> findByEmailAndPassword(String email, char[] password);
	
	@Query("Select app from Appointment app where app.patient_id = ?1")
	List<Appointment> findAllAppointments(Integer patient_id);
	
	@Query("Select pres from Prescription pres where pres.patient_id = ?1")
	List<Prescription> findAllPrescriptions(Integer patient_id);
	
	@Query(value = "delete from Appointment a where a.appointment_id = :appointmentId")
	void cancelAppointment(@Param("appointmentId") Integer appointmentId);
}
