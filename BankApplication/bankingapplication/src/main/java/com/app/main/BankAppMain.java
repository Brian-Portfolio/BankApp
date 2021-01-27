package com.app.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

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
import com.app.service.EmployeeService;
import com.app.service.TransactionService;
import com.app.services.impl.AccountServiceImpl;
import com.app.services.impl.CustomerLoginServiceImpl;
import com.app.services.impl.CustomerServiceImpl;
import com.app.services.impl.EmployeeServiceImpl;
import com.app.services.impl.TransactionServiceImpl;

public class BankAppMain {

	public static void main(String[] args) throws BusinessException {
		
		//Date Format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		formatter.format(date);
		
		//Log object to display to Console
		Logger log = Logger.getLogger(BankAppMain.class);
		
		//Service layer objects
		CustomerService customerservice = new CustomerServiceImpl();
		AccountService accountservice = new AccountServiceImpl();
		CustomerLoginService customerloginservice = new CustomerLoginServiceImpl();
		TransactionService transactionservice = new TransactionServiceImpl();
		EmployeeService employeeservice = new EmployeeServiceImpl();
		
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
		
		//switch case options
		int choose = 0;
		int choose1 = 0;
		int choose2 = 0;
		int option = 0;
		
		//Counters for customer
		int counter = 0;
		
		//account generated IDs
		Random rand = new Random();
		int randnum = rand.nextInt(10000);
		
		//transaction generated IDs
		Random transactionrandnum = new Random();
		int randtrans = transactionrandnum.nextInt(1000);
		String num = "0000"+randtrans;
		int num1 = Integer.parseInt(num);
		
		
		log.info("Welcome and thank you for choosing The Banking Application");
		log.info("--------------------------------------------------------------------");
		
		do {
			log.info("MAIN MENU");
			log.info("--------------------------------------------");
			log.info("1. New Customer? Want To Open An Account");
			log.info("2. Returning Customer? Please Login ");
			log.info("3. Employees Only");
			log.info("4. Exit Application");
			try {
				log.info("Enter your choice : ");
				option=Integer.parseInt(userinput.nextLine());
			}catch(NumberFormatException e) {
				log.info(e.getMessage());
			}
			
			if (option == 1) {
				counter = counter +1;
			}
			switch (option) {
			case 1:
				
				do {
					log.info("\nPlease Follow New Account Instructions");
					log.info("------------------------------------------");
					log.info("1. Enter General Information");
					log.info("2. Open New Accounts");
					log.info("3. Create Username And Password Login");
					log.info("4. Deposit Starting Balance");
					log.info("5. Exit Instructions");
					try {
						choose = 1;
					}catch(NumberFormatException e){
						log.info(e.getMessage());
					}
					
					switch(choose) {
					case 1:
						choose = 2;
						int customerverify = 0;
						//int i = Integer.parseInt("0");
//						try {
//							int i = Integer.parseInt("0");
//							customerservice.getCustomerID(i);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
						
						while(customerverify!=1) {
						log.info("\nPlease enter FirstName : ");
						String firstname = userinput.nextLine();
						
						log.info("Please enter MiddleName : ");
						String middlename = userinput.nextLine();
						
						log.info("Please enter LastName : ");
						String lastname = userinput.nextLine();
						
						log.info("Please enter Date Of Birth [YYYY-MM-DD] : ");
						String dob = userinput.nextLine();
						
						log.info("Please enter Customer Address : ");
						String address = userinput.nextLine();
						
						log.info("Please enter City : ");
						String city = userinput.nextLine();
						
						log.info("Please enter State Initials: ");
						String state = userinput.nextLine();
						
						log.info("Please enter Gender : ");
						String gender = userinput.nextLine();
						
						log.info("Please enter your email address : ");
						String emailaddress = userinput.nextLine();
						
						Customer customer =  new Customer(counter, firstname, middlename, lastname, dob, address, city, state, gender, emailaddress);
						
						try {
							if (customerservice.createCustomer(customer)!=0) {
								log.info("Customer created sucessfully");
								customerverify = 1;
								choose = 2;
						}	
						} catch(BusinessException e){
							log.info(e.getMessage());
							log.info("Please re-enter the invalid information correctly");
						}
						}
						
//						try {
//							customerservice.getCustomerID(i);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
						//try {
//							customerservice.getCustomerID(counter);
//							accountservice.getAccountID(randnum, counter);
//							customerloginservice.CustomerloginID(counter1, randnum);
//							transactionservice.getTransactionID(num1, randnum);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//					    
//						
//					    try {
//							log.info("\nPlease enter FirstName : ");
//							String firstname = userinput.nextLine();
//							 customerservice.getCustomerFirstName(firstname, counter);
//						}catch(NumberFormatException e){
//							log.info("Name cannot be special characters or symbols");	
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//					    
//					    
//						try {
//							log.info("Please enter MiddleName : ");
//						String middlename = userinput.nextLine();
//						customerservice.getCustomerMiddleName(middlename, counter);
//						}catch(NumberFormatException e){
//							log.info("Name cannot be special characters or symbols");
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//											
//						try {
//							log.info("Please enter LastName : ");
//						String lastname = userinput.nextLine();
//						customerservice.getCustomerLastName(lastname, counter);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						try {
//							log.info("Please enter Date Of Birth [YYYY-MM-DD] : ");
//						String dob = userinput.nextLine();
//						customerservice.getCustomerDOB(dob, counter);
//						}catch(NumberFormatException e){
//							log.info("Name cannot be special characters or symbols");
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						
//						try {
//							log.info("Please enter Customer Address : ");
//						String address = userinput.nextLine();
//						customerservice.getCustomerAddress(address, counter);
//						}catch(NumberFormatException e){
//							log.info("Name cannot be special characters or symbols, or numeric values");
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						
//						try {
//							log.info("Please enter City : ");
//						String city = userinput.nextLine();
//						 customerservice.getCustomerCity(city, counter);
//						}catch(NumberFormatException e){
//							log.info("Name cannot be special characters or symbols, or numeric values");
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						try {
//							log.info("Please enter State Initials: ");
//						String state = userinput.nextLine();
//						customerservice.getCustomerState(state, counter);
//						}catch(NumberFormatException e){
//							log.info("Name cannot be special characters or symbols, or numeric values");
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						try {
//							log.info("Please enter Gender : ");
//						String gender = userinput.nextLine();
//						customerservice.getCustomerGender(gender, counter);
//						}catch(NumberFormatException e){
//							log.info("Name cannot be special characters or symbols, or numeric values");
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
						//choose = 2;
						
					
					case 2:
						
						int accountverify = 0;
						
						while(accountverify != 1) {
						int startbalance = Integer.parseInt("0");
						log.info("\nWould you like to open a checking or saving account? ");
						String accounttype = userinput.nextLine().toLowerCase();
						
						Account account = new Account(randnum, startbalance,  counter, accounttype, formatter.format(date), formatter.format(date));
						try {
							if (accountservice.createAccount(account)!=0) {
								log.info("account created sucessfully");
								choose = 3;
								accountverify = 1;
							}	
						}catch(BusinessException e){
							log.info(e.getMessage());
						}
						}
						//try {
//							String accounttype = userinput.nextLine();
//							accountservice.createAccountType(accounttype, counter );
//						}catch(BusinessException e){
//							log.info(e.getMessage());
//						}
//						
//						try {
//							accountservice.setAccountBalance(startbalance, counter);
//						}catch(BusinessException e){
//							log.info(e.getMessage());
//						}
//						
//						try {
//							accountservice.getDateOfCreatedAccount(formatter.format(date), counter);
//						}catch(BusinessException e){
//							log.info(e.getMessage());
//						}
						//choose = 3;
						
						
//					case 3:
//						log.info("\nPlease enter your email address: ");
//						try {
//							String email = userinput.nextLine();
//							customerservice.getCustomerEmailAddress(email, counter);
//						}catch(PatternSyntaxException e) {
//							log.info(e.getMessage());
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						choose = 4;
						
						
					case 3:
						int verifylogin = 0;
						
						while(verifylogin !=1) {
						log.info("\nPlease create your username with at least one uppercase, one lowercase, one digit, one special character and a minimum of 8 characters : ");
						String username = userinput.nextLine();
						
						log.info("Please create your password with at least one uppercase, one lowercase, one digit, one special character and a minimum of 8 characters : ");
						String password = userinput.nextLine();
						
						CustomerLogin customerlogin = new CustomerLogin(counter, randnum, username, password);
						
						try {
							if(customerloginservice.createCustomerLogin(customerlogin)!=0) {
								log.info("customerlogin created successfully");
								verifylogin = 1;
								choose = 4;
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						}
						
						//try {
//							String username = userinput.nextLine();
//							customerloginservice.CreateUsername(username, counter);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						log.info("Please create your password with at least one uppercase, one lowercase, one digit, one special character and a minimum of 8 characters : ");
//						try {
//							String password = userinput.nextLine();
//							customerloginservice.CreatePassword(password, counter);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
						//choose = 4;
						
					
					case 4:
						
						int verifytransaction = 0;
						
						while(verifytransaction != 1) {
						log.info("\nPlease make a minimum deposit of at least $50 for your starting balance : ");
						int transactionamount = Integer.parseInt(userinput.nextLine());
						String deposit = "deposit";
						
						Transaction transaction = new Transaction(num1, formatter.format(date), randnum, transactionamount, deposit);
						
						try {
							if (transactionservice.createTransaction(transaction)!=0) {
								log.info("transaction created successfully");
								choose = 5;
								verifytransaction = 1;
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
						try {	
							accountservice.updateAccountBalanceDeposit(transactionamount, counter);
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						}
						
						
//						try {
//							transactionservice.createTransactionAmount(transactionamount, num1);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						try {
//						String deposit = "deposit";
//						transactionservice.createTransactionType(deposit, num1);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						try {	
//							transactionservice.createTransactionDate(formatter.format(date), num1);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
//						
//						try {	
//							accountservice.updateAccountBalanceDeposit(transactionamount, counter);
//						}catch(BusinessException e) {
//							log.info(e.getMessage());
//						}
						
						//choose = 5;
						
					case 5:
						log.info("Thank you for submitting your opening an account with us! Returning to Main Menu...\n");
						break;
					
					default:
						log.info("Invalid menu option, please try again!");
						break;
					
					}
				}while (choose!=5);
				break;
				
				
			case 2:
				int verify = 0;
				int accountverify = 0;
				
				log.info("\nPlease enter your username and password for verification");
				
				log.info("\nusername : ");
				String usernameinput = userinput.nextLine();
				
				
				log.info("\npassword : ");
				String passwordinput = userinput.nextLine();
				try {
					customerloginservice.verifyCustomerLogin(usernameinput, passwordinput);
					verify = 1;
				}catch(BusinessException e) {
					log.info(e.getMessage());
					verify = 0;
				}
				
				log.info("\nPlease enter your accountid for second authentication");
				int accountid = Integer.parseInt(userinput.nextLine());
				try {
					accountverify = 1;
					accountservice.verifyAccountID(accountid);
				}catch (NumberFormatException e) {
					log.info("Account ID must be a numeric value and cannot be special characters or letters");
					accountverify = 0;
				}
				catch (BusinessException e) {
					log.info(e.getMessage());
					accountverify=0;
				}
				
				
				if (verify == 1 && accountverify == 1) {
				do {
					log.info("\nCUSTOMER MENU OPTIONS");
					log.info("--------------------------------");
					log.info("1. View Account Balance");
					log.info("2. Withdrawal");
					log.info("3. Deposit");
					log.info("4. Post Transaction Transfer");
					log.info("5. Accept Transaction Transfer");
					log.info("6. Exit Menu");
					try {
						log.info("Please select an option : \n");
						choose1=Integer.parseInt(userinput.nextLine());
					}catch(NumberFormatException e) {
						log.info(e.getMessage());
					}
					switch(choose1) {
					case 1:
						log.info("Your current account balance is : ");
						try {
							int accountbalance =accountservice.getViewAccountBalance(accountid);
							log.info(accountbalance);
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						break;
					
					case 2:
						log.info("How much would you like to withdrawal : ");
						int transactionwithdraw = Integer.parseInt(userinput.nextLine());
						String withdraw = "withdrawal";
						Transaction transaction = new Transaction(num1, formatter.format(date), accountid, transactionwithdraw, withdraw );
//						try {
//							if(	transactionservice.createWithdraw(transaction)!=0) {
//								log.info("transaction created sucessfully");
//							}
//						}catch(BusinessException e){
//							log.info(e.getMessage());
//						}
							
						try {
							int currentbalance = accountservice.getViewAccountBalance(accountid);
							if (transactionwithdraw <=  currentbalance) {
								transactionservice.createWithdraw(transaction);
								accountservice.updateAccountBalanceWithdrawal(transactionwithdraw, accountid);
							}
							else {
								log.info("The withdrawal amount of " + transactionwithdraw + " not acceptable. Please check again.");
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						break;
						
					case 3:
						log.info("How much would you like to deposit : ");
						int transactiondeposit = Integer.parseInt(userinput.nextLine());
						String deposit = "deposit";
						Transaction transactiondepositamount = new Transaction(num1, formatter.format(date), accountid, transactiondeposit, deposit);
						
//						try {
//							if(	transactionservice.createDeposit(transactiondepositamount)!=0) {
//								log.info("transaction created sucessfully");
//							}
//						}catch(BusinessException e){
//							log.info(e.getMessage());
//						}
						
						try {	
							if (transactiondeposit>=0) {
							transactionservice.createDeposit(transactiondepositamount);
							accountservice.updateAccountBalanceDeposit(transactiondeposit, accountid);
							}
							else {
								log.info("Your desposit is not acceptable!");
							}
						}catch(BusinessException e) {
							log.info(e.getMessage());
						}
						
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
				}
				break;
				
			
			case 3:
				int employeelogin = 0;
				log.info("\nPlease enter your first, last name, followed by your employeee ID for verification!");
				
				log.info("\nPlease enter your firstname : ");
				String FirstName = userinput.nextLine().toLowerCase();
				
				log.info("\nPlease enter your lastname : ");
				String LastName = userinput.nextLine().toLowerCase();
				
				log.info("\nPlease enter your employee ID : ");
				int employID = Integer.parseInt(userinput.nextLine()); 
				
				try {
					employeeservice.getEmployee(FirstName, LastName, employID);
					employeelogin = 1;
				}catch (NumberFormatException e) {
					employeelogin = 0;
					log.info("Account ID must be a numeric value and cannot be special characters or letters");
				}catch(BusinessException e) {
					employeelogin = 0;
					log.info(e.getMessage());
				}
				
				if (employeelogin == 1) {
				do {
					log.info("\nEMPLOYEE MENU");
					log.info("-----------------");
					log.info("1. Approve/Reject Account");
					log.info("2. View Customers Acount");
					log.info("3. Register For Customer Account");
					log.info("4. View All Transaction Logs");
					log.info("5. Exit Employee Menu");
					try {
						log.info("Enter your choice : ");
						choose2=Integer.parseInt(userinput.nextLine());
					}catch(NumberFormatException e) {
						log.info(e.getMessage());
					}
					
					switch(choose2) {
					case 1:
						log.info("");
						
						break;
						
					case 2:
						log.info("Please enter customer's account ID to view account information.");
						int viewid = Integer.parseInt(userinput.nextLine());
						try {
							List<Account> accountidlist = accountservice.viewAccountId(viewid);
							for(Account a: accountidlist) {
								log.info(a);
							}
						}catch (BusinessException e) {
							log.info(e.getMessage());;
						}
						break;
						
					case 3:
						log.info("Would you like to apply for a customer account? Please enter 1 for Yes or 2 for No?");
						int apply = 0;
						while(apply!=1 || apply!=2) {
						try {			
							int answer = Integer.parseInt(userinput.nextLine());
						if (answer == 1) {
							apply = 1;
							log.info("You will be redirected back to the main menu and please select option number 1 for new customers application login.");
							option = 1;
							choose2 = 5;
							break;
						}
						else if (answer == 2) {
							apply = 2;
							log.info("Redirected back to Employee menu..");
							break;
						}
						else {
							log.info("Invalid entry, please enter 1 or 2.");
						}
						}catch(NumberFormatException e) {
							log.info(e.getMessage());
						}
						}
						break;
						
					case 4:
						log.info("Please enter customer's account ID to view transaction information.");
						int viewtransaction = Integer.parseInt(userinput.nextLine());
						
						try {
							List<Transaction> transactionlist = transactionservice.viewTransactionLog(viewtransaction);
							for(Transaction t:transactionlist) {	
								log.info(t);
							}
						}catch(BusinessException e){
							log.info(e.getMessage());
						}
						break;
						
					case 5:
						log.info("Thank you for visiting, please come again soon! have a nice day!");
						break;
						
				default:
					log.info("Invalid menu option, please try again!");
					break;
					}
				}while(choose2 != 5);
				}
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
