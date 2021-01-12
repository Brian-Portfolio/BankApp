package com.app.services.impl;

import com.app.dao.CustomerLoginDAO;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;
import com.app.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService{

	private CustomerLoginDAO customerloginDAO = new CustomerLoginDAOImpl();
	
	@Override
	public CustomerLogin CreateUsername(String username) throws BusinessException {
		CustomerLogin customerlogin = null;
		if (username!=null && username.matches("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
			 customerlogin = customerloginDAO.CreateUsername(username);
		}else {
			throw new BusinessException("Entered type of account is INVALID!!");
		}
		return customerlogin;
	}

	@Override
	public CustomerLogin CreatePassword(String password) throws BusinessException {
		CustomerLogin customerlogin = null;
		if (password!=null && password.matches("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
			 customerlogin = customerloginDAO.CreateUsername(password);
		}else {
			throw new BusinessException("Entered type of account is INVALID!!");
		}
		return customerlogin;
	}

}
