package com.app.model;

public class Account {

	private int account_id;
	private int accountbalance;
	private int id;
	private String accounttype;
	private String opendate;
	private String accounttodate;
	private String status;
	
	public Account() {
		
	}

	public Account(int account_id, int accountbalance, int id, String accounttype,
			String opendate, String accounttodate, String status) {
		super();
		this.account_id = account_id;
		this.accountbalance = accountbalance;
		this.id = id;
		this.accounttype = accounttype;
		this.opendate = opendate;
		this.accounttodate = accounttodate;
		this.status = status;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAccountid() {
		return account_id;
	}



	public void setAccountid(int account_id) {
		this.account_id = account_id;
	}



	public int getAccountbalance() {
		return accountbalance;
	}



	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAccounttype() {
		return accounttype;
	}



	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}



	public String getOpendate() {
		return opendate;
	}



	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}



	public String getAccounttodate() {
		return accounttodate;
	}



	public void setAccounttodate(String accounttodate) {
		this.accounttodate = accounttodate;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", accountbalance=" + accountbalance + ", id=" + id + ", accounttype=" + accounttype + ", opendate=" + opendate
				+ ", accounttodate=" + accounttodate + ", status=" + status + "]";
	}


	
	
}
