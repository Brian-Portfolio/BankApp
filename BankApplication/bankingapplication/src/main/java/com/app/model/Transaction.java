package com.app.model;

public class Transaction {

	private int tid;//sequenced
	private String transactiondate;
	private int accid;//joined
	private int transactionamount;
	private String transactiontype;
	private int customerid; //joined
	private int totalbalance;
	
	public Transaction() {
		
	}

	public Transaction(int tid, String transactiondate, int accid, int transactionamount,
			String transactiontype, int customerid, int totalbalance) {
		super();
		this.tid = tid;
		this.transactiondate = transactiondate;
		this.accid = accid;
		this.transactionamount = transactionamount;
		this.transactiontype = transactiontype;
		this.customerid = customerid;
		this.totalbalance = totalbalance;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTransactiondate() {
		return transactiondate;
	}


	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}


	public int getAccid() {
		return accid;
	}


	public void setAccid(int accid) {
		this.accid = accid;
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


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public int getTotalbalance() {
		return totalbalance;
	}


	public void setTotalbalance(int totalbalance) {
		this.totalbalance = totalbalance;
	}


	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", transactiondate=" + transactiondate + ", accid="
				+ accid + ", transactionamount=" + transactionamount + ", transactiontype=" + transactiontype
				+ ", customerid=" + customerid + ", totalbalance=" + totalbalance + "]";
	}
	
	
	
}
