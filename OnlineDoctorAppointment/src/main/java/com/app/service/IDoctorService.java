package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Doctor;

public interface IDoctorService {
	public void registerDoc (Doctor newDoctor);
	public void authenticateLogin (String email, String password);
	public void uploadPrescription(MultipartFile Pdffile,Integer patient_id);
	public void updateAppointmentStatus(String status);
	//public void 
}
