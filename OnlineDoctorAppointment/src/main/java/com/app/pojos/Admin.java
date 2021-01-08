package com.app.pojos;

import javax.persistence.Entity;

@Entity
public class Admin {
	private Integer id;
	private char[] password;

	public Admin() {
		super();
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

}
