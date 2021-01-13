package com.app.model;

public class Account {

	private int accid;
	private int accountbalance;
	private int accountinterests;
	private int nameid;
	private String accounttype;
	private String opendate;
	private String accounttodate;
	
	public Account() {
		
	}

	public Account(int accid, int accountbalance, int accountinterests, int nameid, String accounttype,
			String opendate, String accounttodate) {
		super();
		this.accid = accid;
		this.accountbalance = accountbalance;
		this.accountinterests = accountinterests;
		this.nameid = nameid;
		this.accounttype = accounttype;
		this.opendate = opendate;
		this.accounttodate = accounttodate;
	}

	public int getAccountid() {
		return accid;
	}



	public void setAccid(int accid) {
		this.accid = accid;
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



	public int getNameid() {
		return nameid;
	}



	public void setCustomerid(int nameid) {
		this.nameid = nameid;
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
		return "Account [accid=" + accid + ", accountbalance=" + accountbalance + ", accountinterests="
				+ accountinterests + ", nameid=" + nameid + ", accounttype=" + accounttype + ", opendate="
				+ opendate + ", accounttodate=" + accounttodate + "]";
	}
	
	
	
	
	
}
