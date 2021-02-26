package com.demo.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.springmvc.beans.Employee;

public class EmployeeDaoImplByJdbcTemplate implements EmployeeDao
{
@Autowired
JdbcTemplate jdbcTemplate;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e=new Employee();
		e.setEid(rs.getInt("eid"));
		e.setFirstName(rs.getString("firstName"));
		e.setLastName(rs.getString("lastName"));
		e.setGender(rs.getString("gender"));
		e.setEmail(rs.getString("email"));
		e.setAddress(rs.getString("address"));
		return e;
	}
	
}

	@Override
	public List<Employee> findAll() {
		
		return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());
	}

	@Override
	public Employee findById(int id) {
		
		return jdbcTemplate.queryForObject("select * from employees where eid=?", new Object[] {id}, new EmployeeRowMapper());
	}

	@Override
	public int delete(int id) {
		
		return jdbcTemplate.update("delete from employees where eid=?",new Object[] {id},new EmployeeRowMapper());
	}

	@Override
	public int update(Employee e) {
		
		return jdbcTemplate.update("update employees set firstName=?,lastName=?,email=?,address=?,gender=? where eid=?",new Object[] {e.getFirstName(),e.getLastName(),e.getEmail(),e.getAddress(),e.getGender(),e.getEid()});
	}

	@Override
	public void save(Employee e) {
		 jdbcTemplate.update("insert into employees(eid,firstName,lastName,email,address,gender) value(?,?,?,?,?,?)",new Object[] {e.getEid(),e.getFirstName(),e.getLastName(),e.getEmail(),e.getAddress(),e.getGender()});
	
	}

}
