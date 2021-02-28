package com.demo.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springmvc.beans.Student;

@Repository
@Primary
@Transactional // this ids wrong bcs mainly we write it in service
public class StudentDaoImplHibernate implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Student> getAllStudent() {

		return sessionFactory.getCurrentSession().createQuery("from Student", Student.class).list();
	}

	@Override
	public Student getStudentByRollNo(int id) {

		return sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public int update(Student s) {

		sessionFactory.getCurrentSession().update(s);
		return 1;
	}

	@Override
	public int delete(int id) {
		Session session=sessionFactory.getCurrentSession();
		Student student=session.get(Student.class, id);
		session.delete(student);
		
			return 1;
	}

	@Override
	public int save(Student s) {
		sessionFactory.getCurrentSession().save(s);
		return 1;
	}

}
