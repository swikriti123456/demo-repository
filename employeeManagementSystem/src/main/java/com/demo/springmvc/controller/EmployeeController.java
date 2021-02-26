package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springmvc.beans.Employee;
import com.demo.springmvc.service.EmployeeService;


public class EmployeeController 
{
	
	@Autowired
	EmployeeService employeeService;
	
	/*
	 * @RequestMapping("/employees") public String forShowEmployee() {
	 * List<Employee> elist= return "displayEmployees"; }
	 */
}
