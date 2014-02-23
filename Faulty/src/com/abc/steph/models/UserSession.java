package com.abc.steph.models;

public class UserSession {

	private String username;
	private String password;
	
	public UserSession() {
		super();
	}

	public UserSession(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
