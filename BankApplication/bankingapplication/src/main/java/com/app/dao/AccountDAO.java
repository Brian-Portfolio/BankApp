package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Account;

public interface AccountDAO {
		
	public int createAccount(Account account) throws BusinessException;
	public int updateAccountBalanceDeposit(int accountbalance, int id) throws BusinessException;
	public int updateAccountBalanceWithdrawal(int accountbalance, int account_id) throws BusinessException;
	public List<Account> checkAccountStatus(String status) throws BusinessException;
	public List<Account> viewAccountId(int account_id) throws BusinessException;
	public Account verifyAccountID(int account_id) throws BusinessException;
	
	public int getViewAccountBalance(int account_id) throws BusinessException;
	public int setApproveRejectStatus(String status, int account_id) throws BusinessException;
	public int setDelete(int account_id) throws BusinessException;
	public Account verifyGeneratedRandomAccountID(int account_id) throws BusinessException;
	public String checkAccountApproved(int account_id) throws BusinessException;

}
