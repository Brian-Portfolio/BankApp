package com.app.model;

public class Account {

	private int accountid;
	private int accountbalance;
	private int accountinterests;
	private int customerid;
	private String accounttype;
	private String opendate;
	private String accounttodate;
	
	public Account() {
		
	}

	public Account(int accountid, int accountbalance, int accountinterests, int customerid, String accounttype,
			String opendate, String accounttodate) {
		super();
		this.accountid = accountid;
		this.accountbalance = accountbalance;
		this.accountinterests = accountinterests;
		this.customerid = customerid;
		this.accounttype = accounttype;
		this.opendate = opendate;
		this.accounttodate = accounttodate;
	}

	public int getAccountid() {
		return accountid;
	}



	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}



	public int getAccountbalance() {
		return accountbalance;
	}



	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}



	public int getAccountinterests() {
		return accountinterests;
	}



	public void setAccountinterests(int accountinterests) {
		this.accountinterests = accountinterests;
	}



	public int getCustomerid() {
		return customerid;
	}



	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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
		return "Account [accountid=" + accountid + ", accountbalance=" + accountbalance + ", accountinterests="
				+ accountinterests + ", customerid=" + customerid + ", accounttype=" + accounttype + ", opendate="
				+ opendate + ", accounttodate=" + accounttodate + "]";
	}
	
	
	
	
	
}
