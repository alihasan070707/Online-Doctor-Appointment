package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.AdminRepository;
import com.app.dao.DoctorRepository;
import com.app.pojos.Admin;
import com.app.pojos.Doctor;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DoctorRepository docRepo;
	@Autowired
	private AdminRepository adminRepo;
	
	@GetMapping("/doctorList")
	public ResponseEntity<?> getDoctorList() {
		List<Doctor> doctors = docRepo.findAllByIsVerified(false);
		return new ResponseEntity<>(doctors,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@RequestParam String email, @RequestParam String password)
	{
		Admin admin = adminRepo.findByEmailAndPassword(email, password.toCharArray()).get();
		return new ResponseEntity<>(admin.getId(),HttpStatus.OK);
	}
	
	@GetMapping("/acceptDoctor")
	public ResponseEntity<?> acceptDoctor(@RequestParam Integer doctorId) {
		Doctor doctor = docRepo.findById(doctorId).get();
		doctor.setIsVerified(true);
		docRepo.save(doctor);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/rejectDoctor")
	public ResponseEntity<?> rejectDoctor(@RequestParam Integer doctorId) {
		docRepo.deleteById(doctorId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
