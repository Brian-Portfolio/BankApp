package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Account;

public interface AccountService {
	public Account createAccountType(String accounttype) throws BusinessException;
}
