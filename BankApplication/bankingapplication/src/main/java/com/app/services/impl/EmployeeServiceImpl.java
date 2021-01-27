package com.app.services.impl;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Override
	public Employee getEmployee(String firstname, String lastname, int employeeid) throws BusinessException {
		Employee employee = null;
		if(firstname.matches("[a-zA-Z]{1,10}") && lastname.matches("[a-zA-Z]{1,10}") && employeeid!=0) {
			employee = employeeDAO.getEmployee(firstname, lastname, employeeid);
		}else {
			throw new BusinessException("Entered firstname, lastname, and employeeid is INVALID!");
		}
		return employee;
	}
}
