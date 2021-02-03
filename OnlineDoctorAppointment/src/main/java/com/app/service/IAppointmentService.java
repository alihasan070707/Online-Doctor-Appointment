package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Doctor;

public interface IAppointmentService{
	
	List<Appointment> findAllByPatientId(Integer patient_id);
	
	List<Appointment> findAllByDoctorId(Doctor doctor_id);
	
	void deleteById(Integer appointmentId);
	
	boolean addAppointment(Integer drId, Integer patientId, Integer timeFrame, Integer status);

}
