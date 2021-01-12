package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Account;

public interface AccountDAO {
	
	//public Account getAccount
//	public int createAccount(Account account) throws BusinessException;
//	public int createaccountReference(int accountid);
//	
	
	public Account createAccountType(String accounttype) throws BusinessException;
	public Account getDateOfCreatedAccount(String opendate) throws BusinessException;
	public int getViewAccountBalance(int accountid) throws BusinessException;
	public List<Account> getAccountBalanceByAccountId(int accountid);
	
}
