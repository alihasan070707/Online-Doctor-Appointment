package com.app.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DoctorTimeSlots {
	Integer doctor_id;
	List<LocalTime> times = new ArrayList<>();
	public DoctorTimeSlots() {}
	public DoctorTimeSlots(Integer doctorId) {
		this.doctor_id = doctorId;
	}
	public DoctorTimeSlots(Integer doctorId, List<LocalTime> times) {
		super();
		this.doctor_id = doctorId;
		this.times = times;
	}

	/*
	 * public Integer getDoctorId() { return doctor_id; } public void
	 * setDoctor_id(Integer doctorId) { this.doctor_id = doctorId; }
	 */
	
	public List<LocalTime> getTimes() {
		return times;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public void setTimes(List<LocalTime> times) {
		this.times = times;
	}
	
	
}
