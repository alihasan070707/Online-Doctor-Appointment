package com.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnTransformer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@MappedSuperclass
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(length = 20)
	@NonNull
	
	private char[] password;
	@Column(length = 20)
	@NonNull
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NonNull
	private Date dob;
	@Column(length = 30, unique = true)
	@NonNull
	private String email;
	@Column(length = 10)
	@NonNull
	private String phoneNo;
	@Column(length = 15)
	@NonNull
	private String gender;
	
	private String picture;

	public Person() {
		super();
	}

	public Person(Integer id, char[] password, String name, Date dob, String email, String phoneNo, String gender,
			String photo) {
		super();
		Id = id;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.picture = photo;
	}

	public Person(char[] password, String name, Date dob, String email, String phoneNo, String gender) {
		super();
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
	}

	public Person(char[] password, String name, Date dob, String email, String phoneNo, String gender, String photo) {
		super();
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.picture = photo;
	}

	public Person(Integer id) {
		super();
		Id = id;
	}
	
	public Person(Integer id, String name) {
		super();
		Id = id;
		this.name = name;
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
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String photo) {
		this.picture = photo;
	}

}
