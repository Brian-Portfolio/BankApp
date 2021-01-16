package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Transaction;

public interface TransactionService {

	public Transaction getTransactionID(int transaction_id, int account_id) throws BusinessException;
	public Transaction createTransactionAmount(int transactionamount, int transaction_id) throws BusinessException;
	public Transaction createTransactionType(String transactiontype, int transaction_id) throws BusinessException;
	public Transaction createTransactionDate(String transactiondate, int transaction_id) throws BusinessException;
	public Transaction createWithdraw(int account_id, int transactionamount, String transactiontype) throws BusinessException;
	public Transaction createDeposit(int account_id, int transactionamount, String transactiontype) throws BusinessException;
}
