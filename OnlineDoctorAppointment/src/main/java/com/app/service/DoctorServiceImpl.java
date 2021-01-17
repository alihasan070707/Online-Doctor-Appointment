package com.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Doctor;

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
			
		String uploadDirString = patient_id.toString();
		try {
			
			pdfFile.transferTo(new File(uploadDirString + File.separator + StringUtils.cleanPath(pdfFile.getOriginalFilename())));	
		
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
