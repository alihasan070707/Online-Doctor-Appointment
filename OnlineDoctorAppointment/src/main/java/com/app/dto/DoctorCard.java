package com.app.dto;

public class DoctorCard {
	
	private Integer id;
	private String name;
	private String specialization;
	private Integer fees;
	public DoctorCard() {
		super();
	}
	public DoctorCard(Integer id, String name, String specialization, Integer fees) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.fees = fees;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Integer getFees() {
		return fees;
	}
	public void setFees(Integer fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "DoctorCard [id=" + id + ", name=" + name + ", specialization=" + specialization + ", fees=" + fees
				+ "]";
	}
	 

}
