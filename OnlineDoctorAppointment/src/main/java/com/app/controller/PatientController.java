package com.app.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.DoctorRepsitory;
import com.app.dao.TimeFrameRepo;
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
	public String showPatientLoginPage() {
		return "/login";
	}
	
	@PostMapping("/login")
	public String loginPatient(@RequestParam String email, @RequestParam String password) {
		Patient patient = service.getPatientDetails(email, password.toCharArray());
		if (patient == null) {
			return "/login";
		}
		return "/somePage";  //need to be created
	}
	
	@GetMapping("/register")
	public String showPatientRegisterPage() {
		return "/register";
	}
	
	@PostMapping("/register")
	public String registerPatient(@RequestParam("data") String patientJson, @RequestParam("photo") MultipartFile photo) {
		System.out.println(patientJson);
		Patient patient=null;
		try {
			patient = new ObjectMapper().readValue(patientJson, Patient.class);
			System.out.println(patient);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(service.addPatient(patient)) {
			service.addProfileImage(photo, patient.getId());
			return "/somePage"; //need to be created
		}
		return patientJson;
	}
	
	@GetMapping("/prescriptions")
	public List<String> getPrescriptions(@RequestParam Integer patientId, Model map) {
		System.out.println("in pres");
		List<String> list = service.getPrescription(patientId);
		map.addAttribute("prescriptionList", list);
		if(list == null) {
			return list;
		}
		return list; 
	}
	
	@PostMapping("/appointment")
	public String addAppointment (@RequestParam Integer drId,@RequestParam Integer patientId,@RequestParam Integer timeFrame,@RequestParam Integer status ) {
		/*
		 * System.out.println(appointment.getDrId());
		 * System.out.println(appointment.getPatientId());
		 */
		boolean getApp = appService.addAppointment( drId,patientId,timeFrame,status);
		return "/somePage";
	}
	
	@PostMapping("/time")
	public List<TimeFrame> getTimeFrames (@RequestParam("drId") Integer drId, @RequestParam("date") @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate date)
	{	
		
		Doctor doctor=docRepo.findById(drId).get();
		
		return timeFrameDao.findAllByDrIdAndDate(doctor,date);
		 
		
	}
	
	
	@GetMapping("/getDetails")
	public Patient getPatient(@RequestParam Integer id) {
		return service.getPatient(id);
	}
	
	
	
	
	
}
