package com.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(length = 20)
	private char[] password;
	@Column(length = 20)
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	@Column(length = 30)
	private String email;
	@Column(length = 10)
	private String phoneNo;
	@Column(length = 15)
	private String gender;
	@Lob
	@Column(columnDefinition = "mediumblob")
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
		this.gender = gender;
		this.photo = photo;
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

	public Person(char[] password, String name, Date dob, String email, String phoneNo, String gender, byte[] photo) {
		super();
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.photo = photo;
	}

	public Person(Integer id) {
		super();
		Id = id;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
