package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Transaction;

public interface TransactionDAO {

	public Transaction createTransactionAmount(int transactionamount);
	public Transaction createTransactionType(String transactiontype);
	public Transaction createTransactionDate(String transactiondate);
}
