package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;


public interface CustomerService {

	//åpublic int createCustomer(int id, String firstname, String middlename, String lastname, String city, String state, String gender, String customeraddress, String dateofbirth) throws BusinessException;
	public Customer getCustomerID(int id) throws BusinessException;
	public Customer getCustomerFirstName(String firstname, int id) throws BusinessException;
	public Customer getCustomerMiddleName(String middlename, int id) throws BusinessException;
	public Customer getCustomerLastName(String lastname, int id) throws BusinessException;
	public Customer getCustomerEmailAddress(String emailaddress, int id) throws BusinessException;
	public Customer getCustomerDOB(String dateofbirth, int id) throws BusinessException;	
	public Customer getCustomerCity(String city, int id) throws BusinessException;
	public Customer getCustomerState(String state, int id) throws BusinessException;
	public Customer getCustomerGender(String gender, int id) throws BusinessException;
	public Customer getCustomerAddress(String customeraddress, int id) throws BusinessException;
	//public int createCustomerLogin(CustomerLogin customerlogin);
	//public int chooseAccountType();
	
	
}
