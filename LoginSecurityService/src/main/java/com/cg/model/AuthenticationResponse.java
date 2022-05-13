package com.cg.model;

public class AuthenticationResponse {
	//attribute
	private String response;
	//Parameterized Constructors
public AuthenticationResponse(String response) {
		this.response = response;
	}
	//default constructor
	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
//setter and getter
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	

}
