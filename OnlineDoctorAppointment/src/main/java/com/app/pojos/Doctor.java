package com.app.pojos;

import java.sql.Date;
import java.util.Arrays;

public class Doctor extends Person {
	private String registrationNo;
	private Date registrationDate;
	private String stateMedicalCouncil;
	private String Qualification;
	private Address address;

	public Doctor() {
		super();
	}

	public Doctor(Integer id, char[] password, String name, Date dob, String email, String phoneNo, String gender,
			byte[] photo, String registrationNo, Date registrationDate, String stateMedicalCouncil,
			String qualification, Address address) {
		super(id, password, name, dob, email, phoneNo, gender, photo);
		this.registrationNo = registrationNo;
		this.registrationDate = registrationDate;
		this.stateMedicalCouncil = stateMedicalCouncil;
		Qualification = qualification;
		this.address = address;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStateMedicalCouncil() {
		return stateMedicalCouncil;
	}

	public void setStateMedicalCouncil(String stateMedicalCouncil) {
		this.stateMedicalCouncil = stateMedicalCouncil;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Doctor [registrationNo=" + registrationNo + ", registrationDate=" + registrationDate
				+ ", stateMedicalCouncil=" + stateMedicalCouncil + ", Qualification=" + Qualification + ", address="
				+ address + ", getId()=" + getId() + ", getPassword()=" + Arrays.toString(getPassword())
				+ ", getName()=" + getName() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getPhoneNo()=" + getPhoneNo() + ", getGender()=" + getGender() + ", getPhoto()="
				+ Arrays.toString(getPhoto()) + "]";
	}

	
}
