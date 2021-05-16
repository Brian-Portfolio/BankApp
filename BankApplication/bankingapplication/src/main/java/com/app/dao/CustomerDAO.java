package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {
	
	public long createCustomer(Customer customer) throws BusinessException; 
	public int setDelete(int account_id) throws BusinessException; 
	public int getCustomerID() throws BusinessException;
	public List<Customer> getCustomerById(int id);
	public List<Customer> getAllCustomers();
	
}
