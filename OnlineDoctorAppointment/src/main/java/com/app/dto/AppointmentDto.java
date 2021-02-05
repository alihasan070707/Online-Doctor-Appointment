package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {
	
	private Integer id;
	private Integer patientId;
	private Integer doctorId;
	private String patientName;
	private String doctorName;
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDate date;
	private String location;
	private String city;
	private Integer fees;
	
	
	
	public AppointmentDto() {
		super();
	}

	
	
	public AppointmentDto(Integer id, Integer patientId, Integer doctorId, String patientName, String doctorName,
			LocalTime startTime, LocalTime endTime, LocalDate date) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
	}



	public AppointmentDto(Integer id, Integer patientId, Integer doctorId, String patientName, String doctorName,
			LocalTime startTime, LocalTime endTime, LocalDate date, String location, String city, Integer fees) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.location = location;
		this.city = city;
		this.fees = fees;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPatientId() {
		return patientId;
	}


	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}


	public Integer getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	
	public LocalTime getStartTime() {
		return startTime;
	}



	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}



	public LocalTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}

	

	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public Integer getFees() {
		return fees;
	}



	public void setFees(Integer fees) {
		this.fees = fees;
	}



	@Override
	public String toString() {
		return "AppointmentDto [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", patientName="
				+ patientName + ", doctorName=" + doctorName + "]";
	}
	
	
	
}
