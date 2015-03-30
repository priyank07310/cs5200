package edu.neu;

import java.sql.Date;

public class Actor {

	private int actId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	public Actor() {
	super();
	}
	
	public Actor(String firstName, String lastName, Date dateOfBirth){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public int getActId() {
		return actId;
	}
		
	public void setActId(int actId){
		this.actId = actId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}

