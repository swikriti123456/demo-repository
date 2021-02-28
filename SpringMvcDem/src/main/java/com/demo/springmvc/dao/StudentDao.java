package com.demo.springmvc.dao;

import java.util.List;

import com.demo.springmvc.beans.Student;

public interface StudentDao {

	List<Student> getAllStudent();
	Student getStudentByRollNo(int id);
	int update(Student s);
	int delete(int id);
	int save(Student s);
}
