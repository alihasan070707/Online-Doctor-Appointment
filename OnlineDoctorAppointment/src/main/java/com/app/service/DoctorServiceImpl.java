package com.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Override
	public void registerDoc(Doctor newDoctor) {
		

	}

	@Override
	public void authenticateLogin(String email, String password) {
		

	}

	@Override
	public void updateAppointmentStatus(String status) {
		

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
			System.out.print(pres);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
