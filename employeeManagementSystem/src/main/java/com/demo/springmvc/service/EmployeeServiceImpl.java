package com.demo.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.springmvc.dao.EmployeeDao;

public class EmployeeServiceImpl
{

	@Autowired
	EmployeeDao employeeDao;
	
	

}
