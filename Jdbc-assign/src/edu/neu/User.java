package edu.neu;

import java.sql.Date;

public class User {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	
	public User(){
	super();
	}
	
	public User(String username, String password, String firstName, String lastName, String email, Date dob){
	
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
}
