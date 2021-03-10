package com.demo.springBoot.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.springBoot.bean.User;
import com.demo.springBoot.repo.UserDaoJpa;
@Service
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	UserDaoJpa userDaoJpa;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> oUser=userDaoJpa.findByEmail(username);
		if(!oUser.isPresent()) {
			throw new UsernameNotFoundException(username+" not found");
		}
		return oUser.map(CustomUserDetails::new).orElse(null);
	}

}
