package com.app.model;

public class Employee {

	private int employeeid;
	private String firstname;
	private String lastname;
	private int account_id;
	
	
	public Employee() {
		
	}


	public Employee(int employeeid, String firstname, String lastname, int account_id) {
		super();
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.account_id = account_id;
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
		return account_id;
	}


	public void setAccountid(int account_id) {
		this.account_id = account_id;
	}


	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", account_id=" + account_id + "]";
	
	
}

}
