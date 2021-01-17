package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patientId;
	
	@Lob
	@Column
	private byte[] prescriptionPdf;

	public Prescription() {
		super();
	}

	public Prescription(Patient patientId, byte[] prescriptionPdf) {
		super();
		this.patientId = patientId;
		this.prescriptionPdf = prescriptionPdf;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public byte[] getPrescriptionPdf() {
		return prescriptionPdf;
	}

	public void setPrescriptionPdf(byte[] prescriptionPdf) {
		this.prescriptionPdf = prescriptionPdf;
	}

	

}
