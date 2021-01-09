package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {

	public int createCustomer(Customer customer) throws BusinessException;
	public int deleteCustomer(int customerid);
	public Customer getCustomerById(int customerid);
	public List<Customer> getAllCustomers();
	
}
