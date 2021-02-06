package com.app.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.DoctorRepsitory;
import com.app.dao.TimeFrameRepo;
import com.app.dto.AppointmentDto;
import com.app.emailService.EmailService;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.TimeFrame;
import com.app.service.IAppointmentService;
import com.app.service.IPatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {

	@Autowired
	private IPatientService service;
	@Autowired
	private IAppointmentService appService;
	@Autowired
	private TimeFrameRepo timeFrameDao;
	@Autowired
	private DoctorRepsitory docRepo;
	
	
	@GetMapping("/login")
	public ResponseEntity<?> showPatientLoginPage() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginPatient(@RequestParam String email, @RequestParam String password) {
		Patient patient = service.getPatientDetails(email, password.toCharArray());
		if (patient != null) {
			/* notificationService.sendEmail(); */
			return new ResponseEntity<>(patient.getId(),HttpStatus.OK);
			
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/register")
	public ResponseEntity<?> showPatientRegisterPage() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerPatient(@RequestParam("data") String patientJson,
			@RequestParam("photo") MultipartFile photo) {
		System.out.println(patientJson);
		Patient patient = null;
		try {
			patient = new ObjectMapper().readValue(patientJson, Patient.class);
			System.out.println(patient);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		patient.setPicture(photo.getOriginalFilename());
		if (service.addPatient(patient)) {
			service.addProfileImage(photo, patient.getId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/prescriptions")
	public List<String> getPrescriptions(@RequestParam Integer patientId) {
		System.out.println("in pres");
		List<String> list = service.getPrescription(patientId);
		if (list == null) {
			return list;
		}
		return list;
	}

	@PostMapping("/appointment")
	public ResponseEntity<?> addAppointment(@RequestParam Integer drId, @RequestParam Integer patientId,
			@RequestParam Integer timeFrame, @RequestParam Integer status) {
		/*
		 * System.out.println(appointment.getDrId());
		 * System.out.println(appointment.getPatientId());
		 */
		Patient patient=service.getPatient(patientId);
		boolean getApp = appService.addAppointment(drId, patientId, timeFrame, status);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/time")
	public List<TimeFrame> getTimeFrames(@RequestParam("drId") Integer drId,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Doctor doctor = docRepo.findById(drId).get();

		return timeFrameDao.findAllByDrIdAndDate(doctor, date);

	}

	@GetMapping("/getDetails")
	public Patient getPatient(@RequestParam Integer id) {
		return service.getPatient(id);
	}

	@GetMapping("/appointments")
	public ResponseEntity<?> getAllAppointment(@RequestParam Patient patientId) {
		List<AppointmentDto> appointment=appService.findAllByPatientId(patientId);
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

	@GetMapping("/download")
	public ResponseEntity<Object> downloadFile(@RequestParam String files) throws IOException
	{
		String filename = "D:/prescription/1/" + files;
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
	
	@GetMapping("/cancelAppointment")
	public ResponseEntity<?> cancelAppointment(@RequestParam Integer appId) {
		appService.updateAppointmentStatus(appId, 3);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
