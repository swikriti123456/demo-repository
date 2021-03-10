package com.demo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.beans.Employee;
import com.demo.springmvc.dao.EmployeeDao;
@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployee() {		
		return employeeDao.findAll();
	}

	@Override
	public Employee getGetEmployeeById(int eid) {		
		return employeeDao.findById(eid);
	}

	@Override
	public List<Employee> getGetEmployeeByName(String name) {		
		return null;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}
	
	

}
