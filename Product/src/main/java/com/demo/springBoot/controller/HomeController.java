package com.demo.springBoot.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springBoot.bean.Role;
import com.demo.springBoot.bean.RoleName;
import com.demo.springBoot.bean.User;
import com.demo.springBoot.repo.RoleDaoJpa;
import com.demo.springBoot.repo.UserDaoJpa;
@Controller
public class HomeController implements CommandLineRunner{
	
	@Autowired
	UserDaoJpa userDaoJpa;
	
	@Autowired
	RoleDaoJpa roleDaoJpa;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String forHome() {
	
		return "home";
	}
	@RequestMapping(value="/signIn",method=RequestMethod.GET)
	public String forLogin() {
	
		return "login";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String forRegister(ModelMap map) {
		map.addAttribute("command", new User());
		return "registration";
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(!roleDaoJpa.findByRoleName(RoleName.USER).isPresent()) {
			roleDaoJpa.save(new Role(RoleName.USER));
		}
		if(!userDaoJpa.findByEmail(@PathParam("email")).isPresent()){
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
	