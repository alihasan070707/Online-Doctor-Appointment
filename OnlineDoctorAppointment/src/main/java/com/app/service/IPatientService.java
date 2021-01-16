package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

public interface IPatientService {
	
	Patient getPatientDetails(String email,char[] password);
	
	public String addPatient(Patient patient);
	
	/* List<Appointment> getAppointmentDetails(Integer patient_id); */
	
	List<Prescription> getPrescription(Integer patient_id);
	
	/*
	 * public void removeAppointment(Integer appointment_id);
	 * 
	 * public String addAppointment(Integer patient_id,Appointment appointment);
	 */
	
}
