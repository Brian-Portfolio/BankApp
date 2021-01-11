package com.app.dao;

import com.app.model.Transaction;

public interface TransactionDAO {

	public int createTransactions(Transaction transaction);
	public int createTransactionAmount(int transactionamount);
	public String dateOfCreatedTransaction(String transactiondate);
	public String chooseTransactionType(String transactiontype);
}
