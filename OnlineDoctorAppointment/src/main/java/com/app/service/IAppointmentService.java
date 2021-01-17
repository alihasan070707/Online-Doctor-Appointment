package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.TimeFrame;

public interface IAppointmentService{
	
	List<Appointment> findAllByPatientId(Integer patient_id);
	
	void deleteById(Integer appointmentId);
	
	public boolean addAppointment(Doctor drId,Patient patient_id,TimeFrame id,Integer status);

}