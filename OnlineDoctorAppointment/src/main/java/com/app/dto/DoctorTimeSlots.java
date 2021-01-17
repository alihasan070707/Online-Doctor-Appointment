package com.app.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DoctorTimeSlots {
	Integer doctorId;
	List<LocalTime> times = new ArrayList<>();
	public DoctorTimeSlots() {}
	public DoctorTimeSlots(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public DoctorTimeSlots(Integer doctorId, List<LocalTime> times) {
		super();
		this.doctorId = doctorId;
		this.times = times;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public List<LocalTime> getTimes() {
		return times;
	}
	public void setTimes(List<LocalTime> times) {
		this.times = times;
	}
	
	
}
