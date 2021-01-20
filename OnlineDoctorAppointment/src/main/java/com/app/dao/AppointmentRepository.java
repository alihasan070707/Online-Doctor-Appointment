package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Appointment;
import com.app.pojos.TimeFrame;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	List<Appointment> findAllByPatientId(Integer patient_id);
	
	List<Appointment> findAllByDrId(Integer doctor_id);
	
	void deleteById(Integer appointmentId);
	
}
