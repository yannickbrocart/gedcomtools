package com.yannick.gedcomtools.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gedcoms_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gedcoms_users_id", nullable = false)
	private long userId;
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "registration_date", nullable = false)
	private Date registrationDate;

	public User() {
	}

	public User(long userId, String firstName, String lastName, String login, String email, Date registrationDate) {
		this.userId = userId;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
