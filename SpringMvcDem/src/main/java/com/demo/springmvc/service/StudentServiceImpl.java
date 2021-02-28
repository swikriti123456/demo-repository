package com.demo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.demo.springmvc.beans.Student;
import com.demo.springmvc.dao.StudentDao;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getAllStudent() {

		return studentDao.getAllStudent();
	}

	@Override
	public Student getStudentByRollNo(int id) {
		
		return studentDao.getStudentByRollNo(id);
	}

	@Override
	public int update(Student s) {
		
		return studentDao.update(s);
	}

	@Override
	public int delete(int id) {
		
		return studentDao.delete(id);
	}

	@Override
	public int save(Student s) {
		
		return studentDao.save(s);
	}

}
