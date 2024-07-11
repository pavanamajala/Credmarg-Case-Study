package com.credmarg.vendor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.credmarg.vendor.entity.Employee;
import com.credmarg.vendor.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private List<Employee> employeesList = new ArrayList<>();

	@Override
	public void saveEmployee(Employee employee) {
		employeesList.add(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeesList;
	}

}
