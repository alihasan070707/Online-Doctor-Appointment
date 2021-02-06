package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.AppointmentDto;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	List<Appointment> findAllByPatientIdAndStatus(Patient patient_id,Integer status);
	
	
	List<Appointment> findAllByDrIdAndStatus(Doctor doctor_id,Integer status);
	
	void deleteById(Integer appointmentId);
	
}
