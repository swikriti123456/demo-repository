package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springmvc.bean.Employee;
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
	
	@PutMapping(value="/",produces="application/json")
	public String forUpdateEmployee(@RequestBody Employee e) {
		if(employeeService.updateEmployee(e) > 0) {
			return "message:- data updated successfully";
		}
		else {
			return "message:- invalid id";
		}
	}
	@DeleteMapping(value = "/id/{id}",produces = "application/json")
	public String forDeleteEmployee(@PathVariable int id)
	{
		if(employeeService.deleteEmployee(id) > 0) {
			return "message:- data deleted successfully";
		}
		else {
			return "message:- invalid id";
		}
	}
}

