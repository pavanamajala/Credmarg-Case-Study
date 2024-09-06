package com.credmarg.vendor.service;

import java.util.List;

import com.credmarg.vendor.entity.Employee;
import com.credmarg.vendor.exception.InvalidLengthException;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee) throws Exception;
	
	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeesByName(String id);

}
