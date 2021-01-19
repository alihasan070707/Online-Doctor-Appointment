package com.app.dto;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Doctor;

public class DoctorDto {
	private Doctor doctor;
	private MultipartFile photo;
	public DoctorDto() {
		super();
	}
	public DoctorDto(Doctor doctor, MultipartFile photo) {
		super();
		this.doctor = doctor;
		this.photo = photo;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
}
