package com.app.model;

public class Customer {

	private int id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String dateofbirth;
	private String customeraddress;
	private String city;
	private String state;
	private int zipcode ;
	private String emailaddress;
	private String gender;
	
	
	public Customer() {
		
	}


	public Customer(int id,String firstname, String middlename, String lastname, String dateofbirth,
			String customeraddress, String city, String state, String gender, String emailaddress) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.customeraddress = customeraddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.emailaddress = emailaddress;
		this.gender = gender;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getMiddlename() {
		return middlename;
	}


	public void setMiddlename(String middlename) {
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

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Customer [" + ", id=" + id + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", dateofbirth=" + dateofbirth
				+ ", customeraddress=" + customeraddress + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", emailaddress=" + emailaddress + ", gender=" + gender + "]";
	} 

}
