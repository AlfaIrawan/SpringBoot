package edu.havrelearning.springboot.controllers;

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

}
