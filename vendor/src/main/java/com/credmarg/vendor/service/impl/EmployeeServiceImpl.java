package com.credmarg.vendor.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.credmarg.vendor.entity.Employee;
import com.credmarg.vendor.exception.InvalidLengthException;
import com.credmarg.vendor.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private List<Employee> employeesList = new ArrayList<>();

	@Override
	public void saveEmployee(Employee employee) throws Exception {
		if(employee.getEmail().length() < 2 || employee.getCTC() < 1000 || employee.getName().length() < 2 || employee.getDesignation().length() < 2) {
			throw new InvalidLengthException("Length should be more than 1");
		} else {
			if(employee.getEmail().length() < 3) throw new IllegalArgumentException("Email length must be at least 3 characters.");
			else employeesList.add(employee);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		employeesList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		return employeesList;
	}

	@Override
	public List<Employee> getEmployeesByName(String id) {
		employeesList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		return employeesList.stream().filter(e -> e.getName().contains(id)).collect(Collectors.toList());
	}


}
