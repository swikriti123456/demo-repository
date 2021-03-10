package com.demo.springBoot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springBoot.bean.User;
@Repository
public interface UserDaoJpa extends JpaRepository<User,Integer>
{
	Optional<User> findByEmail(String email);
}
