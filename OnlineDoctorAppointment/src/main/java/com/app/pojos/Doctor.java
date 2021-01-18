package com.app.pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Doctor extends Person {
	@Column(length = 20)
	private String registrationNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	@Column(length = 30)
	private String stateMedicalCouncil;
	@Column(length = 30)
	private String specialization;
	@Column(length = 30)
	private String qualification;
	@OneToOne(mappedBy = "doctorId" , cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy="drId", cascade = CascadeType.ALL)
	private List<TimeFrame> timeSlots = new ArrayList<TimeFrame>();
	
	private boolean isVerified;
	
	@OneToMany(mappedBy="drId")
	private List<Appointment> appointment;

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
		this.qualification = qualification;
		this.address = address;
	}
	
	public Doctor(char[] password, String name, Date dob, String email, String phoneNo, String gender,
			String registrationNo, Date registrationDate, String stateMedicalCouncil, String specialization,
			String qualification, boolean isVerified) {
		super(password, name, dob, email, phoneNo, gender);
		this.registrationNo = registrationNo;
		this.registrationDate = registrationDate;
		this.stateMedicalCouncil = stateMedicalCouncil;
		this.specialization = specialization;
		this.qualification = qualification;
		this.isVerified = isVerified;
	}

	public Doctor(Integer id) {
		super(id);
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
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	
	
	
	
	  public List<TimeFrame> getTimeSlots() { return timeSlots; }
	  
	  public void setTimeSlots(List<TimeFrame> timeSlots) { this.timeSlots =
	  timeSlots; }
	 
	 

	public boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	
	/*
	 * public List<Appointment> getAppointment() { return appointment; }
	 * 
	 * public void setAppointment(List<Appointment> appointment) { this.appointment
	 * = appointment; }
	 */

	
		
		  public void setTimeSlot( TimeFrame timeFrame) {
		  
		  timeSlots.add(timeFrame); timeFrame.setDrId(this);
		  
		  }
		 
	 
	
	@Override
	public String toString() {
		return "Doctor [registrationNo=" + registrationNo + ", registrationDate=" + registrationDate
				+ ", stateMedicalCouncil=" + stateMedicalCouncil + ", Qualification=" + qualification + ", address="
				+ address + ", getId()=" + getId() + ", getPassword()=" + Arrays.toString(getPassword())
				+ ", getName()=" + getName() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getPhoneNo()=" + getPhoneNo() + ", getGender()=" + getGender() + ", getPhoto()="
				+ Arrays.toString(getPhoto()) + "]";
	}

	
}
