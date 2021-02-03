package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepsitory;
import com.app.dao.PatientRepository;
import com.app.dao.TimeFrameRepo;
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
	@Autowired
	public TimeFrameRepo timedao;

	@Override
	public List<Appointment> findAllByPatientId(Integer patient_id) {
		
		return appointmentdao.findAllByPatientId(patient_id);
	}

	@Override
	public void deleteById(Integer appointmentId) {
		
		appointmentdao.deleteById(appointmentId);

	}

	@Override
	public boolean addAppointment(Integer drId, Integer patientId, Integer id, Integer status) {
		Optional<Doctor> doctor=doctordao.findById(drId);
		Optional<Patient> patient =patientdao.findById(patientId);
		Optional<TimeFrame> time =timedao.findById(id);
		time.get().setBooked(true);
		Appointment appointment= new Appointment(doctor.get(), patient.get(), time.get(), status);
		System.out.println(appointment);
		
		appointmentdao.save(appointment);
		/*
		 * Optional<Patient> patient=patientdao.findById(patientId.getId());
		 * if(patient.isPresent()) { Patient patientobj=patient.get();
		 * patientobj.addAppointment(appointment); patientdao.save(patientobj); }
		 */
			
		return false;
	}

	@Override
	public List<Appointment> findAllByDoctorId(Doctor doctor_id) {
		List<Appointment> appointments=appointmentdao.findAllByDrId(doctor_id);
		/*
		 * System.out.println(appointments); for(Appointment app : appointments) {
		 * System.out.println(app.getId().getDate() + " " + app.getId()); }
		 */
		appointments.removeIf((Appointment obj)->obj.getId().getDate().isBefore(LocalDate.now()));
		appointments.sort((Appointment obj,Appointment obj2)->obj.getId().getDate().compareTo(obj2.getId().getDate()));
		return appointments;
	}

}
