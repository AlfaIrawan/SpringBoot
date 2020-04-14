package edu.havrelearning.springboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.havrelearning.springboot.models.Student;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello")
	public String hello() {
		
		return "hello";
		
	}
	
	@RequestMapping(value = "/sendData")
	public ModelAndView sendData() {
		
		ModelAndView modelAndView = new ModelAndView("data");
		modelAndView.addObject("message", "Take up one idea and make it your life");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/student")
	public ModelAndView getStudent() {
		
		ModelAndView modelAndView = new ModelAndView("student");
		
		Student student = new Student();
		student.setName("Alfa");
		student.setScore(100);
		
		modelAndView.addObject("student", student);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/students")
	public ModelAndView getStudents() {
		
		ModelAndView modelAndView = new ModelAndView("studentList");
		
		Student student1 = new Student();
		student1.setName("Alfa");
		student1.setScore(100);
		
		Student student2 = new Student();
		student2.setName("Irawan");
		student2.setScore(80);
		
		List<Student> students = Arrays.asList(student1, student2);
		
		modelAndView.addObject("students", students);
		
		return modelAndView;
		
	}

}
