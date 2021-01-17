package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PatientRepository;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

@Service
public class PatientService implements IPatientService{
	
	@Autowired
	PatientRepository dao;

	@Override
	public boolean addPatient(Patient patient) {
		try {
		dao.save(patient);
		}
		catch(Exception e){
		
			return false;
		}
		return true;
	}
	
	@Override
	public Patient getPatientDetails(String email, char[] password) {
		
		 Optional<Patient> patient=dao.findByEmailAndPassword(email, password);
		 if(patient.isPresent()) {
		 return patient.get();
		 }
		
			 return null;
	}

	/*
	 * @Override public List<Appointment> getAppointmentDetails(Integer patient_id)
	 * {
	 * 
	 * return dao.findAllAppointments(patient_id); }
	 */

	@Override
	public List<Prescription> getPrescription(Integer patient_id) {
		
		return dao.findAllPrescriptions(patient_id);
	}

	/*
	 * @Override public void removeAppointment(Integer appointment_id) {
	 * 
	 * dao.cancelAppointment(appointment_id); }
	 * 
	 * @Override public String addAppointment(Integer paient_id, Appointment
	 * appointment) {
	 * 
	 * return dao.addAppointments(drId, patientId, id, status);; }
	 */
	

}
