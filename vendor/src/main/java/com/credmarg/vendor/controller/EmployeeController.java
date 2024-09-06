package com.credmarg.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.vendor.entity.Employee;
import com.credmarg.vendor.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) throws Exception {
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok("Employee created successfully");
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    
    @GetMapping("/getByName/{id}")
    public  ResponseEntity<List<Employee>> getByname(@PathVariable String id) {
    	List<Employee> employees = employeeService.getEmployeesByName(id);
        return ResponseEntity.ok(employees);
    }
}
