package com.app.services.impl;

import com.app.dao.TransactionDAO;
import com.app.dao.impl.TransactionDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Transaction;
import com.app.service.TransactionService;

public class TransactionServiceImpl implements TransactionService{

	private TransactionDAO transactionDAO = new TransactionDAOImpl();
	
	@Override
	public Transaction createTransactionAmount(int transactionamount) throws BusinessException {
		Transaction transaction = null;
		if (transactionamount != 0) {
			 transaction = transactionDAO.createTransactionAmount(transactionamount);
		}else {
			throw new BusinessException("Entered Customer Address is INVALID!!");
		}
		
		return transaction;
	}

	@Override
	public Transaction createTransactionType(String transactiontype) throws BusinessException {
		Transaction transaction = null;
		if (transactiontype != null) { //&& transactiontype == ) {
			 transaction = transactionDAO.createTransactionType(transactiontype);
		}else {
			throw new BusinessException("Entered Customer Address is INVALID!!");
		}
		return transaction;
		
	}

	@Override
	public Transaction createTransactionDate(String transactiondate) throws BusinessException {
		Transaction transaction = null;
		if (transactiondate != null && transactiondate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}")) {
			 transaction = transactionDAO.createTransactionDate(transactiondate);
		}else {
			throw new BusinessException("Entered Customer Address is INVALID!!");
		}
		
		return transaction;
	}

}
