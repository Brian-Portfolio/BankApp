package com.app.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.AccountDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.CustomerLoginDAO;
import com.app.dao.TransactionDAO;
import com.app.dao.impl.AccountDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.TransactionDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.model.CustomerLogin;
import com.app.model.Employee;
import com.app.model.Transaction;
import com.app.service.AccountService;
import com.app.service.CustomerLoginService;
import com.app.service.CustomerService;
import com.app.service.TransactionService;
import com.app.services.impl.AccountServiceImpl;
import com.app.services.impl.CustomerLoginServiceImpl;
import com.app.services.impl.CustomerServiceImpl;
import com.app.services.impl.TransactionServiceImpl;

public class BankAppMain {

	public static void main(String[] args) throws BusinessException {
		
		//Date Format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		formatter.format(date);
		
		//Log object to display to Console
		Logger log = Logger.getLogger(BankAppMain.class);
		
		//Service layer objects
		CustomerService customerservice = new CustomerServiceImpl();
		AccountService accountservice = new AccountServiceImpl();
		CustomerLoginService customerloginservice = new CustomerLoginServiceImpl();
		TransactionService transactionservice = new TransactionServiceImpl();
		
		//DAO objects
		CustomerDAO dao = new CustomerDAOImpl(); 
		CustomerLoginDAO daologin = new CustomerLoginDAOImpl();  
		AccountDAO accountdao = new AccountDAOImpl();
		TransactionDAO transactiondao = new TransactionDAOImpl();
		
		//Referenced objects 
		Customer c1 = new Customer();
		CustomerLogin c2 = new CustomerLogin();
		Account a1 = new Account();
		Transaction t1 = new Transaction();
		Employee e1 = new Employee();
		
		//Scanner input
		Scanner userinput = new Scanner(System.in);
		
		int choose = 0;
		int choose1 = 0;
		int choose2 = 0;
		int option = 0;
		log.info("Welcome and thank you for choosing the Revature Banking Application");
		log.info("--------------------------------------------------------------------");
		
		do {
			log.info("1. New Customer? Want To Open An Account");
			log.info("2. Returning Customer? ");
			log.info("3. Employees Only");
			log.info("4. Exit Application");
			try {
				log.info("Enter your choice : ");
				option=Integer.parseInt(userinput.nextLine());
			}catch(NumberFormatException e) {
				
			}
			switch (option) {
			case 1:
				do {
					log.info("\nOpening New Account Instructions");
					log.info("-----------------------------");
					log.info("1. Enter General Information");
					log.info("2. Open New Accounts");
					log.info("3. Enter Email Address For Updates and Alerts");
					log.info("4. Create Username And Password Login");
					log.info("5. Deposit Starting Balance");
					log.info("6. Exit Instructions");
					try {
						choose=Integer.parseInt(userinput.nextLine());
					}catch(NumberFormatException e){
						
					}
					switch(choose) {
					case 1:
									
					    try {
							log.info("\nPlease enter FirstName : ");
							String firstname = userinput.nextLine();
							Customer customer = customerservice.getCustomerFirstName(firstname);
						}catch(NumberFormatException e){
							log.info("Name cannot be special characters or symbols");	
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
					    
					    
						try {
							log.info("Please enter MiddleName : ");
						String middlename = userinput.nextLine();
						Customer customer = customerservice.getCustomerMiddleName(middlename);
						}catch(NumberFormatException e){
							log.info("Name cannot be special characters or symbols");
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
											
						try {
							log.info("Please enter LastName : ");
						String lastname = userinput.nextLine();
						Customer customer = customerservice.getCustomerLastName(lastname);
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						try {
							log.info("Please enter Date Of Birth : ");
						String dob = userinput.nextLine();
						Customer customer = customerservice.getCustomerDOB(dob);
						}catch(NumberFormatException e){
							log.info("Name cannot be special characters or symbols");
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						
						try {
							log.info("Please enter Customer Address : ");
						String address = userinput.nextLine();
						Customer customer = customerservice.getCustomerAddress(address);
						}catch(NumberFormatException e){
							log.info("Name cannot be special characters or symbols, or numeric values");
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						
						try {
							log.info("Please enter City : ");
						String city = userinput.nextLine();
						Customer customer4 = customerservice.getCustomerCity(city);
						}catch(NumberFormatException e){
							log.info("Name cannot be special characters or symbols, or numeric values");
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						try {
							log.info("Please enter State : ");
						String state = userinput.nextLine();
						Customer customer = customerservice.getCustomerState(state);
						}catch(NumberFormatException e){
							log.info("Name cannot be special characters or symbols, or numeric values");
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						try {
							log.info("Please enter Gender : ");
						String gender = userinput.nextLine();
						Customer customer = customerservice.getCustomerGender(gender);
						}catch(NumberFormatException e){
							log.info("Name cannot be special characters or symbols, or numeric values");
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						
						break;
					
					case 2:	
						
						log.info("Would you like to open a checking or savings account? ");
						try {
							String accounttype = userinput.nextLine();
							if (accounttype == "checking" || accounttype == "saving") {
								Account account = accountservice.createAccountType(accounttype);
							}
						}catch(BusinessException e){
							log.info(e.getMessage());
						}
						break;
						
					case 3:
						log.info("Please enter your email address: ");
						try {
							String email = userinput.nextLine();
							Customer customer1 = customerservice.getCustomerEmailAddress(email);
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						break;
					case 4:
						log.info("Please create your username with at least one uppercase, one lowercase, one digit, one special character and a minimum of 8 characters : ");
						try {
							String username = userinput.nextLine();
							CustomerLogin customerlogin = customerloginservice.CreateUsername(username);
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						log.info("Please create your password with at least one uppercase, one lowercase, one digit, one special character and a minimum of 8 characters : ");
						try {
							String password = userinput.nextLine();
							CustomerLogin customerlogin = customerloginservice.CreatePassword(password);
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						break;
					case 5:
						//transaction = deposit
						//deposit = account balance of checking or saving account
						
						log.info("Please make a minimum deposit of at least $25 for your starting balance : ");
						try {
							log.info("\nDepositing... ");
							int transactionamount = userinput.nextInt();
							Transaction transaction = transactionservice.createTransactionAmount(transactionamount);
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						try {	
							log.info("This is date and time of your transaction : " + formatter.format(date));
							Transaction transaction = transactionservice.createTransactionDate(formatter.format(date));
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						break;
					case 6:
						log.info("Thank you for submitting your application! Returning to Main Menu...");
						break;
					
					default:
						log.info("Invalid menu option, please try again!");
						break;
					
					}
				}while (choose!=6);
				break;
				
				
			case 2:
				log.info("Please enter your username : ");
				log.info("Please enter your password : ");
				
//				//check for correct username and password 
//				//successfully logged in
				do {
					log.info("MENU");
					log.info("-------");
					log.info("1. View Account Balance");
					log.info("2. Withdrawal");
					log.info("3. Deposit");
					log.info("4. Post Transaction Transfer");
					log.info("5. Accept Transaction Transfer");
					log.info("6. Exit Menu");
					try {
						log.info("Enter your choice : ");
						choose1=Integer.parseInt(userinput.nextLine());
					}catch(NumberFormatException e) {
						
					}
					switch(choose1) {
					case 1:
						//address name and account id
						log.info("Your current account balance is : ");
						
						break;
					case 2:
						log.info("How much would you like to withdrawal : ");
						
						break;
					case 3:
						log.info("How much would you like to deposit : ");
						
						break;
					case 4:
						log.info("");
						break;
					case 5:
						log.info("");
						break;
					case 6:
						log.info("Thank you for visiting, please come again soon! have a nice day!");
						break;
					default:
						log.info("Invalid menu option, please try again!");
						break;
					}
				}while(choose1 != 6);
				break;
	
			case 3:
				log.info("Welcome Employee");
				
				do {
					log.info("1. Approve/Reject Account");
					log.info("2. View Customers Acount");
					log.info("3. Register For Customer Account");
					log.info("4. View All Transaction Logs");
					log.info("5. Exit Employee Menu");
					try {
						log.info("Enter your choice : ");
						choose2=Integer.parseInt(userinput.nextLine());
					}catch(NumberFormatException e) {
						
					}
					switch(choose2) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
				default:
					log.info("Invalid menu option, please try again!");
					break;
					}
				}while(choose2 != 5);
				break;
						
			case 4:
				log.info("Thank you for visiting, please come again soon! have a nice day!");
				break;
			default:
				log.info("Invalid menu option, please try again!");
				break;
			}		
		}while(option!=4);
	}
}		
