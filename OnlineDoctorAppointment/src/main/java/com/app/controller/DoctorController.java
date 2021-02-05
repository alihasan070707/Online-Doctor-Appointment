package com.app.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.DoctorCard;
import com.app.dto.DoctorSearchParam;
import com.app.dto.DoctorTimeSlots;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.service.IAppointmentService;
import com.app.service.IDoctorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorService service;
	@Autowired
	private IAppointmentService appService;

	public DoctorController() {
		System.out.println("in doctor");
	}

	@PostMapping("/upload")
	public String uploadPrescription(@RequestParam("pdfFile") MultipartFile pdfFile, @RequestParam Integer patientId) {
		System.out.println("in upload prescription");
		service.uploadPrescription(pdfFile, patientId);
		return "Success";
	}

	@GetMapping("/register")
	public String showSignUp() {
		return "/register";
	}

	@PostMapping("/register")
	public String processSignUp(@RequestParam("data") String doctorJson, @RequestParam("file") MultipartFile photo) {
		Doctor doctor = null;

		try {
			doctor = new ObjectMapper().readValue(doctorJson, Doctor.class);

		} catch (JsonMappingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		doctor.setPicture(photo.getOriginalFilename());
		if (service.registerDoc(doctor)) {
			service.addProfileImage(photo, doctor.getId());
			return "/somePage"; // need to be created
		}
		
		System.out.println(doctor.getAddress());
		
		return "\"Success\"";
	}

	@GetMapping("/login")
	public String showSignIn() {
		return "/login";
	}

	@PostMapping("/login")
	public ResponseEntity<?> processSignIn(@RequestParam String email, @RequestParam String password) {
		
		Doctor authUser = service.authenticateLogin(email, password.toCharArray());
		if (authUser != null) {
			return new ResponseEntity<>(authUser.getId(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public String updateAppointment(@RequestParam Integer appointmentId, @RequestParam int status) {

		appService.updateAppointmentStatus(appointmentId, status);

		return "Success";
	}

	@PostMapping("/timeFrames")
	public String setTimeFrames(@RequestParam Integer doctor_id,@RequestParam List<String> times) {
		System.out.println(doctor_id);
		System.out.println(times);
		
		
		 service.setTimeFrames(times, doctor_id); 

		return "/someting";

	}
	@GetMapping("/searchCity")
	public List<String> findCityByState(@RequestParam String state){
		System.out.println(state);
		System.out.println(service.findCityByState(state));
		return service.findCityByState(state);
	}
	
	@GetMapping("/searchState")
	public List<String> findAllState(){
		
		return service.findAllState();
	}
	
	@GetMapping("/searchSpec")
	public List<String> findBySpecialization(@RequestParam String state,@RequestParam String city){
		System.out.println(state);
		System.out.println(city);
		System.out.println(service.findBySpecialization(state, city));
		return service.findBySpecialization(state, city);
	}
	
	@GetMapping("/appointments")
	public List<Appointment> getAllAppointment(@RequestParam Doctor doctorId) {
		return appService.findAllByDoctorId(doctorId);
	}
	
	@PostMapping("/searchDoctor")
	public List<DoctorCard> searchDoctorByAll(@RequestParam("data") String search){
		System.out.println(search);
		DoctorSearchParam doctorcards = null;
		try {
			doctorcards = new ObjectMapper().readValue(search, DoctorSearchParam.class);

		} catch (JsonMappingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		List<DoctorCard> doctorcard=new ArrayList<DoctorCard>();
		if(doctorcards.getSpecialization()==null) {
			doctorcard=service.searchDoctorByStateAndCity(doctorcards.getState(), doctorcards.getCity());
			return doctorcard;
		}
		doctorcard=service.searchDoctorByAll(doctorcards.getState(), doctorcards.getCity(), doctorcards.getSpecialization());
		return doctorcard;
	}
	
	@GetMapping("/getDetails")
	public ResponseEntity<?> getPatient(@RequestParam Integer id) {
		System.out.println(id);
		Doctor doctor = service.getDoctor(id);
		return new ResponseEntity<>(doctor,HttpStatus.OK);
	}
	
	@GetMapping("/cancelAppointment")
	public ResponseEntity<?> cancelAppointment(@RequestParam Integer appId) {
		appService.updateAppointmentStatus(appId, 4);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
