package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="User")
public class UserModel {
	//Attributes
@Id//primary key
 private String id;
 private String username;
 private String password;
 //default Constructor
 public UserModel() {
	
		// TODO Auto-generated constructor stub
	}
 //Getters and setters
public String getId() {
	return id;
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
 
}
