package com.demo.springmvc.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.beans.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByFirstName(String name);
	List<Employee> findByFirstNameAndLastName(String fName,String lName);

}
