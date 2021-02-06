package com.app.pojos;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30, unique = true)
	@NonNull
	private String email;
	@Column(length=20)
	private char[] password;

	public Admin() {
		super();
	}

	public Admin(Integer id, String email, char[] password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public Admin(String email, char[] password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Admin(Integer id, char[] password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + Arrays.toString(password) + "]";
	}

}
