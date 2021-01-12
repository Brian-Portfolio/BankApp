package com.app.dao;

import com.app.model.CustomerLogin;

public interface CustomerLoginDAO {
	
	public int createCustomerLogin(CustomerLogin customerlogin);
	public CustomerLogin CreateUsername(String username);
	public CustomerLogin CreatePassword(String password);
	public int accountReference(int accountid);	
}
