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
				account.setAccountbalance(resultset.getInt("account_id"));
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
//		if (z<=0) {
//			throw new BusinessException("The withdrawal amount of "+accountbalance+ " not acceptable. Please check again.");
//		}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Interal error occurred contact SYSADMIN");//The withdrawal amount of "+accountbalance+ " not acceptable. Please check again.");
		}
		return z;
	}


	@Override
	public int createAccount(Account account) throws BusinessException {
		int z =0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.account(accountbalance, accounttype, opendate, accounttodate, id, account_id) values (?,?,?::date,?::date,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account.getAccountbalance());
			preparedStatement.setString(2, account.getAccounttype());
			preparedStatement.setString(3, account.getOpendate());
			preparedStatement.setString(4, account.getAccounttodate());
			preparedStatement.setInt(5, account.getId());
			preparedStatement.setInt(6, account.getAccountid());
			
			z = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
		
	}
}
