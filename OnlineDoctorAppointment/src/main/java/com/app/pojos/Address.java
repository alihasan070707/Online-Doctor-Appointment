package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctorId;
	@Column(length = 15)
	private String state;
	@Column(length = 20)
	private String city;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Doctor getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}
	@Column(length = 6)
	private String pincode;
	@Column(length = 65535, columnDefinition = "TEXT")
	private String location;
	public Address() {
		super();
	}
	public Address(String state, String city, String pincode, String location) {
		super();
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.location = location;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String address) {
		this.location = address;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pincode=" + pincode + ", address=" + location + "]";
	}
	
}
