package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Patient;

public interface IPatientService {
	
	Patient getPatientDetails(String email,char[] password);
	
	public boolean addPatient(Patient patient);
	
	/* List<Appointment> getAppointmentDetails(Integer patient_id); */
	
	List<String> getPrescription(Integer patient_id);
	
	/*
	 * public void removeAppointment(Integer appointment_id);
	 * 
	 * public String addAppointment(Integer patient_id,Appointment appointment);
	 */
	public boolean addProfileImage(MultipartFile profile,Integer patient_id);
	
	public Patient getPatient(Integer id);
}
