package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String sql ="insert into bankingapplication.customerlogin(username, password, account_id, loginid)  values  (?, ?, ?, ?) ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, customerlogin.getUsername());
			preparedStatement.setString(2, customerlogin.getPassword());
			preparedStatement.setInt(3, customerlogin.getAccount_id());
			preparedStatement.setInt(4, customerlogin.getLoginid());
			z = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);	
		}
		return z;
	}

	@Override
	public CustomerLogin verifyCustomerLogin(String username, String password) throws BusinessException {
		CustomerLogin customerlogin = null;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select username, password from bankingapplication.customerlogin where username = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				customerlogin = new CustomerLogin();
				customerlogin.setUsername(username);
				customerlogin.setPassword(password);
				customerlogin.setUsername(resultset.getString("username"));
				customerlogin.setPassword(resultset.getString("password"));
			}else {
				throw new BusinessException("username and password do not match!");
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return customerlogin;
	}

	@Override
	public int setDelete(int account_id) throws BusinessException {
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "delete from bankingapplication.customerlogin where account_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account_id);
			
			z = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}
	
	
}
