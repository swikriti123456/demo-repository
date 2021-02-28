package com.demo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.bean.Employee;
import com.demo.springmvc.repo.EmployeeRepository;

@Service
public class EmployeeServiceImplRepo implements EmployeeService
{

	@Autowired
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
		/*
		 * int age; employeeRepository.findByAgeLessThan(age);
		 */
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee) ;
	}

	@Override
	public int updateEmployee(Employee e) {
		/*
		 * Employee e1=employeeRepository.findById(e.getEid()).get();
		 * 
		 * e1.setFirstName(e.getFirstName()); e1.setLastName(e.getLastName());
		 * e1.setGender(e.getGender()); e1.setEmail(e.getEmail());
		 * e1.setAddress(e.getAddress());
		 */
		return employeeRepository.save(e).getEid();
	}

	@Override
	public int deleteEmployee(int id) {
		
		employeeRepository.deleteById(id);
		return 1;
	}
	
	

}
