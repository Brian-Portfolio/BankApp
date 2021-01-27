package com.app.services.impl;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Override
	public Customer getCustomerFirstName(String firstname, int id) throws BusinessException {
		Customer customer1 = null;
		if (firstname!=null && firstname.matches("[a-zA-Z]{1,10}")&& id!=0) {
			 customer1 = customerDAO.getCustomerFirstName(firstname, id);
		}else {
			throw new BusinessException("Entered First Name is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerMiddleName(String middlename, int id) throws BusinessException {
		Customer customer1 = null;
		if (middlename.matches("[a-zA-Z]{1,10}")&& id!=0) {
			 customer1 = customerDAO.getCustomerMiddleName(middlename, id);
		}
		return customer1;
	}


	@Override
	public Customer getCustomerLastName(String lastname, int id) throws BusinessException {
		Customer customer1 = null;
		if (lastname.matches("[a-zA-Z]{1,10}")&& id!=0) {
			 customer1 = customerDAO.getCustomerLastName(lastname, id);
		}else {
			throw new BusinessException("Entered Last Name is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerEmailAddress(String emailaddress, int id) throws BusinessException {
		Customer customer1 = null;
		if (emailaddress != null && emailaddress.matches("^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^.-]+@[a-zA-Z0-9.-]+$")&& id !=0) {
			 customer1 = customerDAO.getCustomerEmailAddress(emailaddress, id);
		}else {
			throw new BusinessException("Entered Email Address is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerDOB(String dateofbirth, int id) throws BusinessException {
		Customer customer1 = null;
		if (dateofbirth != null && dateofbirth.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")&& id !=0) {
			 customer1 = customerDAO.getCustomerDOB(dateofbirth, id);
		}else {
			throw new BusinessException("Entered Date of Birth is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerCity(String city, int id) throws BusinessException {
		Customer customer1 = null;
		if (city != null && city.matches("[a-zA-Z]{1,10}")&& id !=0) {
			 customer1 = customerDAO.getCustomerCity(city, id);
		}else {
			throw new BusinessException("Entered City is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerState(String state, int id) throws BusinessException {
		Customer customer1 = null;
		if (state != null && state.matches("[A-Z]{2}")&& id !=0) {
			 customer1 = customerDAO.getCustomerState(state, id);
		}else {
			throw new BusinessException("Entered State Initials is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerGender(String gender, int id) throws BusinessException {
		Customer customer1 = null;
		if (gender != null && gender.matches("[a-zA-Z]{1}")&& id!=0) {
			 customer1 = customerDAO.getCustomerGender(gender,id );
		}else {
			throw new BusinessException("Entered Gender is INVALID!!");
		}
		return customer1;
	}


	@Override
	public Customer getCustomerAddress(String customeraddress, int id) throws BusinessException {
		Customer customer1 = null;
		if (customeraddress != null && customeraddress.matches("[0-9]{1,5} [a-zA-Z]{1,10} [a-zA-Z]{1,10}")&& id!=0) {
			 customer1 = customerDAO.getCustomerAddress(customeraddress, id);
		}else {
			throw new BusinessException("Entered Customer Address is INVALID!!");
		}
		return customer1;
	}





//	@Override
//	public int createCustomer(int id, String firstname, String middlename, String lastname,  String city,
//			String state, String gender, String customeraddress, String dateofbirth) throws BusinessException {
//	int z =0 ;
//	if (firstname!=null && firstname.matches("[a-zA-Z]{1,10}") ) {
//		 customerDAO.getCustomerFirstName(firstname, id);
//	}else {
//		throw new BusinessException("Entered First Name is INVALID!!");
//	}
//	
//	if (middlename.matches("[a-zA-Z]{1,10}")) {
//		 customerDAO.getCustomerMiddleName(middlename);
//	}else {
//		throw new BusinessException("Entered Middle Name is INVALID!!");
//	}
//	
//	if (lastname.matches("[a-zA-Z]{1,10}")) {
//		 customerDAO.getCustomerLastName(lastname);
//	}else {
//		throw new BusinessException("Entered Last Name is INVALID!!");
//	}
//	
//	
//	if (dateofbirth != null && dateofbirth.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
//		 customerDAO.getCustomerDOB(dateofbirth);
//	}else {
//		throw new BusinessException("Entered Date of Birth is INVALID!!");
//	}
//	
//	if (city != null && city.matches("[a-zA-Z]{1,10}")) {
//		 customerDAO.getCustomerCity(city);
//	}else {
//		throw new BusinessException("Entered City is INVALID!!");
//	}
//	
//	if (state != null && state.matches("[A-Z]{2}")) {
//		  customerDAO.getCustomerState(state);
//	}else {
//		throw new BusinessException("Entered State Initials is INVALID!!");
//	}
//	
//	if (gender != null && gender.matches("[a-zA-Z]{1}")) {
//		  customerDAO.getCustomerGender(gender);
//	}else {
//		throw new BusinessException("Entered Gender is INVALID!!");
//	}
//	
//	if (customeraddress != null && customeraddress.matches("[0-9]{1,3} [a-zA-Z]{1,10} [a-zA-Z]{1,10}")) {
//		  customerDAO.getCustomerAddress(customeraddress);
//	}else {
//		throw new BusinessException("Entered Customer Address is INVALID!!");
//	}
//	
//	return z;
//		
//	}


	@Override
	public Customer getCustomerID(int id) throws BusinessException {
		if (id >=0) {
			 customerDAO.getCustomerID(id);
		}else {
			throw new BusinessException("Entered id is INVALID!!");
		}
		return null;
	}


	@Override
	public long createCustomer(Customer customer) throws BusinessException {
		long z =0;
		
		if (customer.getFirstname()!=null && customer.getFirstname().matches("[a-zA-Z]{1,10}") ) {
			if (customer.getMiddlename().matches("[a-zA-Z]{1,10}")) {
				if (customer.getLastname()!=null && customer.getLastname().matches("[a-zA-Z]{1,10}")) {
					if (customer.getDateofbirth()!= null && customer.getDateofbirth().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
						if (customer.getCity()!= null && customer.getCity().matches("[a-zA-Z]{1,10}")) {
							if (customer.getState()!= null && customer.getState().matches("[A-Z]{2}")) {
								if (customer.getGender()!= null && customer.getGender().matches("[a-zA-Z]{1}")) {
									if (customer.getCustomeraddress()!= null && customer.getCustomeraddress().matches("[0-9]{1,3} [a-zA-Z]{1,10} [a-zA-Z]{1,10}")) {
										if (customer.getEmailaddress()!= null && customer.getEmailaddress().matches("^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
											 z = customerDAO.createCustomer(customer);
									}else {
										throw new BusinessException("Entered Email Address is INVALID!!");
									}
								}else {
									throw new BusinessException("Entered Customer Address is INVALID!!");
								}
							}else {
								throw new BusinessException("Entered Gender is INVALID!!");
							}
						}else {
							throw new BusinessException("Entered State Initials is INVALID!!");
						}
					}else {
						throw new BusinessException("Entered City is INVALID!!");
					}
				}else {
					throw new BusinessException("Entered Date of Birth is INVALID!!");
				}
			}else {
				throw new BusinessException("Entered Last Name is INVALID!!");
			}
		}else {
			throw new BusinessException("Entered Middle Name is INVALID!!");
		}
	}else {
		throw new BusinessException("Entered First Name is INVALID!!");
	}
		return z;
	}
}
			
//		}else {
//			throw new BusinessException("Entered First Name is INVALID!!");
//		}
//		
//		if (customer.getMiddlename()!=null && customer.getMiddlename().matches("[a-zA-Z]{1,10}")) {
//			 z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered Middle Name is INVALID!!");
//		}
//		
//		if (customer.getLastname().matches("[a-zA-Z]{1,10}") && customer.getLastname()!=null) {
//			 z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered Last Name is INVALID!!");
//		}
//		
//		if (customer.getDateofbirth()!= null && customer.getDateofbirth().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
//			z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered Date of Birth is INVALID!!");
//		}
//		
//		if (customer.getCity()!= null && customer.getCity().matches("[a-zA-Z]{1,10}")) {
//			z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered City is INVALID!!");
//		}
//		
//		if (customer.getState()!= null && customer.getState().matches("[A-Z]{2}")) {
//			z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered State Initials is INVALID!!");
//		}
//		
//		if (customer.getGender()!= null && customer.getGender().matches("[a-zA-Z]{1}")) {
//			z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered Gender is INVALID!!");
//		}
//		
//		if (customer.getCustomeraddress()!= null && customer.getCustomeraddress().matches("[0-9]{1,3} [a-zA-Z]{1,10} [a-zA-Z]{1,10}")) {
//			z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered Customer Address is INVALID!!");
//		}
//		
//		if (customer.getEmailaddress()!= null && customer.getEmailaddress().matches("^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
//			z = customerDAO.createCustomer(customer);
//		}else {
//			throw new BusinessException("Entered Email Address is INVALID!!");
//		}
		//}


