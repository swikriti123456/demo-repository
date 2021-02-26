package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springmvc.beans.Employee;
import com.demo.springmvc.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestApiController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value="/",produces = "application/json")
	public List<Employee> forAllEmp(){
		return employeeService.getAllEmployee();
	}
	@GetMapping(value="/{id}",produces = "application/json")
	public Employee forGetEmployeeById(@PathVariable("id") int eid){
		return employeeService.getGetEmployeeById(eid);
	}
	@GetMapping(value="/name/{name}",produces = "application/json")
	public List<Employee> forGetEmployeeByName(@PathVariable("name") String name){
		return employeeService.getGetEmployeeByName(name);
	}
	@PostMapping(value="/",produces = "application/json",consumes = "application/json")
	public Employee forAddEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
}
