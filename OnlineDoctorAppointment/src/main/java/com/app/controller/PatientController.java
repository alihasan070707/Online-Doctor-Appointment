package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Appointment;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;
import com.app.service.IAppointmentService;
import com.app.service.IPatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private IPatientService service;
	@Autowired
	private IAppointmentService appService;
	
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
	public String registerPatient(@Validated Patient patient) {
		if(service.addPatient(patient)) {
			return "/somePage"; //need to be created
		}
		return "/register";
	}
	
	@GetMapping("/prescriptions")
	public String getPrescriptions(@RequestParam Integer patientId, Model map) {
		List<Prescription> list = service.getPrescription(patientId);
		map.addAttribute("prescriptionList", list);
		if(list == null) {
			return "/";
		}
		return "/somePage"; //need to be created
	}
	
	@PostMapping("/appointment")
	public String addAppointment (@Validated Appointment appointment ) {
		boolean getApp = appService.addAppointment(appointment.getDrId(), appointment.getPatientId(), appointment.getId(), 5);
		return "/somePage";
	}
}
