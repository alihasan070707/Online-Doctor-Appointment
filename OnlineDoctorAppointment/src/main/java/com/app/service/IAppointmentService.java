package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDto;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;

public interface IAppointmentService{
	
	List<AppointmentDto> findAllByPatientId(Patient patient_id);
	
	List<AppointmentDto> findAllByDoctorId(Doctor doctor_id);
	
	void deleteById(Integer appointmentId);
	
	boolean addAppointment(Integer drId, Integer patientId, Integer timeFrame, Integer status);

	void updateAppointmentStatus(Integer appointmentId, int status);

}
