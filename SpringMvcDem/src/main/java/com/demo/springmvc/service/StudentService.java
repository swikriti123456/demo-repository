package com.demo.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.demo.springmvc.beans.Student;

public interface StudentService {

	List<Student> getAllStudent();
	Student getStudentByRollNo(int id);
	int update(Student s);
	int delete(int id);
	int save(Student s);
}
