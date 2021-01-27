package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	Logger log = Logger.getLogger(BankAppMain.class);
	
//	@Override
//	public int createCustomer(Customer customer) throws BusinessException {
//		int z=0;
//
//		try(Connection connection = PostgresqlConnection.getConnection()){
//			String sql = "insert into bankingapplication.customer( customerid, firstname, middlename, lastname, dateofbirth, customeraddress, city, state, zipcode, emailaddress, phonenumber, ssn, gender) values (?,?,?,?,?::date,?,?,?,?,?,?,?,?)";
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//
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
	public Customer getCustomerFirstName(String firstname, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set firstname = ? where  id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, firstname);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
		return customer;
	}


	@Override
	public Customer getCustomerMiddleName(String middlename, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set middlename = ? where  id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, middlename);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}


	@Override
	public Customer getCustomerLastName(String lastname, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set lastname = ? where  id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, lastname);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}


	@Override
	public Customer getCustomerEmailAddress(String emailaddress, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set emailaddress = ? where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, emailaddress);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}


	@Override
	public Customer getCustomerCity(String city, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set city = ? where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, city);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}

	@Override
	public Customer getCustomerState(String state, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set state = ? where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, state);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}

	@Override
	public Customer getCustomerGender(String gender, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set gender = ? where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, gender);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
		
	}


	@Override
	public Customer getCustomerAddress(String customeraddress, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set customeraddress = ? where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, customeraddress);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}
			
		return customer;
	}
	
	
	@Override
	public Customer getCustomerDOB(String dateofbirth, int id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set dateofbirth = ?::date where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, dateofbirth);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return customer;
	}


	@Override
	public long createCustomer( Customer customer)//String firstname, String middlename, String lastname, String city,
			//String state, String gender, String customeraddress, String dateofbirth)
		throws BusinessException {
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
	public Customer getCustomerID(int id) throws BusinessException {
		
		Customer customer = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "update bankingapplication.customer set id = id + 1 where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error occurred contact SYSADMIN");
		}	
		return customer;
	}

	
}


