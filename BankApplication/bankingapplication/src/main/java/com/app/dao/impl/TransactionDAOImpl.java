package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.apache.log4j.Logger;

import com.app.dao.TransactionDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	Logger log = Logger.getLogger(BankAppMain.class);

//	@Override
//	public int createTransactions(Transaction transaction) {
//		int z =0;
//		try (Connection connection = PostgresqlConnection.getConnection()){
//			String sql = "insert into bankingapplication.transaction(transactionid, transactiondate, accountid, transactionamount, transactiontype, customerid, totalbalance) values (?,?,?,?,?,?,?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			
//			preparedStatement.setInt(1, transaction.getTransactionid());
//			preparedStatement.setString(2, transaction.getTransactiondate());
//			preparedStatement.setInt(3, transaction.getAccountid());
//			preparedStatement.setInt(4, transaction.getTransactionamount());
//			preparedStatement.setString(5, transaction.getTransactiontype());
//			preparedStatement.setInt(6, transaction.getCustomerid());
//			preparedStatement.setInt(7, transaction.getTotalbalance());
//			z = preparedStatement.executeUpdate();
//			
//			
//		}catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//		}
//		
//		return z;
//	}
	
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

	public Transaction createWithdraw(int account_id, int transactionamount ,String transactiontype) {
		Transaction transaction = null;
	
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.transaction set transactionamount=?  where account_id=? and transactiontype =?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account_id);
			preparedStatement.setInt(2, transactionamount);
			preparedStatement.setString(3, transactiontype);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return transaction;
		
	}
		
	public Transaction createDeposit(int account_id, int transactionamount, String transactiontype) {
		Transaction transaction =null;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.transaction set transactionamount=? where account_id=? and transactiontype =?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account_id);
			preparedStatement.setInt(2, transactionamount);
			preparedStatement.setString(3, transactiontype);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return transaction;
		
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
}




