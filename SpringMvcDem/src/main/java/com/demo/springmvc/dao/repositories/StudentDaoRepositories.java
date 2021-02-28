package com.demo.springmvc.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.beans.Student;

@Repository
public interface StudentDaoRepositories extends JpaRepository<Student, Integer> {

}
