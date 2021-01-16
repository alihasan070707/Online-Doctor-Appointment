package com.app.service;

import com.app.pojos.Doctor;

public interface IDoctorService {
	public void registerDoc (Doctor newDoctor);
	public void authenticateLogin (String email, String password);
	
	public void updateAppointmentStatus(String status);
	//public void 
}
