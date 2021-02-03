package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	public String processSignUp(@RequestParam("data") String doctorJson, @RequestParam("file") MultipartFile photo) {
		Doctor doctor = null;

		try {
			doctor = new ObjectMapper().readValue(doctorJson, Doctor.class);

		} catch (JsonMappingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		System.out.println(doctor);
		// service.registerDoc(doctor.getDoctor());
		return "\"Success\"";
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
	
}
