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
	public Transaction createTransactionAmount(int transactionamount, int transaction_id) throws BusinessException {
		Transaction transaction = null;
		if (transactionamount >= 50 && transaction_id!=0) {
			 transaction = transactionDAO.createTransactionAmount(transactionamount, transaction_id);
		}else {
			throw new BusinessException("Entered transaction is INVALID!!");
		}
		
		return transaction;
	}

	@Override
	public Transaction createTransactionType(String transactiontype, int transaction_id) throws BusinessException {
		Transaction transaction = null;
		if (transactiontype.matches("\\b(deposit|withdrawal)\\b") && transaction_id!=0) { 
			 transaction = transactionDAO.createTransactionType(transactiontype, transaction_id);
		}else {
			throw new BusinessException("Entered transaction type is INVALID!!");
		}
		return transaction;
		
	}

	@Override
	public Transaction createTransactionDate(String transactiondate, int transaction_id) throws BusinessException {
		Transaction transaction = null;
		if (transactiondate != null && transactiondate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
			 transaction = transactionDAO.createTransactionDate(transactiondate, transaction_id);
		}else {
			throw new BusinessException("Entered transaction date is INVALID!!");
		}
		
		return transaction;
	}

	@Override
	public Transaction getTransactionID(int transaction_id, int account_id) throws BusinessException {
		Transaction transaction = null;
		if (account_id!=0 && transaction_id!=0) {
			 transaction = transactionDAO.getTransactionID(transaction_id, account_id);
		}else {
			throw new BusinessException("Entered type of ID's is INVALID!!");
		}
		return transaction;
	}

	@Override
	public int createWithdraw(Transaction transaction) throws BusinessException{
		int z =0;
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
		return z;
	}

	@Override
	public int createDeposit(Transaction transaction) throws BusinessException {
		int z =0;
		if (transaction.getTransactionamount() >= 0) {
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
			throw new BusinessException("Please make your deposit greater than 0!");
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
}
