package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.main.BankAppMain;
import com.app.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	Logger log = Logger.getLogger(BankAppMain.class);

	
	@Override
	public Employee getEmployee(String firstname, String lastname, int employeeid) throws BusinessException {
		Employee employee1 = null;
		
		try (Connection connection = PostgresqlConnection.getConnection()){
		String sql = "select firstname, lastname, employeeid from bankingapplication.employee where firstname = ? and lastname = ? and employeeid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, firstname);
		preparedStatement.setString(2, lastname);
		preparedStatement.setInt(3, employeeid);
		ResultSet resultset = preparedStatement.executeQuery();
		if(resultset.next()) {
			employee1 = new Employee();
			employee1.setFirstname(firstname);
			employee1.setLastname(lastname);
			employee1.setEmployeeid(employeeid);
			employee1.setFirstname(resultset.getString("firstname"));
			employee1.setLastname(resultset.getString("lastname"));
			employee1.setEmployeeid(resultset.getInt("employeeid"));
		}else {
				throw new BusinessException("Invalid credentials!");
		}
		}catch (ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("Internal error ocurred contact SYSADMIN");
		}
		return employee1;
	}

}
