package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Appointment;
import com.app.pojos.Doctor;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	List<Appointment> findAllByPatientId(Integer patient_id);
	
	
	List<Appointment> findAllByDrId(Doctor doctor_id);
	
	void deleteById(Integer appointmentId);
	
}
