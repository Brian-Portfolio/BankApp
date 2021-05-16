package com.app.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.model.CustomerLogin;
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
		
		//Scanner input
		Scanner userinput = new Scanner(System.in);
		
		//switch case options
		int choose = 0;
		int choose1 = 0;
		int choose2 = 0;
		int option = 0;
		
		//Customer id counter
		int counter = customerservice.getCustomerID();
		
		//random account IDs generated
		Random rand = new Random();
		
		//random transaction IDs generated
		Random transactionrandnum = new Random();
	
		
		log.info("Welcome To The Banking Application");
		log.info("-------------------------------------");
		
		do {
			log.info("\n\n               MAIN MENU");
			log.info("-------------------------------------------");
			log.info("1. New Customer? Want To Open An Account?");
			log.info("2. Returning Customer's? Please Login.");
			log.info("3. Employees Only");
			log.info("4. Exit Application");
			
			try {
				log.info("\nPlease enter your choice : ");
				option=Integer.parseInt(userinput.nextLine());
			}catch(NumberFormatException e) {
			}
			
			if (option == 1) {
				counter = counter +1;
			}
			
			switch (option) {
			case 1:
				
				do {
					log.info("\nProcedures For New Customers Will Be In The Following Listed Below.");
					log.info("------------------------------------------------------------------------");
					log.info("1. Enter General Information");
					log.info("2. Open New Accounts");
					log.info("3. Create Username And Password Login");
					log.info("4. Deposit Starting Balance");
					log.info("5. Exit Instructions");
					try {
						choose = 1;
					}catch(NumberFormatException e){
					}
					int randnum = rand.nextInt(10000);
					int randtrans = transactionrandnum.nextInt(10000);

					switch(choose) {
					
						case 1:	
							choose = 2;
							int customerverify = 0;
	
							while(customerverify!=1) {
								log.info("\nPlease enter FirstName : ");
								String firstname = userinput.nextLine();
							
								log.info("Please enter MiddleName : ");
								String middlename = userinput.nextLine();
							
								log.info("Please enter LastName : ");
								String lastname = userinput.nextLine();
							
								log.info("Please enter Date Of Birth e.g.[YYYY-MM-DD] : ");
								String dob = userinput.nextLine();
							
								log.info("Please enter Customer Address e.g. 123 parkland Rd : ");
								String address = userinput.nextLine();
							
								log.info("Please enter City : ");
								String city = userinput.nextLine();
							
								log.info("Please enter State Initials : ");
								String state = userinput.nextLine();
							
								log.info("Please enter Gender : ");
								String gender = userinput.nextLine();
							
								log.info("Please enter your email-address : ");
								String emailaddress = userinput.nextLine();
							
								Customer customer =  new Customer(counter, firstname, middlename, lastname, dob, address, city, state, emailaddress, gender);
							
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
							
						case 2:
						
							int accountverify = 0;
							while(accountverify != 1 ) {
							
								String currentstatus = "pending";
								int startbalance = Integer.parseInt("0");
								log.info("\nWould you like to open a checking or saving account? ");
								String accounttype = userinput.nextLine().toLowerCase();
							
								Account account = new Account(randnum, startbalance, counter, accounttype, formatter.format(date), formatter.format(date), currentstatus);
								try {
									if (accountservice.createAccount(account)!=0) {
										log.info("Your account id is: "+randnum);
										log.info("account created sucessfully");
										choose = 3;
										accountverify = 1;
									}	
								}catch(BusinessException e){
									log.info(e.getMessage());
								}
							}
							
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
						
						case 4:
						
							int verifytransaction = 0;
							while(verifytransaction != 1) {
								String deposit = "deposit";
								String status = "NA";
								
								try {
									log.info("\nPlease make a minimum deposit of at least $50 for your starting balance : ");
									int transactionamount = Integer.parseInt(userinput.nextLine());
								
							
									Transaction transaction = new Transaction(randtrans, formatter.format(date), randnum, transactionamount, deposit, status);
								
							
									if (transactionservice.createTransaction(transaction)!=0) {
										choose = 5;
										verifytransaction = 1;
										log.info("transaction created successfully");
									}
									
									accountservice.updateAccountBalanceDeposit(transactionamount, randnum);
									
								}catch(NumberFormatException e) {
									log.info("Please only use numeric values for your deposit.");
								}catch(BusinessException e) {
									log.info(e.getMessage());
								}
							}
							
						case 5:
							log.info("\nCurrent application will be reviewed until approval from an employee.");
							log.info("\nThank you for submitting opening an account with us! Returning to Main Menu...\n");
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
					
					int accountid = 0;
					try {
						
						log.info("\nPlease enter your accountid for second authentication");
						accountid = Integer.parseInt(userinput.nextLine());
						accountverify = 1;
						accountservice.verifyAccountID(accountid);
						
						String approval = accountservice.checkAccountApproved(accountid);
						
						if (approval.equals("active")) {
							accountverify = 1;
						}else {
							accountverify = 0;
							log.info("Your account is still being reviewed, please wait until we finalize you account");
						}
						
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
						int randtrans = transactionrandnum.nextInt(10000);
	
						switch(choose1) {
					
							case 1:

								try {
									log.info("Your current account balance is : ");
									int accountbalance =accountservice.getViewAccountBalance(accountid);
									log.info(accountbalance);
								}catch(NumberFormatException e) {
									log.info("Account ID must be a numeric value and cannot be special characters or letters");
								}catch(BusinessException e) {
									log.info(e.getMessage());
								}
								break;
							
							case 2:
								String withdraw = "withdrawal";
								String status = "NA";
								
								try {
									log.info("How much would you like to withdrawal : ");
									int transactionwithdraw = Integer.parseInt(userinput.nextLine());
									
									Transaction transaction = new Transaction(randtrans, formatter.format(date), accountid, transactionwithdraw, withdraw, status);

									int currentbalance = accountservice.getViewAccountBalance(accountid);
									if (transactionwithdraw <=  currentbalance) {
										transactionservice.createWithdraw(transaction);
										accountservice.updateAccountBalanceWithdrawal(transactionwithdraw, accountid);
									}
									else {
										log.info("The withdrawal amount of " + transactionwithdraw + " is greater than your account balance. Please try again.");
									}
								}catch(NumberFormatException e) {
									log.info("Withdrawal must be a numeric value and cannot be special characters or letters"); 
								}catch(BusinessException e) {
									log.info(e.getMessage());
								}
								break;
								
							case 3:
								
								String deposit = "deposit";
								String nostatus = "NA";
								
								try {
									
									log.info("How much would you like to deposit : ");
									int transactiondeposit = Integer.parseInt(userinput.nextLine());
									
									Transaction transactiondepositamount = new Transaction(randtrans, formatter.format(date), accountid, transactiondeposit, deposit, nostatus);
									
									if (transactiondeposit>=0) {
									transactionservice.createDeposit(transactiondepositamount);
									accountservice.updateAccountBalanceDeposit(transactiondeposit, accountid);
									}
									else {
										log.info("Your deposit is not acceptable!");
									}
								}catch(NumberFormatException e) {
									log.info("Deposit must be a numeric value and cannot be special characters or letters"); 
								}catch(BusinessException e) {
									log.info(e.getMessage());
								}
								break;
								
							case 4:
								log.info("Would you like to transfer money to another account? Enter 1 for yes, 2 for no.\n");
								int yes=0;
								try{
									yes = Integer.parseInt(userinput.nextLine());
								}catch(NumberFormatException e) {
									log.info("Please type in 1 for yes or 2 for no.");
								}
								while(yes!=1 || yes!=2) {
								try {
									
								if (yes == 1) {

									String withdrawtransfer = "withdrawal";
									String deposittransfer = "deposit";
									String pendingstatus = "pending";
									String nostatus1 = "NA";
									
									try {
										log.info("Please enter which account you would like to transfer too?\n ");
										int id = Integer.parseInt(userinput.nextLine());
										
										log.info("Please enter the amount you will be transferring? ");
										int moneytransfer = Integer.parseInt(userinput.nextLine());
										
										Transaction withdrawtransaction = new Transaction(randtrans, formatter.format(date), accountid, moneytransfer, withdrawtransfer, nostatus1);
										
										int randtrans_deposit = transactionrandnum.nextInt(10000);
										
										Transaction deposittransaction = new Transaction(randtrans_deposit, formatter.format(date), id, moneytransfer, deposittransfer, pendingstatus);
										
										transactionservice.createWithdraw(withdrawtransaction);
										accountservice.updateAccountBalanceWithdrawal(moneytransfer, accountid);
										
										transactionservice.createDeposit(deposittransaction);
										log.info("Transfer status is pending, please wait until your transfer has been accepted.");
									
									}catch(NumberFormatException e) {
										log.info("Both id and money transfers must be numeric values only.");
									}catch(BusinessException e){
										log.info(e.getMessage());
									}
									
								}
								else if (yes == 2) {
									log.info("Redirecting back to accounts main menu...");
									break;
								}
								else {
									log.info("Invalid entry, please enter 1 or 2.");
								}
								}catch(NumberFormatException e) {
									log.info(e.getMessage());
								}
								break;
								}
								break;
								
							case 5:
								String transferstatus = "pending";
								int cout  = 0;
								int accept1 = 0;
								int reject1 = 0;
								
								try {
									List<Transaction> transactionlist = transactionservice.viewPendingPostTransactionLog(transferstatus, accountid);
									for(Transaction t:transactionlist) {
										log.info(t);
										cout++;
									}
									log.info("\nThere are "+cout+" transactions with pending status on your account");
								}catch(BusinessException e){
									log.info(e.getMessage());
								}
								
								while(cout>0) {

									int tid = 0;
									String eval_status1 = "";
									
									try {
										
										log.info("\nPlease select which transactionid you will be evaluating?");
										tid = Integer.parseInt(userinput.nextLine());
										
										log.info("Would you like to accept money from another account? Enter accept or reject.");
										eval_status1 = userinput.nextLine();
										
										accept1 = 1;
										reject1 = 1;
										cout--;
										transactionservice.acceptRejectTransaction(eval_status1, tid);
		
									}catch(NumberFormatException e) {
										log.info("Both id and money transfers must be numeric values only.");
									}catch (BusinessException e) {
										log.info(e.getMessage());
									}
									
									if(reject1 == 1 && eval_status1.equals("reject")) {
										log.info("Rejected transaction will take 2 to 3 business days to process, money will be deposited back to original account");								
									}
									
									else if(accept1 == 1 && eval_status1.equals("accept")) {
										log.info("Accepted Transaction");
										int newtransaction = transactionservice.getTransactionAmount(tid);
										accountservice.updateAccountBalanceDeposit(newtransaction, accountid);
										
										}
									}
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
					String FirstNameInput = userinput.nextLine();
					
					log.info("\nPlease enter your lastname : ");
					String LastNameInput = userinput.nextLine();
					
					try {
						
						log.info("\nPlease enter your employee ID : ");
						int employID = Integer.parseInt(userinput.nextLine());
						
						employeeservice.getEmployee(FirstNameInput, LastNameInput, employID);
						employeelogin = 1;
					}catch (NumberFormatException e) {
						employeelogin = 0;
						log.info("Employee ID must be a numeric value and cannot be special characters or letters");
					}catch(BusinessException e) {
						employeelogin = 0;
						log.info(e.getMessage());
				    }
					
					if (employeelogin == 1) {
					do {
						log.info("\nEMPLOYEE MENU");
						log.info("-----------------------------------");
						log.info("1. Approve/Reject Account");
						log.info("2. View Customers Acount");
						log.info("3. Register For Customer Account");
						log.info("4. View All Transaction Logs");
						log.info("5. Reimbursements For Rejected Transactions");
						log.info("6. Exit Employee Menu");
						try {
							log.info("Enter your choice : ");
							choose2=Integer.parseInt(userinput.nextLine());
						}catch(NumberFormatException e) {
							log.info(e.getMessage());
						}
						
						switch(choose2) {
						case 1:
							String currentstatus = "pending";
							int count = 0;
							int reject = 0;
							int accept = 0;
							
							try {
								List<Account> accountlist = accountservice.checkAccountStatus(currentstatus);
								for(Account a:accountlist) {
									log.info(a);
									count++;
								}
								log.info("There are "+count+" accounts pending.");
							}catch(NumberFormatException e) {
								log.info(e.getMessage());
							}catch(BusinessException e){
								log.info(e.getMessage());
							}
							
							 
							while (count>0) {
	
								String eval_status = "";
								int ID = 0;
								try {
									
									log.info("\nPlease enter which accountid you will be evaluating");
									ID = Integer.parseInt(userinput.nextLine());
									
									log.info("Please set account as active or reject");
									eval_status = userinput.nextLine();
									
									accountservice.setApproveRejectStatus(eval_status, ID);
									reject = 1;
									accept = 1;
									count--;
								}catch(NumberFormatException e) {
									log.info("Account ID cannot be numeric values and cannot be special character or letters.");
								}catch (BusinessException e) {
									log.info(e.getMessage());
								}
								
								if (reject == 1 && eval_status.equals("reject")){
									log.info("Rejected applications will be deleted!");
									customerservice.setDelete(ID);
									accountservice.setDelete(ID);
									customerloginservice.setDelete(ID);
									transactionservice.setDelete(ID);
									
								}
								else if (accept == 1 && eval_status.equals("accept")) {
									log.info("Active applications will be processed!");
								}
							}
							break;
							
						case 2:

							int viewid = 0;
							try {
								
								log.info("Please enter customer's account ID to view account information.");
								viewid = Integer.parseInt(userinput.nextLine());
								
								List<Account> accountidlist = accountservice.viewAccountId(viewid);
								for(Account a: accountidlist) {
									log.info(a);
								}
							}catch(NumberFormatException e) {
								log.info("Account ID must be a numeric value.");
							}catch (BusinessException e) {
								log.info(e.getMessage());
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

							int viewtransaction = 0;
							
							try {
								log.info("Please enter customer's account ID to view transaction information.");
								viewtransaction = Integer.parseInt(userinput.nextLine());
								
								List<Transaction> transactionlist = transactionservice.viewTransactionLog(viewtransaction);
								for(Transaction t:transactionlist) {	
									log.info(t);
								}
								
							}catch(NumberFormatException e) {
								log.info("id and money transfers must be in numeric value only.");
							}catch(BusinessException e){
								log.info(e.getMessage());
							}
							
							break;
							
						case 5:
							String rejecttransaction = "reject";
							int countrejectnumber = 0;
							
							try {
								List<Transaction> transactionlist = transactionservice.checkRejectTransaction(rejecttransaction);
								for(Transaction t:transactionlist) {
									log.info(t);
									countrejectnumber++;
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							
							int accountid1 = 0;
							int reimbursement = 0; 
							
							while(countrejectnumber>0) {
								
								try {
									log.info("\nRejected transactions should be redeposited to original account. Will be deleted once it processes.");
									
									log.info("\nPlease enter original account id for reimbursement");
									accountid1 = Integer.parseInt(userinput.nextLine());
									
									log.info("\nPlease enter the original amount to be deposited");
									reimbursement = Integer.parseInt(userinput.nextLine());
									
									accountservice.updateAccountBalanceDeposit(reimbursement, accountid1);
									
									countrejectnumber--;
								
								}catch(NumberFormatException e) {
									log.info("Both account id and reimbursement amount must be numeric values");
								}catch(BusinessException e) {
									log.info(e.getMessage());
								}
							}
							
						case 6:
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
