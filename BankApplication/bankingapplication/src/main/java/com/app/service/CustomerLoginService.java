package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;

public interface CustomerLoginService {

	public CustomerLogin CreateUsername(String username) throws BusinessException;
	public CustomerLogin CreatePassword(String password) throws BusinessException;
}
