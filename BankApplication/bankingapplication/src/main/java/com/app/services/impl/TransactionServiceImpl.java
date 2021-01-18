package com.app.services.impl;

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
	public Transaction createWithdraw(int account_id, int transactionamount, String transactiontype, int transaction_id, String transactiondate) throws BusinessException {
		Transaction transaction = null;
		if (account_id!=0 && transactionamount<=0 && transactiontype!=null && transactiondate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}") ) {
			transaction = transactionDAO.createWithdraw(account_id, transactionamount, transactiontype, transaction_id, transactiondate);
		}else {
			throw new BusinessException("Transaction amount cannot be a negative number");
		}
		return transaction;
	}

	@Override
	public Transaction createDeposit(int account_id, int transactionamount, String transactiontype) throws BusinessException {
		Transaction transaction = null;
		if (account_id!=0 && transactionamount<=0 && transactiontype!=null) {
			transaction = transactionDAO.createDeposit(account_id, transactionamount, transactiontype);
		}else {
			throw new BusinessException("Account ID cannot be 0 or a negative number. Transaction amount cannot be a negative number.");
		}
		return transaction;
	}

}
