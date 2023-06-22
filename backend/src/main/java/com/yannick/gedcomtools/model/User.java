package com.yannick.gedcomtools.model;

import java.util.Date;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String email;
	private Date registrationDate;

	public User(int id, String firstName, String lastName, String login, String email, Date registrationDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.email = email;
		this.registrationDate = registrationDate;
	}

	public User(String firstName, String lastName, String login, String email, Date registrationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.email = email;
		this.registrationDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

}
