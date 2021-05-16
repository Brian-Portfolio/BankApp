package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Transaction;

public interface TransactionService {

	public int createTransaction(Transaction transaction) throws BusinessException;
	public int createWithdraw(Transaction transaction) throws BusinessException;
	public int createDeposit(Transaction transaction) throws BusinessException;
	public List<Transaction> checkRejectTransaction(String transferstatus) throws BusinessException;
	
	public List<Transaction> viewPendingPostTransactionLog(String transferstatus, int account_id) throws BusinessException;
	public int acceptRejectTransaction(String transferstatus, int transaction_id) throws BusinessException;
	public List<Transaction> viewTransactionLog(int account_id) throws BusinessException;
	public int setDelete(int account_id) throws BusinessException;
	public int setDeleteTransaction(int transaction_id) throws BusinessException;
	public int getTransactionAmount(int transaction_id) throws BusinessException;

}
