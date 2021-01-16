package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Integer doctorId;
	@Column(length = 15)
	private String state;
	@Column(length = 20)
	private String city;
	@Column(length = 6)
	private String pincode;
	@Column(length = 30)
	private String landmark;
	@Column(length = 65535, columnDefinition = "TEXT")
	private String address;
	public Address() {
		super();
	}
	public Address(String state, String city, String pincode, String landmark, String address) {
		super();
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.landmark = landmark;
		this.address = address;
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
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pincode=" + pincode + ", landmark=" + landmark
				+ ", address=" + address + "]";
	}
	
}
