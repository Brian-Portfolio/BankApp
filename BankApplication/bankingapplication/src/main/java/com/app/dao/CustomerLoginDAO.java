package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;

public interface CustomerLoginDAO {
	
	public int createCustomerLogin(CustomerLogin customerlogin);
	public CustomerLogin CustomerloginID(int loginid, int account_id) throws BusinessException;
	public CustomerLogin CreateUsername(String username, int id);
	public CustomerLogin CreatePassword(String password, int id);
	public CustomerLogin verifyCustomerLogin(String username, String password) throws BusinessException;
}
