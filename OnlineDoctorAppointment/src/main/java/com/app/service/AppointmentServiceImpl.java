package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepsitory;
import com.app.dao.PatientRepository;
import com.app.dao.TimeFrameRepo;
import com.app.dto.AppointmentDto;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.TimeFrame;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	public AppointmentRepository appointmentDao;
	@Autowired
	public DoctorRepsitory doctorDao;
	@Autowired
	public PatientRepository patientDao;
	@Autowired
	public TimeFrameRepo timeDao;

	@Override
	public List<AppointmentDto> findAllByPatientId(Patient patientId) {
		List<AppointmentDto> appointment = new ArrayList<>();
		List<Appointment> appointments = appointmentDao.findAllByPatientId(patientId);
		appointments.removeIf((Appointment obj) -> obj.getId().getDate().isBefore(LocalDate.now()));
		appointments
				.sort((Appointment obj, Appointment obj2) -> obj.getId().getDate().compareTo(obj2.getId().getDate()));
		appointments.forEach((Appointment obj) -> {
			appointment.add(new AppointmentDto(obj.getId().getId(), obj.getPatientId().getId(), obj.getDrId().getId(),
					obj.getPatientId().getName(),obj.getDrId().getName(), obj.getId().getStartTime(), obj.getId().getEndTime(),
					obj.getId().getDate(), obj.getDrId().getAddress().getLocation(),
					obj.getDrId().getAddress().getCity(), obj.getDrId().getFees()));
		});

		return appointment;
	}

	@Override
	public void deleteById(Integer appointmentId) {

		appointmentDao.deleteById(appointmentId);

	}

	@Override
	public boolean addAppointment(Integer drId, Integer patientId, Integer id, Integer status) {
		Optional<Doctor> doctor = doctorDao.findById(drId);
		Optional<Patient> patient = patientDao.findById(patientId);
		Optional<TimeFrame> time = timeDao.findById(id);
		time.get().setBooked(true);
		Appointment appointment = new Appointment(doctor.get(), patient.get(), time.get(), status);
		System.out.println(appointment);

		appointmentDao.save(appointment);
		/*
		 * Optional<Patient> patient=patientdao.findById(patientId.getId());
		 * if(patient.isPresent()) { Patient patientobj=patient.get();
		 * patientobj.addAppointment(appointment); patientdao.save(patientobj); }
		 */

		return false;
	}

	@Override
	public List<AppointmentDto> findAllByDoctorId(Doctor doctor_id) {
		List<Appointment> appointments = appointmentDao.findAllByDrId(doctor_id);
		List<AppointmentDto> appointment = new ArrayList<>();
		/*
		 * System.out.println(appointments); for(Appointment app : appointments) {
		 * System.out.println(app.getId().getDate() + " " + app.getId()); }
		 */
		appointments.removeIf((Appointment obj) -> obj.getId().getDate().isBefore(LocalDate.now()));
		appointments
				.sort((Appointment obj, Appointment obj2) -> obj.getId().getDate().compareTo(obj2.getId().getDate()));
		appointments.forEach((Appointment obj) -> {
			appointment.add(
					new AppointmentDto(obj.getId().getId(), obj.getPatientId().getId(), 0, obj.getPatientId().getName(),
							"abcd", obj.getId().getStartTime(), obj.getId().getEndTime(), obj.getId().getDate()));
		});

		return appointment;
	}

	@Override
	public void updateAppointmentStatus(Integer appointmentId, int status) {

		Optional<Appointment> appointment = appointmentDao.findById(appointmentId);
		if (appointment.isPresent())
			appointment.get().setStatus(status);
	}
}
