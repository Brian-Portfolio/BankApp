package com.app.services.impl;

import java.util.List;

import com.app.dao.TransactionDAO;
import com.app.dao.impl.TransactionDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Transaction;
import com.app.service.TransactionService;

public class TransactionServiceImpl implements TransactionService{

	private TransactionDAO transactionDAO = new TransactionDAOImpl();

	@Override
	public int createWithdraw(Transaction transaction) throws BusinessException{
		int z =0;
		if (transaction.getTransferstatus().matches("\\b(pending|active|reject|NA)\\b")) {
			if (transaction.getTransactionamount() >= 0) {
				if (transaction.getTransactiontype().matches("\\b(deposit|withdrawal)\\b")) {
					if(transaction.getTransactiondate()!=null && transaction.getTransactiondate().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
						if(transaction.getTransaction_id()!=0) {
							if (transaction.getAccount_Id()!=0) {
								z = transactionDAO.createWithdraw(transaction);
							}else {
								throw new BusinessException("Account ID is invalid!");
							}
						}else {
							throw new BusinessException("Transaction ID is invalid!");
						}
					}else {
						throw new BusinessException("Entered date is invalid!");
					}
				}else {
					throw new BusinessException("You must choose between a checking and savings account only! ");
				}
			}else {
				throw new BusinessException("Please make your withdrawal greater than 0!");
			}
		}else {
			throw new BusinessException("Status is invalid");
		}
		return z;
	}

	@Override
	public int createDeposit(Transaction transaction) throws BusinessException {
		int z =0;
		if (transaction.getTransferstatus().matches("\\b(pending|active|reject|NA)\\b")) {
			if (transaction.getTransactionamount() >= 0) {
				if (transaction.getTransactiontype().matches("\\b(deposit|withdrawal)\\b")) {
					if(transaction.getTransactiondate()!=null && transaction.getTransactiondate().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
						if(transaction.getTransaction_id()!=0) {
							if (transaction.getAccount_Id()!=0) {
								z = transactionDAO.createWithdraw(transaction);
							}else {
								throw new BusinessException("Account ID is invalid!");
							}
						}else {
							throw new BusinessException("Transaction ID is invalid!");
						}
					}else {
						throw new BusinessException("Entered date is invalid!");
					}
				}else {
					throw new BusinessException("You must choose between a checking and savings account only! ");
				}
			}else {
				throw new BusinessException("Please make your withdrawal greater than 0!");
			}
		}else {
			throw new BusinessException("Status is invalid");
		}
		return z;
	}
	@Override
	public int createTransaction(Transaction transaction) throws BusinessException {
		int z =0;
		if (transaction.getTransactionamount() >= 50) {
			if (transaction.getTransactiontype().matches("\\b(deposit|withdrawal)\\b")) {
				if(transaction.getTransactiondate()!=null && transaction.getTransactiondate().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
					if(transaction.getTransaction_id()!=0) {
						if (transaction.getAccount_Id()!=0) {
							z = transactionDAO.createTransaction(transaction);
						}else {
							throw new BusinessException("Account ID is invalid!");
						}
					}else {
						throw new BusinessException("Transaction ID is invalid!");
					}
				}else {
					throw new BusinessException("Entered date is invalid!");
				}
			}else {
				throw new BusinessException("You must choose between a checking and savings account only! ");
			}
		}else {
			throw new BusinessException("Please make your deposit greater than or equal to 50");
		}
		return z;
	}

	@Override
	public List<Transaction> viewTransactionLog(int account_id) throws BusinessException {
		List<Transaction> transactionlist = null;
		if(account_id!=0) {
			transactionlist = transactionDAO.viewTransactionLog(account_id);
		}else {
			throw new BusinessException("Entered account id "+account_id+" is INVALID!");
		}
		return transactionlist;
	}

	@Override
	public int setDelete(int account_id) throws BusinessException {
		int z = 0;
		if(account_id!=0) {
			z = transactionDAO.setDelete(account_id);
		}else {
			throw new BusinessException("Entered account id "+account_id+" is INVALID!");
		}
		return z;
	}

	@Override
	public int acceptRejectTransaction(String transferstatus, int transaction_id) throws BusinessException {
	int z = 0; 
	if(transaction_id!=0 && transferstatus.matches("\\b(accept|reject)\\b")) {
			z = transactionDAO.acceptRejectTransaction(transferstatus, transaction_id);
		}else {
			throw new BusinessException("Please type in a correct transaction id and either accept or reject!");
		}
		return z;
	}

	@Override
	public List<Transaction> viewPendingPostTransactionLog(String transferstatus, int account_id) throws BusinessException {
		List<Transaction> transactionlist = null;
		if(transferstatus.matches("\\b(pending)\\b")) {
			transactionlist = transactionDAO.viewPendingPostTransactionLog(transferstatus, account_id);
		}else {
			throw new BusinessException("Entered transfer status "+transferstatus+" is INVALID!");
		}
		return transactionlist;
	}

	@Override
	public int setDeleteTransaction(int transaction_id) throws BusinessException {
		int z = 0;
		if(transaction_id!=0) {
			z = transactionDAO.setDelete(transaction_id);
		}else {
			throw new BusinessException("Entered account id "+transaction_id+" is INVALID!");
		}
		return z;
	}

	@Override
	public int getTransactionAmount(int transaction_id) throws BusinessException {
		int transaction = 0;
		if (transaction_id!=0 ) {
			 transaction = transactionDAO.getTransactionAmount(transaction_id);
		}else {
			throw new BusinessException("Entered type of transactionID's is INVALID!!");
		}
		return transaction;
	}

	@Override
	public List<Transaction> checkRejectTransaction(String transferstatus) throws BusinessException {
		List<Transaction> transactionlist = null;
		if (transferstatus != null) {
			transactionlist = transactionDAO.checkRejectTransaction(transferstatus);
		}else {
			throw new BusinessException("Entered status "+transferstatus+ " is INVALID!");
		}
		return transactionlist;
	}
}
