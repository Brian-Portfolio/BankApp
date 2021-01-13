package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Transaction;

public interface TransactionService {

	public Transaction createTransactionAmount(int transactionamount) throws BusinessException;
	public Transaction createTransactionType(String transactiontype) throws BusinessException;
	public Transaction createTransactionDate(String transactiondate) throws BusinessException;
}
