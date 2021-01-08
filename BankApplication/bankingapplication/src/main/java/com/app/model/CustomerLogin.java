package com.app.model;

public class CustomerLogin {

	private int accountid;
	private String username;
	private String password;
	
	public CustomerLogin() {
		
	}

	public CustomerLogin(int accountid, String username, String password) {
		super();
		this.accountid = accountid;
		this.username = username;
		this.password = password;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
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
		return "CustomerLogin [accountid=" + accountid + ", username=" + username + ", password=" + password + "]";
	}
	
}
