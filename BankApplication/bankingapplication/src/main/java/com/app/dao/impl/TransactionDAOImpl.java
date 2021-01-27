package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.TransactionDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	Logger log = Logger.getLogger(BankAppMain.class);

//	@Override
//	public int createTransaction(Transaction transaction) {
//		int z =0;
//		try (Connection connection = PostgresqlConnection.getConnection()){
//			String sql = "insert into bankingapplication.transaction(transactionid, transactiondate, accountid, transactionamount, transactiontype) values (?,?,?,?,?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			
//			preparedStatement.setInt(1, transaction.getTransaction_id());
//			preparedStatement.setString(2, transaction.getTransactiondate());
//			preparedStatement.setInt(3, transaction.getAccount_Id());
//			preparedStatement.setInt(4, transaction.getTransactionamount());
//			preparedStatement.setString(5, transaction.getTransactiontype());
//			preparedStatement.setInt(6, transaction.getTotalbalance());
//			z = preparedStatement.executeUpdate();	
//			
//		}catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//		}
//		return z;
//	}
//	
	@Override
	public Transaction createTransactionAmount(int transactionamount, int transaction_id) {
		Transaction transaction = null;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.transaction set transactionamount = ? where  transaction_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transactionamount);
			preparedStatement.setInt(2, transaction_id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		
		return transaction;
	}


	@Override
	public Transaction createTransactionType(String transactiontype, int transaction_id) {
		Transaction transaction = null;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.transaction set transactiontype = ? where  transaction_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, transactiontype);
			preparedStatement.setInt(2, transaction_id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return transaction;
	}



	@Override
	public Transaction createTransactionDate(String transactiondate, int transaction_id) {
		Transaction transaction = null;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.transaction set transactiondate = ?::date where  transaction_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, transactiondate);
			preparedStatement.setInt(2, transaction_id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return transaction;
	}
	
	@Override
	public int createWithdraw(Transaction transaction) throws BusinessException{
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.transaction(account_id, transactionamount, transactiontype, transaction_id, transactiondate) values(?,?,?,?,?::date)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transaction.getAccount_Id());
			preparedStatement.setInt(2, transaction.getTransactionamount());
			preparedStatement.setString(3, transaction.getTransactiontype());
			preparedStatement.setInt(4, transaction.getTransaction_id());
			preparedStatement.setString(5, transaction.getTransactiondate());
			
			z = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}
		
	@Override
	public int createDeposit(Transaction transaction) throws BusinessException {
		int z =0;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.transaction(account_id, transactionamount, transactiontype, transaction_id, transactiondate) values(?,?,?,?,?::date)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transaction.getAccount_Id());
			preparedStatement.setInt(2, transaction.getTransactionamount());
			preparedStatement.setString(3, transaction.getTransactiontype());
			preparedStatement.setInt(4, transaction.getTransaction_id());
			preparedStatement.setString(5, transaction.getTransactiondate());
			z = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}


	@Override
	public Transaction getTransactionID(int transaction_id, int account_id) throws BusinessException {
		Transaction transaction = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.transaction(transaction_id, account_id) values (?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transaction_id);
			preparedStatement.setInt(2, account_id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		} 
		return transaction;
	}


	@Override
	public int createTransaction(Transaction transaction) throws BusinessException {
		int z =0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.transaction(transactiondate, transactionamount, transactiontype, transaction_id, account_id) values (?::date,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, transaction.getTransactiondate());
			preparedStatement.setInt(2, transaction.getTransactionamount());
			preparedStatement.setString(3, transaction.getTransactiontype());
			preparedStatement.setInt(4, transaction.getTransaction_id());
			preparedStatement.setInt(5, transaction.getAccount_Id());
			
			z = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}


	@Override
	public List<Transaction> viewTransactionLog(int account_id) throws BusinessException {
		List<Transaction> transactionlist = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select transactionamount, transactiontype, transactiondate, transaction_id from bankingapplication.transaction where account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Transaction transaction = new Transaction();
				transaction.setTransactionamount(resultset.getInt("transactionamount"));
				transaction.setTransactiontype(resultset.getString("transactiontype"));
				transaction.setTransactiondate(resultset.getString("transactiondate"));
				transaction.setTransaction_id(resultset.getInt("transaction_id"));
				transaction.setAccount_Id(account_id);
				transactionlist.add(transaction);
			}
			if(transactionlist.size()==0) {
				throw new BusinessException("No account-id found by "+account_id);
			}
		}catch(ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		
		
		return transactionlist;
	}
}