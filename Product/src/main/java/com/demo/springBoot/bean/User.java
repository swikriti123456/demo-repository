package com.demo.springBoot.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
@Entity
@Data
public class User 
{
	@Id
	@GeneratedValue
	@Column(name="u_id")
	private int uId;
	private String username;
	@Column(unique = true)
	private String email;
	private String password;
	private boolean enabled;
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
		joinColumns = @JoinColumn(name="u_id"),
		inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles=new ArrayList<>();
	
	
	public User(User user) {
		super();
		this.uId = user.uId;
		this.email = user.email;
		this.password = user.password;
		this.enabled = user.enabled;
		this.roles = user.roles;
	}


	public User() {
		
	}
	
	
}
