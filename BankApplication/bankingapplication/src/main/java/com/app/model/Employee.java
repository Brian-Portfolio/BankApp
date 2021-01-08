package com.app.model;

public class Employee {

	private int employeeid;
	private String firstname;
	private String lastname;
	private int accountid;
	
	
	public Employee() {
		
	}


	public Employee(int employeeid, String firstname, String lastname, int accountid) {
		super();
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accountid = accountid;
	}


	public int getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", accountid=" + accountid + "]";
	
	
}

}
