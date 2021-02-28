package com.demo.springmvc.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.springmvc.beans.Student;
import com.demo.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/students")
	public String forStudentList(ModelMap map) {
		List<Student> slist = studentService.getAllStudent();

		map.addAttribute("slist", slist);
		return "displayStudent";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String forAddStudent(ModelMap map) {
		map.addAttribute("student", new Student());
		return "addStudent";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String forSaveStudent(@Valid @ModelAttribute Student student, BindingResult result, ModelMap map) {

		if (result.hasErrors()) {
			return "addStudent";
		}
		if (studentService.save(student) > 0) {
			return "redirect:students";
		}
		return "addStudent";
	}

	@RequestMapping(value = "/editStudent/{rollNo}", method = RequestMethod.GET)
	public String forEditStudent(@PathVariable("rollNo") int rollNo, ModelMap map) {
		map.addAttribute("student", studentService.getStudentByRollNo(rollNo));
		return "updateStudent";
	}

	@PostMapping("/editStudent/{rollNo}")
	public String forUpdateStudent(@PathVariable("rollNo") int rollNo, @Valid @ModelAttribute Student student,
			BindingResult result, ModelMap map) {

		if (result.hasErrors()) {
			return "updateStudent";
		}
		if (studentService.update(student) > 0) {
			return "redirect:/students";
		}
		return "updateStudent";
	}

	@RequestMapping(value = "/deleteStudent/{rollNo}", method = RequestMethod.GET)
	public String forDeleteStudent(@PathVariable int rollNo) {
		studentService.delete(rollNo);
		return "redirect:/students";
	}
	/* @RequestMapping(value="/api/students/{rollNo}",method=RequestMethod.GET) */

}
