package com.demo.springBoot;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.springBoot.bean.Role;
import com.demo.springBoot.bean.RoleName;
import com.demo.springBoot.bean.User;
import com.demo.springBoot.repo.RoleDaoJpa;
import com.demo.springBoot.repo.UserDaoJpa;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner
{

	@Autowired
	UserDaoJpa userDaoJpa;
	
	@Autowired
	RoleDaoJpa roleDaoJpa;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(!roleDaoJpa.findByRoleName(RoleName.ADMIN).isPresent()) {
			roleDaoJpa.save(new Role(RoleName.ADMIN));
		}
		if(!roleDaoJpa.findByRoleName(RoleName.USER).isPresent()) {
			roleDaoJpa.save(new Role(RoleName.USER));
		}
		if(!userDaoJpa.findByEmail("admin@example.com").isPresent()){
			List<Role> roles=new LinkedList<>();
			Optional<Role> oRole=roleDaoJpa.findByRoleName(RoleName.ADMIN);
			if(oRole.isPresent()) {
				roles.add(oRole.get());
			}
			User user= new User();
			user.setEmail("admin@example.com");
			user.setPassword(passwordEncoder.encode("admin"));
			user.setEnabled(true);
			user.setRoles(roles);
			userDaoJpa.save(user);
		}
		
	}

}
