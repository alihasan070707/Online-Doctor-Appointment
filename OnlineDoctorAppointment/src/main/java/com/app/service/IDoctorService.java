package com.app.service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.DoctorCard;
import com.app.pojos.Doctor;

public interface IDoctorService {
	public boolean registerDoc (Doctor newDoctor);
	public Doctor authenticateLogin (String email, char[] password);
	public void uploadPrescription(MultipartFile Pdffile,Integer patient_id);

	/* public void updateAppointmentStatus(Integer appointmentId,int status); */
	public void setTimeFrames(List<String> times,Integer doctor_id);
	public List<String> findCityByState(String state);
	List<String> findAllState();
	List<String> findBySpecialization(String state,String city);
	List<DoctorCard> searchDoctorByStateAndCity(@Param("state") String state, @Param("city") String city);
	List<DoctorCard> searchDoctorByAll(@Param("state") String state, @Param("city") String city, @Param("spec") String spec);	
	Doctor getDoctor(Integer id);
	boolean addProfileImage(MultipartFile profile, Integer patient_id);
	
	//public void 
}
