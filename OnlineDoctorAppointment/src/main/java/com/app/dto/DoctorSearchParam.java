package com.app.dto;

public class DoctorSearchParam {
	private String state;
	private String city;
	private String specialization;
	public DoctorSearchParam() {
		super();
	}
	public DoctorSearchParam(String state, String city, String specialization) {
		super();
		this.state = state;
		this.city = city;
		this.specialization = specialization;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "DoctorSearchParam [state=" + state + ", city=" + city + ", specialization=" + specialization + "]";
	}
	
	
}
