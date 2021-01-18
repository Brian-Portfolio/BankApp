package com.app.services.impl;

import com.app.dao.AccountDAO;
import com.app.dao.impl.AccountDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public Account createAccountType(String accounttype, int id) throws BusinessException {
		Account account = null;
		if (id!=0 && accounttype.matches("\\b(checking|saving)\\b")) {
			 account = accountDAO.createAccountType(accounttype, id);
		}else {
			throw new BusinessException("Entered type of account is INVALID!!");
		}
		return account;
	}

	@Override
	public Account getAccountID(int account_id, int id) throws BusinessException {
		Account account = null;
		if (account_id!=0 && id!=0) {
			 account = accountDAO.getAccountID(account_id, id);
		}else {
			throw new BusinessException("Entered type of ID's is INVALID!!");
		}
		return account;

	}

	@Override
	public Account updateAccountBalanceDeposit(int accountbalance, int id) throws BusinessException{
		Account account = null;
		if (id!=0 && accountbalance >=0 ) {
			 account = accountDAO.updateAccountBalanceDeposit(accountbalance, id);
		}else {
			throw new BusinessException("Entered deposit is INVALID!!");
		}
		return account;
	}

	@Override
	public Account getDateOfCreatedAccount(String opendate, int id) throws BusinessException {
		Account account = null;
		if (opendate != null && opendate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
			 account = accountDAO.getDateOfCreatedAccount(opendate, id);
		}else {
			throw new BusinessException("Entered transaction date is INVALID!!");
		}
		
		return account;
	}

	@Override
	public Account setAccountBalance(int accountbalance, int id) throws BusinessException {
		Account account = null;
		if (accountbalance>=0 && id!=0) {
			 account = accountDAO.setAccountBalance(accountbalance, id);
		}else {
			throw new BusinessException("Entered account balance INVALID!!");
		}
		return account;
	}

	@Override
	public Account getViewAccountBalance(int account_id) throws BusinessException {
		Account account = null;
		if (account_id!=0 ) {
			 account = accountDAO.getViewAccountBalance(account_id);
		}else {
			throw new BusinessException("Entered type of accountID's is INVALID!!");
		}
		return account;
	}

	@Override
	public Account verifyAccountID(int account_id) throws BusinessException {
		Account account = null;
		if (account_id!=0 ) {
			 account = accountDAO.verifyAccountID(account_id);
		}else {
			throw new BusinessException("Entered type of accountID's is INVALID!!");
		}
		return account;
	}
}
