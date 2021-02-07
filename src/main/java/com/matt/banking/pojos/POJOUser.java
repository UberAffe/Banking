package com.matt.banking.pojos;

public class POJOUser {
	protected int userID;
	protected String username;
	protected String password;
	public final int getUserID() {
		return userID;
	}
	public final void setUserID(int userID) {
		this.userID = userID;
	}
	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
}
