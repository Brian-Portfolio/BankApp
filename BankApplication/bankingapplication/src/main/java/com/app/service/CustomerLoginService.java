package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;

public interface CustomerLoginService {

	public int createCustomerLogin(CustomerLogin customerlogin) throws BusinessException;
	public CustomerLogin CreateUsername(String username, int loginid) throws BusinessException;
	public CustomerLogin CreatePassword(String password, int loginid) throws BusinessException;
	public CustomerLogin CustomerloginID(int loginid, int account_id) throws BusinessException;
	public CustomerLogin verifyCustomerLogin(String username, String password) throws BusinessException;

}
