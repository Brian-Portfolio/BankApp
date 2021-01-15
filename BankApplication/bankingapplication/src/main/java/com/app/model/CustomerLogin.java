package com.app.model;

public class CustomerLogin {

	private int loginid;
	private int account_id;
	private String username;
	private String password;
	
	public CustomerLogin() {
		
	}

	public CustomerLogin(int loginid, int account_id, String username, String password) {
		super();
		this.loginid = loginid;
		this.account_id = account_id;
		this.username = username;
		this.password = password;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
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
		return "CustomerLogin [loginid=" + loginid + ", account_id=" + account_id + ", username=" + username
				+ ", password=" + password + "]";
	}
	
}
