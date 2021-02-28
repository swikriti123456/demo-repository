package com.demo.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.beans.Student;

@Repository
public class StudentDaoImplJdbcTemplate implements StudentDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class StudentRowMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s=new Student();
			s.setRollNo(rs.getInt("rollNo"));
			s.setSname(rs.getString("sname"));
			s.setAge(rs.getInt("age"));
			return s;
		}
		
	}
	
	@Override
	public List<Student> getAllStudent() {
		
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}

	@Override
	public Student getStudentByRollNo(int id) {
		
		return jdbcTemplate.queryForObject("select * from student where rollNo=?", new Object[] {id},new StudentRowMapper());
	}

	@Override
	public int update(Student s) {
		
		return jdbcTemplate.update("update student set sname=?,age=? where rollNo=?",new Object[] {s.getSname(),s.getAge(),s.getRollNo()});
	}

	@Override
	public int delete(int id) {
		
		return jdbcTemplate.update("delete from student where rollNo=?",new Object[] {id});
	}

	@Override
	public int save(Student s) {
		
		return jdbcTemplate.update("insert into student(rollNo,sname,age) value(?,?,?)",new Object[] {s.getRollNo(),s.getSname(),s.getAge()});
	}

}
