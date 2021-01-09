package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int z=0;

		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(accountid, customerid, firstname, middlename, lastname, dateofbirth, customeraddress, city, state, zipcode, emailaddress, phonenumber, ssn, gender) values (?,?,?,?,?,?::date,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			
			preparedStatement.setInt(1, customer.getAccountid());
			preparedStatement.setInt(2, customer.getCustomerid());
			preparedStatement.setString(3, customer.getFirstname());
			preparedStatement.setString(4, customer.getMiddlename());
			preparedStatement.setString(5, customer.getLastname());
			preparedStatement.setString(6, customer.getDateofbirth());
			preparedStatement.setString(7, customer.getCustomeraddress());
			preparedStatement.setString(8, customer.getCity());
			preparedStatement.setString(9, customer.getState());
			preparedStatement.setInt(10, customer.getZipcode());
			preparedStatement.setString(11, customer.getEmailaddress());
			preparedStatement.setInt(12, customer.getPhonenumber());
			preparedStatement.setInt(13, customer.getSsn());
			preparedStatement.setString(14, customer.getGender());
			
			z = preparedStatement.executeUpdate();
			
			
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return z;
	}

	@Override
	public int deleteCustomer(int customerid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getCustomerById(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}