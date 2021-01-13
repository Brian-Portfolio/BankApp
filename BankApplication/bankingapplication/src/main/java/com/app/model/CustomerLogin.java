package com.app.model;

public class CustomerLogin {

	private int nameid;
	private String username;
	private String password;
	
	public CustomerLogin() {
		
	}

	public CustomerLogin(int nameid, String username, String password) {
		super();
		this.nameid = nameid;
		this.username = username;
		this.password = password;
	}

	public int getNameid() {
		return nameid;
	}

	public void setNameid(int nameid) {
		this.nameid = nameid;
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

	@Override
	public String toString() {
		return "CustomerLogin [nameid=" + nameid + ", username=" + username + ", password=" + password + "]";
	}
	
}
