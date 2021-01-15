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

}
