package com.app.model;

public class Customer {

	private int accountid;
	private int customerid;
	private int firstname;
	private int middlename;
	private String lastname;
	private String dateofbirth;
	private String customeraddress;
	private String city;
	private String state;
	private int zipcode ;
	private String emailaddress;
	private int phonenumber;
	private int ssn;
	private String gender;
	
	
	public Customer() {
		
	}


	public Customer(int accountid, int customerid, int firstname, int middlename, String lastname, String dateofbirth,
			String customeraddress, String city, String state, int zipcode, String emailaddress, int phonenumber,
			int ssn, String gender) {
		super();
		this.accountid = accountid;
		this.customerid = customerid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.customeraddress = customeraddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.emailaddress = emailaddress;
		this.phonenumber = phonenumber;
		this.ssn = ssn;
		this.gender = gender;
	}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public int getFirstname() {
		return firstname;
	}


	public void setFirstname(int firstname) {
		this.firstname = firstname;
	}


	public int getMiddlename() {
		return middlename;
	}


	public void setMiddlename(int middlename) {
		this.middlename = middlename;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getCustomeraddress() {
		return customeraddress;
	}


	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	public String getEmailaddress() {
		return emailaddress;
	}


	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}


	public int getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}


	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Customer [accountid=" + accountid + ", customerid=" + customerid + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", dateofbirth=" + dateofbirth
				+ ", customeraddress=" + customeraddress + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", emailaddress=" + emailaddress + ", phonenumber=" + phonenumber + ", ssn=" + ssn
				+ ", gender=" + gender + "]";
	} 

}
