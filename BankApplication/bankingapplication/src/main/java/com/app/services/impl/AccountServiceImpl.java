package com.app.services.impl;

import com.app.dao.AccountDAO;
import com.app.dao.impl.AccountDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public Account createAccountType(String accounttype) throws BusinessException {
		Account account = null;
		if (accounttype!=null) {
			 account = accountDAO.createAccountType(accounttype);
		}else {
			throw new BusinessException("Entered type of account is INVALID!!");
		}
		return account;
	}

}
