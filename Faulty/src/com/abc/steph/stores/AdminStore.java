package com.abc.steph.stores;

public class AdminStore {
	private String ID;
	private String Name;
	private String Username;
	private String Password;
	private String Email;
	public AdminStore(){

	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public String getUsername() {
		return Username;
	}
	public String getPassword() {
		return Password;
	}
	public String getEmail() {
		return Email;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setEmail(String email) {
		Email = email;
	}

	
}
