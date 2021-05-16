package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	Logger log = Logger.getLogger(BankAppMain.class);
	
	@Override
	public List<Customer> getCustomerById(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long createCustomer( Customer customer) throws BusinessException {
		long z=0;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(id, firstname, middlename, lastname, dateofbirth, customeraddress, city, state, gender, emailaddress) values (?,?,?,?,?::date,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getFirstname());
			preparedStatement.setString(3, customer.getMiddlename());
			preparedStatement.setString(4, customer.getLastname());
			preparedStatement.setString(5, customer.getDateofbirth());
			preparedStatement.setString(6, customer.getCustomeraddress());
			preparedStatement.setString(7, customer.getCity());
			preparedStatement.setString(8, customer.getState());
			preparedStatement.setString(9, customer.getGender());
			preparedStatement.setString(10, customer.getEmailaddress());
			
			z = preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}

	@Override
	public int getCustomerID() throws BusinessException {
		int customerid = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select id from bankingapplication.customer order by id desc limit 1";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
					
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				customerid = resultset.getInt("id");
			}else {
				throw new BusinessException("Customer ID is not found!");
			}		
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return customerid;
	}

	@Override
	public int setDelete(int account_id) throws BusinessException {
		int z = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "delete from bankingapplication.customer where account_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, account_id);
			
			z = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}

	
}


