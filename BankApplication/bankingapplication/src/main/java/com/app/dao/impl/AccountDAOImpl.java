package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public Account createAccountType(String accounttype) throws BusinessException{
		int w = 0;
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.account(accounttype) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, accounttype);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		} 
		return account;
	}
		
	@Override
	public int getDateOfCreatedAccount(String opendate) throws BusinessException {
		int z=0;
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "insert into bankingapplication.account(opendate) values (?::date)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setString(1, opendate);
		
		} catch ( ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}

	@Override
	public Account getViewAccountBalance(int accountid) throws BusinessException {
		int z =0;
		Account account = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "select bankingapplication.account() where accountid = ?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, accountid);
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return account;
	}
	
	@Override
	public List<Account> getAccountBalanceByAccountId(int accid) {
		
		return null;
	}
}
