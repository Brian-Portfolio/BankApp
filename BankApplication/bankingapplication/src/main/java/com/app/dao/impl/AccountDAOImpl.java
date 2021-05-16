package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.AccountDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.Account;


public class AccountDAOImpl implements AccountDAO{

	Logger log = Logger.getLogger(BankAppMain.class);
	
	@Override
	public int getViewAccountBalance(int account_id) throws BusinessException {
		int newbalance = 0; 
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select accountbalance from bankingapplication.account where account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				newbalance = resultset.getInt("accountbalance");
				
			}else {
				throw new BusinessException("Account ID is not found!");
			}
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return newbalance;
	}
	
	@Override
	public List<Account> viewAccountId(int account_id) throws BusinessException {
		List<Account> accountlist = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select accountbalance, accounttype, opendate, accounttodate, id from bankingapplication.account where account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Account account = new Account();
				account.setAccountbalance(resultset.getInt("accountbalance"));
				account.setAccounttype(resultset.getString("accounttype"));
				account.setOpendate(resultset.getString("opendate"));
				account.setAccounttodate(resultset.getString("accounttodate"));
				account.setId(resultset.getInt("id"));
				account.setAccountid(account_id);
				accountlist.add(account);
			}
			if(accountlist.size()==0)
			{
				throw new BusinessException("No account-id found by "+account_id);
			}
		
		}catch(ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return accountlist;
	}

	@Override
	public int updateAccountBalanceDeposit(int accountbalance, int account_id) throws BusinessException {
		int z =0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.account set accountbalance = accountbalance + ? where account_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, accountbalance);
			preparedStatement.setInt(2, account_id);
			z = preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return z;
	}

	@Override
	public Account verifyAccountID(int account_id) throws BusinessException {
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select account_id from bankingapplication.account where account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				account = new Account();
				account.setAccountid(account_id);
			}else {
				throw new BusinessException("AccountID is not Found!");
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return account;
	}


	@Override
	public int updateAccountBalanceWithdrawal(int accountbalance, int account_id) throws BusinessException {
		int z =0;
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "update bankingapplication.account set accountbalance = accountbalance - ? where  account_id = ? ";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, accountbalance);
		preparedStatement.setInt(2, account_id);
		
		z = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Interal error occurred contact SYSADMIN");
		}
		return z;
	}


	@Override
	public int createAccount(Account account) throws BusinessException {
		int z =0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.account(accountbalance, accounttype, opendate, accounttodate, id, account_id, status)values (?,?,?::date,?::date,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account.getAccountbalance());
			preparedStatement.setString(2, account.getAccounttype());
			preparedStatement.setString(3, account.getOpendate());
			preparedStatement.setString(4, account.getAccounttodate());
			preparedStatement.setInt(5, account.getId());
			preparedStatement.setInt(6, account.getAccountid());
			preparedStatement.setString(7, account.getStatus());
			
			z = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
		
	}

	@Override
	public List<Account> checkAccountStatus(String status) throws BusinessException {
		List<Account> accountlist = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select status, account_id from bankingapplication.account where status = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				Account accountlist1 = new Account();
				accountlist1.setStatus(status);
				accountlist1.setAccountid(resultset.getInt("account_id"));
				accountlist.add(accountlist1);
			}
			if(accountlist.size()==0)
			{
				throw new BusinessException("No account status is "+status);
			}
		
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return accountlist;
	}

	@Override
	public int setApproveRejectStatus(String status, int account_id) throws BusinessException {
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.account set status = ? where account_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, account_id);
			
			z = preparedStatement.executeUpdate();
		
		}catch (ClassNotFoundException | SQLException e) {
			
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}

	@Override
	public int setDelete(int account_id) throws BusinessException {
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "delete from bankingapplication.account where account_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account_id);
			
			z = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}


	@Override
	public Account verifyGeneratedRandomAccountID(int account_id) throws BusinessException {
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select account_id from bankingapplication.account where account_id != ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				account = new Account();
				account.setAccountid(account_id);
			}else {
				throw new BusinessException("AccountID is already being used!");
			}
			}catch (ClassNotFoundException | SQLException e) {
				log.info(e);
				throw new BusinessException("Internal error occurred contact SYSADMIN");
			}	
			return account;
		}


	@Override
	public String checkAccountApproved(int account_id) throws BusinessException{
		String approvedstatus = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select status from bankingapplication.account where account_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				approvedstatus = resultset.getString("status");
			}else {
				throw new BusinessException("Status is pending");
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		
		return approvedstatus;
	}
	
}
