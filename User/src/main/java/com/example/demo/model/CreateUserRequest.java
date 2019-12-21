package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


import com.sun.istack.NotNull;

public class CreateUserRequest {

	@NotNull()
	@Size(min=2,message="It should be more than 2 letter")
	private String firstName;
	@NotNull()
	@Size(min=2,message="It should be more than 2 letter")
	private String lastName;
	@NotNull()
	@Size(min=2,max=16,message="enter the correct password")
	private String password;
	@NotNull
	@Email
    String email;
	
	public CreateUserRequest()
	{
		
	}

	public CreateUserRequest(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
