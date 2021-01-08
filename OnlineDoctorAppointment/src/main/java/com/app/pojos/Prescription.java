package com.app.pojos;

public class Prescription {
	private Integer patientId;
	private byte[] prescriptionPdf;

	public Prescription() {
		super();
	}

	public Prescription(Integer patientId, byte[] prescriptionPdf) {
		super();
		this.patientId = patientId;
		this.prescriptionPdf = prescriptionPdf;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public byte[] getPrescriptionPdf() {
		return prescriptionPdf;
	}

	public void setPrescriptionPdf(byte[] prescriptionPdf) {
		this.prescriptionPdf = prescriptionPdf;
	}

}
