package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Account;

public interface AccountDAO {
		
	public Account getReferenceID(int id) throws BusinessException;
	public Account getAccountID(int account_id, int id) throws BusinessException;
	public Account createAccountType(String accounttype, int id) throws BusinessException;
	public Account setAccountBalance(int accountbalance, int id) throws BusinessException;
	public Account getDateOfCreatedAccount(String opendate, int id) throws BusinessException;
	public Account getViewAccountBalance(int account_id) throws BusinessException;
	public List<Account> getAccountBalanceByAccountId(int account_id);
	
}
