package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Transaction;

public interface TransactionDAO {

	public Transaction getTransactionID(int transaction_id, int account_id) throws BusinessException;
	public Transaction createTransactionAmount(int transactionamount, int transaction_id);
	public Transaction createTransactionType(String transactiontype, int transaction_id);
	public Transaction createTransactionDate(String transactiondate, int transaction_id);
	public Transaction createWithdraw(int account_id, int transactionamount, String transactiontype, int transaction_id, String transactiondate);
	public Transaction createDeposit(int account_id, int transactionamount, String transactiontype);
	

}
