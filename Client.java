package com.revature.models;

public class Client {
	private int id;
	private String firstName;
	private String lastName;
	private String birthdate;
	
	//No Arguments Constructor
	public Client() {
		super();
	}

	//All Arguments Constructor
	public Client(int id, String firstName, String lastName, String birthdate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}

	

	//ID-Less Constructor
	public Client(String firstName, String lastName, String birthdate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return " Client [id=" + id  + ", name=" + firstName + " " + lastName + "]";
	}

	

}
