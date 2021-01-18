package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="doctor_id")
	private Doctor drId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="patient_id")
	private Patient patientId;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="timeframe_id")
	private TimeFrame id;
	private Integer status;
	
	public Appointment() {
		super();
	}
	public Appointment(Doctor drId, Patient patientId, TimeFrame id, Integer status) {
		super();
		this.drId = drId;
		this.patientId = patientId;
		this.id = id;
		this.status = status;
	}
	public Doctor getDrId() {
		return drId;
	}
	public void setDrId(Doctor drId) {
		this.drId = drId;
	}
	public Patient getPatientId() {
		return patientId;
	}
	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}
	public TimeFrame getId() {
		return id;
	}
	public void setId(TimeFrame id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Appointment [drId=" + drId + ", patientId=" + patientId + ", id=" + id + ", status=" + status + "]";
	}
	
	
	
	
	
}
