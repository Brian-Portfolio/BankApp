package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Account;

public interface AccountService {
	
	public Account updateAccountBalanceDeposit(int accountbalance, int id) throws BusinessException;
	public Account createAccountType(String accounttype, int id) throws BusinessException;
	public Account getAccountID(int account_id, int id) throws BusinessException;
	public Account getDateOfCreatedAccount(String opendate, int id) throws BusinessException;
	public Account setAccountBalance(int accountbalance, int id) throws BusinessException;
	public Account getViewAccountBalance(int account_id) throws BusinessException;
}
