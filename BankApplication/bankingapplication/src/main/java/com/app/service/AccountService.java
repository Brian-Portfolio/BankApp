package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Account;

public interface AccountService {
	
	public int createAccount(Account account) throws BusinessException;
	public int updateAccountBalanceDeposit(int accountbalance, int id) throws BusinessException;
	public int updateAccountBalanceWithdrawal(int accountbalance, int account_id) throws BusinessException;
	public Account createAccountType(String accounttype, int id) throws BusinessException;
	public Account getAccountID(int account_id, int id) throws BusinessException;
	public Account getDateOfCreatedAccount(String opendate, int id) throws BusinessException;
	public Account setAccountBalance(int accountbalance, int id) throws BusinessException;
	public int getViewAccountBalance(int account_id) throws BusinessException;
	public Account verifyAccountID(int account_id) throws BusinessException;
	public List<Account> viewAccountId(int account_id) throws BusinessException;

}
