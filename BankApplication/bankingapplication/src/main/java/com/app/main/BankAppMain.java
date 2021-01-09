package com.app.main;

import java.util.Scanner;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class BankAppMain {

	public static void main(String[] args) {
		
		CustomerDAO dao = new CustomerDAOImpl(); 
		
		Customer c1 = new Customer();
		
//		Customer c1 = new Customer(900, 2003, "brian", "m", "lola", "1992-03-03", "10parkave", "newyorkcity", "NY", 20851, "hello", 123456, 345345, "M");
//		try {
//			if (dao.createCustomer(c1)!=0) {
//				System.out.println("customer created successfully");
//			}
//		}catch(BusinessException e){
//			System.out.println(e.getMessage());
//		}
		
		
		Scanner userinput = new Scanner(System.in);
		System.out.println("Please enter account id : ");
		int AccountId = Integer.parseInt(userinput.nextLine());
		c1.setAccountid(AccountId);
		//c1.getAccountid();
		
		System.out.println("Please enter Customer id : ");
		int CustomerId = Integer.parseInt(userinput.nextLine());
		c1.setCustomerid(CustomerId);
		//c1.getCustomerid();
		
		System.out.println("Please enter FirstName : ");
		String firstname = userinput.nextLine();
		c1.setFirstname(firstname);
		//c1.getFirstname();
		try {
			if (dao.createCustomer(c1)!=0) {
				System.out.println("customer created successfully");
			}
		}catch(BusinessException e){
			System.out.println(e.getMessage());
		}
		
//		System.out.println("Please enter MiddleName : ");
//		String middlename = userinput.nextLine();
//		c1.setMiddlename(middlename);
//		c1.getMiddlename();
//		
//		System.out.println("Please enter LastName : ");
//		String lastname = userinput.nextLine();
//		c1.setLastname(lastname);
//		c1.getLastname();
//		
//		System.out.println("Please enter DOB : ");
//		String DOB = userinput.nextLine();
//		c1.setDateofbirth(DOB);
//		c1.getDateofbirth();
		
//		System.out.println("Please enter Address : ");
//		String Address = userinput.nextLine();
//		c1.setCustomeraddress(Address);
//		
//		System.out.println("Please enter City : ");
//		String city = userinput.nextLine();
//		c1.setCity(city);
//		
//		System.out.println("Please enter State : ");
//		String state = userinput.nextLine();
//		c1.setState(state);
//		
//		System.out.println("Please enter Zipcode : ");
//		int zipcode = Integer.parseInt(userinput.nextLine());
//		c1.setZipcode(zipcode);
//		
//		System.out.println("Please enter EmailAddress : ");
//		String email = userinput.nextLine();
//		c1.setEmailaddress(email);
//		
//		System.out.println("Please enter Phonenumber : ");
//		int phonenumber = Integer.parseInt(userinput.nextLine());
//		c1.setZipcode(phonenumber);
//		
//		System.out.println("Please enter SSN : ");
//		int SSN = Integer.parseInt(userinput.nextLine());
//		c1.setZipcode(SSN);
//		
//		System.out.println("Please enter Zipcode : ");
//		String Gender = userinput.nextLine();
//		c1.setGender(Gender);
//		
		
		
		
		//Below is format of UserStories
		
		
		//try a thread to load the application within a 5 to 10 sec span
		
//		System.out.println("Welcome and thank you for choosing the Revature Banking Application");
//		
//		//for(;;) {// infinite loop starts
//			
//		System.out.println("If you are logging in as a new customer please choose option 1 for all other returning customers please choose option 2 : "); 
//		//System.out.println("Need help by product please choose one of the following : ");
//		int choose = 0;
//		int option = 0;
//		do {
//			System.out.println("1. New Customer? Please type in 1 : ");
//			System.out.println("2. Returning Customer? Please type in 2 : ");
//			System.out.println("3. Exit Application");
//			try {
//				option=Integer.parseInt(userinput.nextLine());
//			}catch(NumberFormatException e) {
//				
//			}
//			switch (option) {
//			case 1:
//				
//		do {
//			System.out.println("MENU");
//			System.out.println("-----------------------------");
//			System.out.println("1. General Information");
//			System.out.println("2. New Accounts");
//			System.out.println("3. Emails and Alerts");
//			System.out.println("4. Transactions");
//			System.out.println("5. Checkings");
//			System.out.println("6. Savings");
//			System.out.println("7. Exit BankApplication");
//			try {
//				choose=Integer.parseInt(userinput.nextLine());
//			}catch(NumberFormatException e){
//				
//			}
//			switch(choose) {
//			case 1:
//				System.out.println("Our General Information provides the following : ");
//				break;
//			case 2:	
//				System.out.println("Please select what kind of bank account you want to open : ");
//				break;
//			case 3:
//				System.out.println("Look at your latest emails and personal alerts ");
//				break;
//			case 4:
//				System.out.println("Please select what kind of transaction you are making today : ");
//				break;
//			case 5:
//				System.out.println("Checking account");
//				break;
//			case 6:
//				System.out.println("Savings account");
//				break;
//			case 7:
//				System.out.println("Thank you for visiting, please come again soon! have a nice day!");
//				break;
//			
//			default:
//				System.out.println("Invalid menu option, please try again!");
//				break;
//			}
//			}while (choose!=7);
//		
//		case 2: 
//			System.out.println("Please enter your username and password :");
//			//return customers information: balance account and last transaction
//			break;
//		case 3:
//			System.out.println("Thank you for visiting the Revature Banking app, please come again soon! have a nice day!");
//			}
//			}while(option!=3);
//	  }
	}
}