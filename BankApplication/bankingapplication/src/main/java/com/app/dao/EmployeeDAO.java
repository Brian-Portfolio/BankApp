package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployee(String firstname, String lastname, int employeeid) throws BusinessException;
	 
}
