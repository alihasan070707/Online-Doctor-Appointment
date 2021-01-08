package com.app.pojos;

import java.sql.Date;

public class Person {
	private Integer Id;
	private char[] password;
	private String name;
	private Date dob;
	private String email;
	private String phoneNo;
	private String Gender;
	private byte[] photo;

	public Person() {
		super();
	}

	public Person(Integer id, char[] password, String name, Date dob, String email, String phoneNo, String gender,
			byte[] photo) {
		super();
		Id = id;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		Gender = gender;
		this.photo = photo;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
