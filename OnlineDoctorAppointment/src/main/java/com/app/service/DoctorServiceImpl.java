package com.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepsitory;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	AppointmentRepository appointmentDao;
	DoctorRepsitory doctorDao;
	
	@Override
	public void registerDoc(Doctor newDoctor) {
		
			doctorDao.save(newDoctor);
	}

	@Override
	public Doctor authenticateLogin(String email, char[] password) {
		
		Optional<Doctor> doctorOpt = doctorDao.findByEmailAndPassword(email, password);
		
		return (doctorOpt.isPresent())?doctorOpt.get():null;
	
	}

	@Override public void updateAppointmentStatus(Integer appointmentId , int status) {
		
		Optional<Appointment> appointment = appointmentDao.findById(appointmentId);
		if(appointment.isPresent())
			appointment.get().setStatus(status);
	}
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
}
