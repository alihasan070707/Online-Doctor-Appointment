package com.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepsitory;
import com.app.dto.DoctorCard;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.TimeFrame;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	AppointmentRepository appointmentDao;
	@Autowired
	DoctorRepsitory doctorDao;
	
	@Override
	public boolean registerDoc(Doctor newDoctor) {
		try {
			doctorDao.save(newDoctor);
		} catch (Exception e) {

			return false;
		}
		return true;
			
	}

	@Override
	public Doctor authenticateLogin(String email, char[] password) {
		
		Optional<Doctor> doctorOpt = doctorDao.findByEmailAndPassword(email, password);
		
		return (doctorOpt.isPresent())?doctorOpt.get():null;
	
	}

	/*
	 * @Override public void updateAppointmentStatus(Integer appointmentId , int
	 * status) {
	 * 
	 * Optional<Appointment> appointment = appointmentDao.findById(appointmentId);
	 * if(appointment.isPresent()) appointment.get().setStatus(status); }
	 */
	public void uploadPrescription(MultipartFile pdfFile,Integer patient_id) {
		
		File dir=new File("D:/prescription/"+patient_id);
		if(!dir.exists())
		{
			dir.mkdir();
		}
		
		try {
			
			FileOutputStream file = new FileOutputStream(new File("D:/prescription/"+patient_id+"/"+LocalDateTime.now().hashCode()+""+pdfFile.getOriginalFilename()));
			byte[] pres=pdfFile.getBytes();
			file.write(pres);
			file.close();
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void setTimeFrames(List<String> times,Integer doctor_id) {
		LocalDate date = LocalDate.now();
		List<TimeFrame> timeframes = new ArrayList<>();
		Optional<Doctor> doctorOpt = doctorDao.findById(doctor_id);
		Doctor doctor = doctorOpt.get();
		System.out.println(doctor);
		for(int i=0;i<6;i++) {
			
			for(String time : times) {
			
				LocalTime startTime = LocalTime.parse(time);
				timeframes.add(new TimeFrame(doctor, startTime,
				startTime.plusHours(1), false, date.plusDays(i)));
			}
		}
		doctor.setTimeSlots(timeframes);
		doctorDao.save(doctor);
	}

	@Override
	public List<String> findCityByState(String state) {
		
		return doctorDao.findCityByState(state);
	}

	@Override
	public List<String> findAllState() {
		
		return doctorDao.findAllState();
	}

	@Override
	public List<String> findBySpecialization(String state, String city) {
		
		return doctorDao.findBySpecialization(state, city);
	}

	@Override
	public List<DoctorCard> searchDoctorByStateAndCity(String state, String city) {
		
		List<Doctor> doc= doctorDao.searchDoctorByStateAndCity(state, city);
		List<DoctorCard> docCard=new ArrayList<DoctorCard>();
		doc.forEach(action->{docCard.add(new DoctorCard(action.getId(),action.getName(),action.getSpecialization(),action.getFees()));});
		return docCard;
	}

	@Override
	public List<DoctorCard> searchDoctorByAll(String state, String city, String spec) {
		
		List<Doctor> doc= doctorDao.searchDoctorByAll(state, city ,spec);
		List<DoctorCard> docCard=new ArrayList<DoctorCard>();
		doc.forEach(action->{docCard.add(new DoctorCard(action.getId(),action.getName(),action.getSpecialization(),action.getFees()));});
		return docCard;
		
	}

	@Override
	public Doctor getDoctor(Integer id) {
		Optional<Doctor> doctorOpt = doctorDao.findById(id);
		Doctor doctor = doctorOpt.get();
		return doctor;
	}
	
	
	@Override
	public boolean addProfileImage(MultipartFile profile, Integer doctorId) {
		File dir = new File("D:/CDAC/Project/Online-Doctor-Appointment/FrontEnd/OnlineDoctorAppointment/src/assets/images/DoctorProfilePic/" + doctorId);
		if (!dir.exists()) {
			dir.mkdir();
		}

		try {

			FileOutputStream file = new FileOutputStream(
					new File("D:/CDAC/Project/Online-Doctor-Appointment/FrontEnd/OnlineDoctorAppointment/src/assets/images/DoctorProfilePic/" + doctorId + "/" + profile.getOriginalFilename()));
			byte[] profilepic = profile.getBytes();
			file.write(profilepic);
			file.close();

			return true;

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

	}
	
}
