package com.app.services.impl;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public int getCustomerID() throws BusinessException {
		int id =0;
		if (id >= 0) {
			id = customerDAO.getCustomerID();
		}else {
			throw new BusinessException("Entered id is INVALID!!");
		}
		return id;
	}

	@Override
	public long createCustomer(Customer customer) throws BusinessException {
		long z =0;
		
		if (customer.getFirstname()!=null && customer.getFirstname().matches("[a-zA-Z]{1,20}") ) {
			if (customer.getMiddlename().equals("") || customer.getMiddlename().matches("[a-zA-Z]{1,20}")){
				if (customer.getLastname()!=null && customer.getLastname().matches("[a-zA-Z]{1,20}")) {
					if (customer.getDateofbirth()!= null && customer.getDateofbirth().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
						if (customer.getCity()!= null && customer.getCity().matches("[a-zA-Z]{1,20}")) {
							if (customer.getState()!= null && customer.getState().matches("[A-Z]{2}")) {
								if (customer.getGender()!= null && customer.getGender().matches("[a-zA-Z]{1}")) {
									if (customer.getCustomeraddress()!= null && customer.getCustomeraddress().matches("[0-9]{1,5} [a-zA-Z]{1,20} [a-zA-Z]{1,20}")) {
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


	@Override
	public int setDelete(int account_id) throws BusinessException {
		int z = 0;
		if(account_id!=0) {
			z = customerDAO.setDelete(account_id);
		}else {
			throw new BusinessException("Entered account id "+account_id+" is INVALID!");
		}
		return z;
	}


}