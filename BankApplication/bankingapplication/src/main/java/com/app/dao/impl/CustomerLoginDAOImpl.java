package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.CustomerLoginDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.CustomerLogin;

public class CustomerLoginDAOImpl implements CustomerLoginDAO{

	Logger log = Logger.getLogger(BankAppMain.class);

	
	@Override
	public int createCustomerLogin(CustomerLogin customerlogin) {
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="insert into bankingapplication.customerlogin(username, password)  values  (?, ?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, customerlogin.getUsername());
			preparedStatement.setString(2, customerlogin.getPassword());
			z = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			
		}
		
		return z;
	}

	@Override
	public int accountReference(int accountid) {
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			
			
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		
		return z;
	}

	
//	@Override
//	public CustomerLogin createUsername(String username) {
//		CustomerLogin customerlogin = null;
//		try(Connection connection = PostgresqlConnection.getConnection()){
//			String sql ="insert into bankingapplication.customerlogin(username)  values  (?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			
//			preparedStatement.setString(2, username);
//			preparedStatement.executeUpdate();
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//		}
//		return customerlogin;
//	}
//
//	@Override
//	public CustomerLogin createPassword(String password) {
//		CustomerLogin customerlogin = null;
//		try(Connection connection = PostgresqlConnection.getConnection()){
//			String sql ="insert into bankingapplication.customerlogin(password)  values  (?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			
//			preparedStatement.setString(1, password);
//			preparedStatement.executeUpdate();
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//		}
//		return null;
//	}

	@Override
	public CustomerLogin CreateUsername(String username) {
		CustomerLogin customerlogin = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="insert into bankingapplication.customerlogin(username)  values  (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(2, username);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return customerlogin;
	}

	@Override
	public CustomerLogin CreatePassword(String password) {
		CustomerLogin customerlogin = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="insert into bankingapplication.customerlogin(password)  values  (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, password);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return null;
	}
	
	
}
