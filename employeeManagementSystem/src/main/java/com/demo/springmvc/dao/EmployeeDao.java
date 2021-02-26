package com.demo.springmvc.dao;

import java.util.List;

import com.demo.springmvc.beans.Employee;

public interface EmployeeDao {
List<Employee> findAll();
Employee findById(int id);
int delete(int id);
int update(Employee e);
void save(Employee e);
}
