package com.demo.springmvc.service;

import java.util.List;

import com.demo.springmvc.bean.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee getGetEmployeeById(int eid);

	List<Employee> getGetEmployeeByName(String name);

	Employee addEmployee(Employee employee);

	int updateEmployee(Employee e);

	int deleteEmployee(int id);
	
}