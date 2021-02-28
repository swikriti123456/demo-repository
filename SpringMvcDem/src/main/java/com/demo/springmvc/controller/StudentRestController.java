package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springmvc.beans.Student;
import com.demo.springmvc.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value="/{rollNo}",produces="application/json")
	public Student forStudentByRollNo(@PathVariable("rollNo") int rollNo) {
		return studentService.getStudentByRollNo(rollNo);
	}

	@GetMapping(value="/",produces="application/json")
	public List<Student> forAllStudent() {
		return studentService.getAllStudent();
	}

	@DeleteMapping(value="/{rollNo}",produces="application/json")
	public String forDeleteStudent(@PathVariable int rollNo) {
		if (studentService.delete(rollNo) > 0) {
			return "data deleted successfully";
		}
		return "invalid rollno";
	}

	@PostMapping(value="/",produces="application/json",consumes="application/json")
	public String forAddStudent(@RequestBody Student student) {
		if(studentService.save(student) > 0) {
			return "{'message' :'Adding Student info Successfully' }";
		}
		return "{'message' : 'please check credential'}";
	}

	@PutMapping(value="/",produces="application/json",consumes="application/json")
	public String forUpdateStudent(@RequestBody Student student) {
		if(studentService.update(student) > 0) {
			return "{'message' :'data updated Successfully' }";
		}
		return "{'message' : 'please check credential'}";
	}
}
