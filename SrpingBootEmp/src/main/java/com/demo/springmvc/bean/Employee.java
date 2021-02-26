package com.demo.springmvc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee
{
	@Id
	@GeneratedValue
	private int eid;
	private String firstName,lastName,gender,address,email;
}
