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
import com.app.emailService.EmailService;
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
	@Autowired
	private EmailService notificationService;

	@Override
	public List<AppointmentDto> findAllByPatientId(Patient patientId) {
		List<AppointmentDto> appointment = new ArrayList<>();
		List<Appointment> appointments = appointmentDao.findAllByPatientIdAndStatus(patientId,0);
		appointments.removeIf((Appointment obj) -> obj.getId().getDate().isBefore(LocalDate.now()));
		appointments
				.sort((Appointment obj, Appointment obj2) -> obj.getId().getDate().compareTo(obj2.getId().getDate()));
		appointments.forEach((Appointment obj) -> {
			appointment.add(new AppointmentDto(obj.getAppId(), obj.getPatientId().getId(), obj.getDrId().getId(),
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
		Appointment appointment = new Appointment(doctor.get(), patient.get(), time.get(), 0);
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
		List<Appointment> appointments = appointmentDao.findAllByDrIdAndStatus(doctor_id,0);
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
					new AppointmentDto(obj.getAppId(), obj.getPatientId().getId(), 0, obj.getPatientId().getName(),
							"abcd", obj.getId().getStartTime(), obj.getId().getEndTime(), obj.getId().getDate()));
		});

		return appointment;
	}

	@Override
	public void updateAppointmentStatus(Integer appointmentId, int status) {
		System.out.println("in update" + status);
		Optional<Appointment> appointment = appointmentDao.findById(appointmentId);
		System.out.println(appointmentId);
		
		String patientEmail = patientDao.findById(appointment.get().getPatientId().getId()).get().getEmail();
		String doctorEmail = doctorDao.findById(appointment.get().getDrId().getId()).get().getEmail();
		
		//System.out.println(appointment.get());
		if (appointment.isPresent()) {
			System.out.println("comes here");
			appointment.get().setStatus(status);
			appointmentDao.save(appointment.get());
			notificationService.sendEmail(patientEmail,notificationService.cancelSubject(),notificationService.cancelBody());
			notificationService.sendEmail(doctorEmail,notificationService.cancelSubject(),notificationService.cancelBody());
			
		}
	}
}
