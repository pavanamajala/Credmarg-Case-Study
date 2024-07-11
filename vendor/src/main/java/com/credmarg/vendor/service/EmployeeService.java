package com.credmarg.vendor.service;

import java.util.List;

import com.credmarg.vendor.entity.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();

}
