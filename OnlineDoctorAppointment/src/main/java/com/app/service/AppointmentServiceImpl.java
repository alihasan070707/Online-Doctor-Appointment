package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepsitory;
import com.app.dao.PatientRepository;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.TimeFrame;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	public AppointmentRepository appointmentdao;
	@Autowired
	public DoctorRepsitory doctordao;
	@Autowired
	public PatientRepository patientdao;

	@Override
	public List<Appointment> findAllByPatientId(Integer patient_id) {
		
		return appointmentdao.findAllByPatientId(patient_id);
	}

	@Override
	public void deleteById(Integer appointmentId) {
		
		appointmentdao.deleteById(appointmentId);

	}

	@Override
	public boolean addAppointment(Doctor drId, Patient patientId, TimeFrame id, Integer status) {
		
		Appointment appointment= new Appointment(drId, patientId, id, status);
		
		Optional<Patient> patient=patientdao.findById(patientId.getId());
		if(patient.isPresent()) {
			 Patient patientobj=patient.get();
			 patientobj.addAppointment(appointment);
			 patientdao.save(patientobj);
			 }
			
		return false;
	}

}
