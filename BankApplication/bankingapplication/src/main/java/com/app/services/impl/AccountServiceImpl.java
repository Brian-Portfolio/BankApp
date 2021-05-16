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
								if(account.getStatus()!=null && account.getStatus().matches("\\b(pending|active|reject)\\b")) {
								z = accountDAO.createAccount(account);
								}else {
									throw new BusinessException("Entered status is not available");
								}
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
		}else {
			throw new BusinessException("Entered account id "+account_id+" is INVALID!");
		}
		return accountlist;
	}

	@Override
	public List<Account> checkAccountStatus(String status) throws BusinessException {
		List<Account> accountlist = null;
		if (status != null) {
			accountlist = accountDAO.checkAccountStatus(status);
		}else {
			throw new BusinessException("Entered status "+status+ " is INVALID!");
		}
		return accountlist;
	}

	@Override
	public int setApproveRejectStatus(String status, int account_id) throws BusinessException {
		int z = 0;
		if(status!=null && status.matches("\\b(pending|active|reject)\\b") && account_id !=0 ) {
			z = accountDAO.setApproveRejectStatus(status, account_id);
		}else {
			throw new BusinessException("Entered status or accountid are INVALID!");
		}
		return z;
	}

	@Override
	public int setDelete(int account_id) throws BusinessException {
		int z = 0;
		if(account_id!=0) {
			z = accountDAO.setDelete(account_id);
		}else {
			throw new BusinessException("Entered account id "+account_id+" is INVALID!");
		}
		return z;
	}

	@Override
	public Account verifyGeneratedRandomAccountID(int account_id) throws BusinessException {
		Account account = null;
		if (account_id!=0 ) {
			 account = accountDAO.verifyAccountID(account_id);
		}else {
			throw new BusinessException("Entered type of accountID's is INVALID!!");
		}
		return account;
	}

	@Override
	public String checkAccountApproved(int account_id) throws BusinessException {
		String approveaccount = null;
		
		if (account_id!=0) {
			approveaccount = accountDAO.checkAccountApproved(account_id); 
		}else {
			throw new BusinessException("Entered account id "+account_id+" is iINVALID!!");
		}
		
		return approveaccount;
	}
}
