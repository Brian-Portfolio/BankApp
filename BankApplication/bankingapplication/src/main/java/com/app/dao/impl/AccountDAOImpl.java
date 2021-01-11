package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.app.dao.AccountDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Account;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public int createAccount(Account account) throws BusinessException {
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql="insert into bankingapplication.account(accountid, accountbalance, accountinterests, customerid, accounttype, opendate, accounttodate) values (?,?,?,?,?,?::date,?::date)";	
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, account.getAccountid());
		preparedStatement.setInt(2, account.getAccountbalance());
		preparedStatement.setInt(3, account.getAccountinterests());
		preparedStatement.setInt(4, account.getCustomerid());
		preparedStatement.setString(5, account.getAccounttype());
		preparedStatement.setString(6, account.getOpendate());
		preparedStatement.setString(7, account.getAccounttodate());
		z = preparedStatement.executeUpdate();
		
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		
		return z;
}
	
	@Override
	public String createAccountType(String accounttype) throws BusinessException{
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.account(accounttype) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, accounttype);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		} 
		return accounttype;
	}
		
	@Override
	public String getDateOfCreatedAccount(String opendate) throws BusinessException {
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "insert into bankingapplication.account(opendate) values (?::date)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setString(1, opendate);
		
		} catch ( ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return opendate;
	}

	@Override
	public int getUpdateAccountBalance(int accountbalance, int accountid) throws BusinessException {
		int z =0;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
		String sql = "update bankingapplication.account set accountbalance = ? where accountid = ?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, accountbalance);
		preparedStatement.setInt(2, accountid);
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}
	
	@Override
	public List<Account> getAccountBalanceByAccountId(int accountid) {
		
		return null;
	}

	@Override
	public int createaccountReference(int accountid) {
		int z =0;
		return z;
	}

}
