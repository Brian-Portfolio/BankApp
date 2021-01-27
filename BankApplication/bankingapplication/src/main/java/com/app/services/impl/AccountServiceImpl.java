package com.app.services.impl;

import java.util.List;

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
	public int updateAccountBalanceDeposit(int accountbalance, int id) throws BusinessException{
		int z = 0;
		if (id!=0 && accountbalance >=0 ) {
			 z = accountDAO.updateAccountBalanceDeposit(accountbalance, id);
		}else {
			throw new BusinessException("Deposit cannot be of negative value!");
		}
		return z;
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
	public int getViewAccountBalance(int account_id) throws BusinessException {
		int account = 0;;
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

	@Override
	public int updateAccountBalanceWithdrawal(int accountbalance, int account_id) throws BusinessException {
		int z = 0;
		if (account_id!=0 && accountbalance >=0) {
			 z = accountDAO.updateAccountBalanceWithdrawal(accountbalance, account_id);
		}else {
			throw new BusinessException("Withdrawal cannot be of negative value!");
		}
		return z;
	}

	@Override
	public int createAccount(Account account) throws BusinessException {
		int z =0;
		if (account.getAccountid()!=0) {
			if(account.getId()!=0) {
				if(account.getAccountbalance()<=0) {
					if(account.getAccounttodate()!=null && account.getAccounttodate().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
						if(account.getOpendate()!=null && account.getOpendate().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
							if(account.getAccounttype()!=null && account.getAccounttype().matches("\\b(checking|saving)\\b")) {
								z = accountDAO.createAccount(account);
						}else {
							throw new BusinessException("Entered Account type is incorrect!");
						}
					}else {
						throw new BusinessException("Entered date is invalid!");
					}
				}else {
					throw new BusinessException("Entered date is invalid!");
				}
			}else {
				throw new BusinessException("Account balance cannot be less than zero");
			}
		}else {
			throw new BusinessException("Entered type of ID's is INVALID!!");
		}
	}else {
		throw new BusinessException("Entered type of accountID's is INVALID!!");
	}
		return z;
	}

	@Override
	public List<Account> viewAccountId(int account_id) throws BusinessException {
		List<Account> accountlist = null;
		if(account_id!=0) {
			accountlist = accountDAO.viewAccountId(account_id);
		} else {
			throw new BusinessException("Entered account id "+account_id+" is INVALID!");
		}
		return accountlist;
	}
}
