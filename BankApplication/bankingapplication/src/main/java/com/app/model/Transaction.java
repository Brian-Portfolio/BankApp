package com.app.model;

public class Transaction {

	private int transaction_id;
	private String transactiondate;
	private int account_id;
	private int transactionamount;
	private String transactiontype;
	private int totalbalance;
	
	public Transaction() {
		
	}

	public Transaction(int transaction_id, String transactiondate, int account_id, int transactionamount,
			String transactiontype) {
		super();
		this.transaction_id = transaction_id;
		this.transactiondate = transactiondate;
		this.account_id = account_id;
		this.transactionamount = transactionamount;
		this.transactiontype = transactiontype;
		this.totalbalance = totalbalance;
	}


	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public String getTransactiondate() {
		return transactiondate;
	}


	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}


	public int getAccount_Id() {
		return account_id;
	}


	public void setAccount_Id(int account_id) {
		this.account_id = account_id;
	}


	public int getTransactionamount() {
		return transactionamount;
	}


	public void setTransactionamount(int transactionamount) {
		this.transactionamount = transactionamount;
	}


	public String getTransactiontype() {
		return transactiontype;
	}


	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}


	public int getTotalbalance() {
		return totalbalance;
	}


	public void setTotalbalance(int totalbalance) {
		this.totalbalance = totalbalance;
	}


	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", transactiondate=" + transactiondate + ", account_id="
				+ account_id + ", transactionamount=" + transactionamount + ", transactiontype=" + transactiontype
				+ ", "+ ", totalbalance=" + totalbalance + "]";
	}
	
	
	
}
