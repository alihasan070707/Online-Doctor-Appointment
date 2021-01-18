package com.app.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.DoctorTimeSlots;
import com.app.pojos.Doctor;
import com.app.pojos.TimeFrame;
import com.app.service.IDoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorService service;

	public DoctorController() {
		System.out.println("in doc ctor");
	}

	@PostMapping("/upload")
	public String uploadPrescription(@RequestParam("pdfFile") MultipartFile pdfFile, @RequestParam Integer patient_id) {
		System.out.println("in upload prescription");
		service.uploadPrescription(pdfFile, patient_id);

		return "Success";
	}

	@GetMapping("/register")
	public String showSignUp() {
		return "/register";
	}

	@PostMapping("/register")
	public String processSignUp(@RequestBody Doctor doctor) {
		System.out.println(doctor);

		service.registerDoc(doctor);
		return "Success";
	}

	@GetMapping("/login")
	public String showSignIn() {
		return "/login";
	}

	@PostMapping("/login")
	public String processSignIn(@RequestBody String email, @RequestBody String password) {

		Doctor authUser = service.authenticateLogin(email, password.toCharArray());
		if (authUser != null) {
			return "success";
		}
		return "Invalid";
	}

	public String updateAppointment(@RequestParam Integer appointmentId, @RequestParam int status) {

		service.updateAppointmentStatus(appointmentId, status);

		return "Success";
	}

	@PostMapping("/timeFrames")
	public String setTimeFrames(@RequestBody DoctorTimeSlots doctor) {
		System.out.println(doctor.getDoctor_id());
		System.out.println(doctor.getTimes());
		
		  service.setTimeFrames(doctor.getTimes(), doctor.getDoctor_id());
		 
		return "/someting";

	}

}
