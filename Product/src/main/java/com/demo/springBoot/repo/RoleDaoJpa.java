package com.demo.springBoot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springBoot.bean.Role;
import com.demo.springBoot.bean.RoleName;
@Repository
public interface RoleDaoJpa extends JpaRepository<Role,Integer>
{
	Optional<Role> findByRoleName(RoleName roleName);
}
