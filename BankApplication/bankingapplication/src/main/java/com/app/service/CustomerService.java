package com.app.service;

import com.app.model.Customer;
import com.app.model.CustomerLogin;

public interface CustomerService {

	public int createCustomerBankAccount(Customer customer);
	public int createCustomerLogin(CustomerLogin customerlogin);
	
}
