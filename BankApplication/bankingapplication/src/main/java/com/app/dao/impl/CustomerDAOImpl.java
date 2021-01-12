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

//	@Override
//	public int createCustomer(Customer customer) throws BusinessException {
//		int z=0;
//
//		try(Connection connection = PostgresqlConnection.getConnection()){
//			String sql = "insert into bankingapplication.customer( customerid, firstname, middlename, lastname, dateofbirth, customeraddress, city, state, zipcode, emailaddress, phonenumber, ssn, gender) values (?,?,?,?,?::date,?,?,?,?,?,?,?,?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//
//			//preparedStatement.setInt(1, customer.getAccountid());
//			preparedStatement.setInt(1, customer.getCustomerid());
//			preparedStatement.setString(2, customer.getFirstname());
//			preparedStatement.setString(3, customer.getMiddlename());
//			preparedStatement.setString(4, customer.getLastname());
//			preparedStatement.setString(5, customer.getDateofbirth());
//			preparedStatement.setString(6, customer.getCustomeraddress());
//			preparedStatement.setString(7, customer.getCity());
//			preparedStatement.setString(8, customer.getState());
//			preparedStatement.setInt(9,customer.getZipcode());
//			preparedStatement.setString(10, customer.getEmailaddress());
//			preparedStatement.setInt(11, customer.getPhonenumber());
//			preparedStatement.setInt(12, customer.getSsn());
//			preparedStatement.setString(13, customer.getGender());
//			
//			z = preparedStatement.executeUpdate();
//			
//			
//		}catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//			throw new BusinessException("Internal error occurred contact SYSADMIN");
//		}
//		return z;
//	}

	
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
	public Customer getCustomerFirstName(String firstname) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(firstname) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, firstname);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return customer;
	}


	@Override
	public Customer getCustomerMiddleName(String middlename) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(middlename) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, middlename);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}


	@Override
	public Customer getCustomerLastName(String lastname) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(lastname) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, lastname);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}


	@Override
	public Customer getCustomerEmailAddress(String emailaddress) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update into bankingapplication.customer(emailaddress) values (?) where customerid = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, emailaddress);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}


	@Override
	public Customer getCustomerCity(String city) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(city) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, city);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}

	@Override
	public Customer getCustomerState(String state) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(state) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, state);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}

	@Override
	public Customer getCustomerGender(String gender) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(gender) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, gender);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
		
	}


	@Override
	public Customer getCustomerAddress(String customeraddress) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(customeraddress) values (?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, customeraddress);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}
	
	
	@Override
	public Customer getCustomerDOB(String dateofbirth) throws BusinessException {
		Customer customer = null;
		int c = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankingapplication.customer(dateofbirth) values (?::date)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, dateofbirth);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return customer;
	}

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public Customer getCustomerId(int customerid) throws BusinessException {
//		Customer customer = null;
//		int c = 0;
//		try(Connection connection = PostgresqlConnection.getConnection()){
//			String sql = "create sequence my_serial as integer start 1 owned by bankingapplication.customer(customerid);"
//					+ "alter table customer alter column customerid set default nextval('my_serial')";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			preparedStatement.execute();
//		
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//			throw new BusinessException("Internal error occurred contact SYSADMIN");
//		}
//			
//		return customer;
//}
}
