package com.demo.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.beans.Employee;

@Repository
public class EmployeeDaoImplByHibernate implements EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Employee> findAll() {

		return sessionFactory.getCurrentSession().createQuery("From Employee", Employee.class).list();
	}

	@Override
	public Employee findById(int id) {

		return sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		if (employee != null) {
			session.delete(employee);
			return 1;
		}
		return 0;
	}

	@Override
	public int update(Employee e) {
		sessionFactory.getCurrentSession().update(e);
		return 1;
	}

	@Override
	public void save(Employee e) {
		sessionFactory.getCurrentSession().save(e);

	}

}
