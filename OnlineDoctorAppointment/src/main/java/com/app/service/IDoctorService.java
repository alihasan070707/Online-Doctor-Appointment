package com.app.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Doctor;

public interface IDoctorService {
	public void registerDoc (Doctor newDoctor);
	public Doctor authenticateLogin (String email, char[] password);
	public void uploadPrescription(MultipartFile Pdffile,Integer patient_id);
	public void updateAppointmentStatus(Integer appointmentId,int status);
	public void setTimeFrames(List<LocalTime> times,Integer doctor_id);
	public List<String> findCityByState(String state);
	List<String> findAllState();
	List<String> findBySpecialization(String state,String city);
	//public void 
}
