package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.AppointmentDto;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	List<Appointment> findAllByPatientId(Patient patient_id);
	
	
	List<Appointment> findAllByDrId(Doctor doctor_id);
	
	void deleteById(Integer appointmentId);
	
}
