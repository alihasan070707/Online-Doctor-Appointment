package com.app.pojos;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Patient extends Person {
	private List<Prescription> list;

	public Patient() {
		super();
	}

	public Patient(Integer id, char[] password, String name, Date dob, String email, String phoneNo, String gender,
			byte[] photo) {
		super(id, password, name, dob, email, phoneNo, gender, photo);
	}

	public List<Prescription> getList() {
		return list;
	}

	public void setList(List<Prescription> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Patient [list=" + list + ", getId()=" + getId() + ", getPassword()=" + Arrays.toString(getPassword())
				+ ", getName()=" + getName() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getPhoneNo()=" + getPhoneNo() + ", getGender()=" + getGender() + ", getPhoto()="
				+ Arrays.toString(getPhoto()) + "]";
	}


}
