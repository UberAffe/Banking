package com.matt.banking.pojos;

public class POJOEmployee extends POJOUser{

	public POJOEmployee() {
		super();
		this.userID = 0;
		this.username = "";
		this.password = "";
	}
	public POJOEmployee(int userID, String username, String password) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
	}
	
}
