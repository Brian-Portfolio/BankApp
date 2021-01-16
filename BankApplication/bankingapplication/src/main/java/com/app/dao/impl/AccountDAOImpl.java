package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.AccountDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.Account;
import com.app.model.CustomerLogin;


public class AccountDAOImpl implements AccountDAO{

	Logger log = Logger.getLogger(BankAppMain.class);
	
	@Override
	public Account createAccountType(String accounttype, int id) throws BusinessException{
		
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.account set accounttype = ? where  id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, accounttype);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		} 
		return account;
	}
		
	@Override
	public Account getDateOfCreatedAccount(String opendate, int id) throws BusinessException {
		
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "update bankingapplication.account set opendate = ?::date where id = ?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setString(1, opendate);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();

		} catch ( ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return account;
	}

	@Override
	//query
	public Account getViewAccountBalance(int account_id) throws BusinessException {
		Account account = null;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select accountbalance  from customerlogin where username = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				account = new Account();
				account.setAccountid(account_id);
				account.setAccountbalance(resultset.getInt("accountbalance"));
				
			}else {
				throw new BusinessException("username and password do not match!");
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return account;
	}
	
	@Override
	public List<Account> getAccountBalanceByAccountId(int accid) {
		
		return null;
	}

	@Override
	public Account getAccountID(int account_id, int id) throws BusinessException {
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "insert into bankingapplication.account(account_id, id) values (?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, account_id);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return account;
	}

	@Override
	public Account updateAccountBalanceDeposit(int accountbalance, int id) throws BusinessException {
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.account set accountbalance = accountbalance + ? where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, accountbalance);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return account;
	}

	@Override
	public Account setAccountBalance(int accountbalance, int id) throws BusinessException {
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "update bankingapplication.account set accountbalance = ? where  id = ?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, accountbalance);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return account;
	}

	

}
