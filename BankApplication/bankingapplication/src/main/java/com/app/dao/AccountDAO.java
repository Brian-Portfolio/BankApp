package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Account;

public interface AccountDAO {
	
	//public Account getAccount	
	public Account createAccountType(String accounttype) throws BusinessException;
	public int getDateOfCreatedAccount(String opendate) throws BusinessException;
	public Account getViewAccountBalance(int accid) throws BusinessException;
	public List<Account> getAccountBalanceByAccountId(int accid);
	
}
