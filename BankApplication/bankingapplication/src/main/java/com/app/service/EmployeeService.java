package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(String firstname, String lastname, int employeeid) throws BusinessException;
	
}
