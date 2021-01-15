package com.app.services.impl;

import com.app.dao.CustomerLoginDAO;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;
import com.app.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService{

	private CustomerLoginDAO customerloginDAO = new CustomerLoginDAOImpl();
	
	@Override
	public CustomerLogin CreateUsername(String username, int loginid) throws BusinessException {
		CustomerLogin customerlogin = null;
		if (username!=null && username.matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&-+=()])(?=\\S+$).{8,20}")) {
			 customerlogin = customerloginDAO.CreateUsername(username, loginid);
		}else {
			throw new BusinessException("Entered type of account is INVALID!!");
		}
		return customerlogin;
	}
	
	@Override
	public CustomerLogin CreatePassword(String password, int loginid) throws BusinessException {
		CustomerLogin customerlogin = null;
		if (password!=null && password.matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&-+=()])(?=\\S+$).{8,20}")) {
			 customerlogin = customerloginDAO.CreatePassword(password, loginid);
		}else {
			throw new BusinessException("Entered type of account is INVALID!!");
		}
		return customerlogin;
	}

	@Override
	public CustomerLogin CustomerloginID(int loginid, int account_id) throws BusinessException {
		if (loginid !=0 && account_id!=0) {
			 customerloginDAO.CustomerloginID(loginid, account_id);
		}else {
			throw new BusinessException("Entered id is INVALID!!");
		}
		return null;
	}

}
