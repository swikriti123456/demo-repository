package com.demo.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.demo.springmvc.beans.Student;
import com.demo.springmvc.dao.repositories.StudentDaoRepositories;
@Service
@Primary
public class StudentServiceImplByJpaRepositories implements StudentService
{
	@Autowired
	StudentDaoRepositories studentDaoRepositories;

	@Override
	public List<Student> getAllStudent() {
		
		return studentDaoRepositories.findAll();
	}

	@Override
	public Student getStudentByRollNo(int id) {
		
		return studentDaoRepositories.findById(id).get();
	}

	@Override
	public int update(Student s) {
		
		return studentDaoRepositories.save(s).getRollNo();
	}

	@Override
	public int delete(int id) {
		
		studentDaoRepositories.deleteById(id);
		return 1;
	}

	@Override
	public int save(Student s) {
		
		return studentDaoRepositories.save(s).getRollNo();
	}

}
