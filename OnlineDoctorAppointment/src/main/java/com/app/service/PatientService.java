package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PatientRepository;
import com.app.pojos.Appointment;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

@Service
@Transactional
public class PatientService implements IPatientService{
	
	@Autowired
	PatientRepository dao;

	@Override
	public String addPatient(Integer patient_id, Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Patient getPatientDetails(String email, char[] password) {
		
		return null;
	}

	@Override
	public List<Appointment> getAppointmentDetails(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prescription> getPrescription(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAppointment(Integer appointmnet_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String addAppointment(Integer paient_id, Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
