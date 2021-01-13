package com.app.services.impl;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Override
	public Customer getCustomerFirstName(String firstname) throws BusinessException {
		Customer customer1 = null;
		if (firstname!=null && firstname.matches("[a-zA-Z]{1,10}")) {
			 customer1 = customerDAO.getCustomerFirstName(firstname);
		}else {
			throw new BusinessException("Entered First Name is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerMiddleName(String middlename) throws BusinessException {
		Customer customer1 = null;
		if (middlename.matches("[a-zA-Z]{1,10}")) {
			 customer1 = customerDAO.getCustomerMiddleName(middlename);
		}else {
			throw new BusinessException("Entered Middle Name is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerLastName(String lastname) throws BusinessException {
		Customer customer1 = null;
		if (lastname.matches("[a-zA-Z]{1,10}")) {
			 customer1 = customerDAO.getCustomerLastName(lastname);
		}else {
			throw new BusinessException("Entered Last Name is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerEmailAddress(String emailaddress) throws BusinessException {
		Customer customer1 = null;
		if (emailaddress != null && emailaddress.matches("^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			 customer1 = customerDAO.getCustomerEmailAddress(emailaddress);
		}else {
			throw new BusinessException("Entered Email Address is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerDOB(String dateofbirth) throws BusinessException {
		Customer customer1 = null;
		if (dateofbirth != null && dateofbirth.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
			 customer1 = customerDAO.getCustomerDOB(dateofbirth);
		}else {
			throw new BusinessException("Entered Date of Birth is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerCity(String city) throws BusinessException {
		Customer customer1 = null;
		if (city != null && city.matches("[a-zA-Z]{1,10}")) {
			 customer1 = customerDAO.getCustomerCity(city);
		}else {
			throw new BusinessException("Entered City is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerState(String state) throws BusinessException {
		Customer customer1 = null;
		if (state != null && state.matches("[A-Z]{2}")) {
			 customer1 = customerDAO.getCustomerState(state);
		}else {
			throw new BusinessException("Entered State Initials is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerGender(String gender) throws BusinessException {
		Customer customer1 = null;
		if (gender != null && gender.matches("[a-zA-Z]{1}")) {
			 customer1 = customerDAO.getCustomerGender(gender);
		}else {
			throw new BusinessException("Entered Gender is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerAddress(String customeraddress) throws BusinessException {
		Customer customer1 = null;
		if (customeraddress != null && customeraddress.matches("[0-9]{1,3} [a-zA-Z]{1,10} [a-zA-Z]{1,10}")) {
			 customer1 = customerDAO.getCustomerAddress(customeraddress);
		}else {
			throw new BusinessException("Entered Customer Address is INVALID!!");
		}
		return customer1;
	}


//	@Override
//	public int createCustomer(String firstname, String middlename, String lastname, String city, String state, String gender, String customeraddress, String dateofbirth) throws BusinessException {
//		int z =0;
//		
//		if (firstname!=null && firstname.matches("[a-zA-Z]{1,10}")) {
//			 customerDAO.getCustomerFirstName(firstname);
//		}else {
//			throw new BusinessException("Entered First Name is INVALID!!");
//		}
//		
//		if (middlename.matches("[a-zA-Z]{1,10}")) {
//			 customerDAO.getCustomerMiddleName(middlename);
//		}else {
//			throw new BusinessException("Entered Middle Name is INVALID!!");
//		}
//		
//		if (lastname.matches("[a-zA-Z]{1,10}")) {
//			 customerDAO.getCustomerLastName(lastname);
//		}else {
//			throw new BusinessException("Entered Last Name is INVALID!!");
//		}
//		
//		
//		if (dateofbirth != null && dateofbirth.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
//			 customerDAO.getCustomerDOB(dateofbirth);
//		}else {
//			throw new BusinessException("Entered Date of Birth is INVALID!!");
//		}
//		
//		if (city != null && city.matches("[a-zA-Z]{1,10}")) {
//			 customerDAO.getCustomerCity(city);
//		}else {
//			throw new BusinessException("Entered City is INVALID!!");
//		}
//		
//		if (state != null && state.matches("[A-Z]{2}")) {
//			  customerDAO.getCustomerState(state);
//		}else {
//			throw new BusinessException("Entered State Initials is INVALID!!");
//		}
//		
//		if (gender != null && gender.matches("[a-zA-Z]{1}")) {
//			  customerDAO.getCustomerGender(gender);
//		}else {
//			throw new BusinessException("Entered Gender is INVALID!!");
//		}
//		
//		if (customeraddress != null && customeraddress.matches("[0-9]{1,3} [a-zA-Z]{1,10} [a-zA-Z]{1,10}")) {
//			  customerDAO.getCustomerAddress(customeraddress);
//		}else {
//			throw new BusinessException("Entered Customer Address is INVALID!!");
//		}
//		
//		return z;
//	}


	@Override
	public int createCustomer(String firstname, String middlename, String lastname,  String city,
			String state, String gender, String customeraddress, String dateofbirth) throws BusinessException {
	int z =0 ;
	if (firstname!=null && firstname.matches("[a-zA-Z]{1,10}")) {
		 customerDAO.getCustomerFirstName(firstname);
	}else {
		throw new BusinessException("Entered First Name is INVALID!!");
	}
	
	if (middlename.matches("[a-zA-Z]{1,10}")) {
		 customerDAO.getCustomerMiddleName(middlename);
	}else {
		throw new BusinessException("Entered Middle Name is INVALID!!");
	}
	
	if (lastname.matches("[a-zA-Z]{1,10}")) {
		 customerDAO.getCustomerLastName(lastname);
	}else {
		throw new BusinessException("Entered Last Name is INVALID!!");
	}
	
	
	if (dateofbirth != null && dateofbirth.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
		 customerDAO.getCustomerDOB(dateofbirth);
	}else {
		throw new BusinessException("Entered Date of Birth is INVALID!!");
	}
	
	if (city != null && city.matches("[a-zA-Z]{1,10}")) {
		 customerDAO.getCustomerCity(city);
	}else {
		throw new BusinessException("Entered City is INVALID!!");
	}
	
	if (state != null && state.matches("[A-Z]{2}")) {
		  customerDAO.getCustomerState(state);
	}else {
		throw new BusinessException("Entered State Initials is INVALID!!");
	}
	
	if (gender != null && gender.matches("[a-zA-Z]{1}")) {
		  customerDAO.getCustomerGender(gender);
	}else {
		throw new BusinessException("Entered Gender is INVALID!!");
	}
	
	if (customeraddress != null && customeraddress.matches("[0-9]{1,3} [a-zA-Z]{1,10} [a-zA-Z]{1,10}")) {
		  customerDAO.getCustomerAddress(customeraddress);
	}else {
		throw new BusinessException("Entered Customer Address is INVALID!!");
	}
	
	return z;
		
	}

//	@Override
//	public Customer getCustomerId(int id) throws BusinessException {
//		if (id !=0) {
//			 customerDAO.getCustomerId(id);
//		}else {
//			throw new BusinessException("Entered id is INVALID!!");
//		}
//		return null;
//	}
		

}
