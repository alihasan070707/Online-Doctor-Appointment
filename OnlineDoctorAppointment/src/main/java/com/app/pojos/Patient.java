package com.app.pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Patient extends Person {
	/*
	 * @OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL) private
	 * List<Prescription> list = new ArrayList<Prescription>();
	 */
	@JsonManagedReference(value="patient")
	@OneToMany(mappedBy="patientId",cascade = CascadeType.PERSIST)
	private List<Appointment> appointment = new ArrayList<Appointment>();

	public Patient() {
		super();
	}

	public Patient(Integer id, char[] password, String name, Date dob, String email, String phoneNo, String gender,
			String photo) {
		super(id, password, name, dob, email, phoneNo, gender, photo);
	}

	public Patient(char[] password, String name, Date dob, String email, String phoneNo, String gender) {
		super(password, name, dob, email, phoneNo, gender);
	}
	
	public Patient(Integer id) {
		super(id);
	}

	/*
	 * public List<Prescription> getList() { return list; }
	 * 
	 * public void setList(List<Prescription> list) { this.list = list; }
	 */
	
	/*
	 * public void addPrescription(Prescription prescription) {
	 * list.add(prescription); }
	 */
	
	public void addAppointment(Appointment app) {
		appointment.add(app);
		app.setPatientId(this); 	
	}
	
	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Patient [ getId()=" + getId() + ", getPassword()=" + Arrays.toString(getPassword())
				+ ", getName()=" + getName() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getPhoneNo()=" + getPhoneNo() + ", getGender()=" + getGender() + "]";
	}


}
