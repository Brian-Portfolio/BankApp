package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;


public interface CustomerService {

	public long createCustomer(Customer customer) throws BusinessException;
	public int setDelete(int account_id) throws BusinessException; 
	public int getCustomerID() throws BusinessException;
	
}
