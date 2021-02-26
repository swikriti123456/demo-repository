package com.demo.springmvc.service;

import java.util.List;

import com.demo.springmvc.beans.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee getGetEmployeeById(int eid);

	List<Employee> getGetEmployeeByName(String name);

	Employee addEmployee(Employee employee);
	
}
