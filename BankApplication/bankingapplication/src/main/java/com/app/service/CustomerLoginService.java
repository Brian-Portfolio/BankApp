package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;

public interface CustomerLoginService {

	public int createCustomerLogin(CustomerLogin customerlogin) throws BusinessException;
	public CustomerLogin verifyCustomerLogin(String username, String password) throws BusinessException;
	public int setDelete(int account_id) throws BusinessException;

}
