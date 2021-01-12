package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public int getEmployee(Employee employee) {
		int z = 0;
		try (Connection connection = PostgresqlConnection.getConnection()){
		String sql = "insert into bankingapplication.employee(employeeid, firstname, lastname, accountid) values (?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, employee.getEmployeeid());
		preparedStatement.setString(2, employee.getFirstname());
		preparedStatement.setString(3, employee.getLastname());
		preparedStatement.setInt(4, employee.getAccountid());
		
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
		return 0;
	}

}