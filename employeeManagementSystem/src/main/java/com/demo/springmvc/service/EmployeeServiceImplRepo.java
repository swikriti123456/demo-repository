package com.demo.springmvc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.beans.Employee;
import com.demo.springmvc.dao.repository.EmployeeRepository;

public class EmployeeServiceImplRepo implements EmployeeService
{	
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getGetEmployeeById(int eid) {
		
		return employeeRepository.findById(eid).get();
	}

	@Override
	public List<Employee> getGetEmployeeByName(String name) {
		//return employeeRepository.findAll().stream().filter(employee->employee.getFirstName().equals(name)).collect(Collectors.toList());
		return employeeRepository.findByFirstName(name);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee) ;
	}
	
	

}
