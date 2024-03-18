package edu.sopra.training.SpringBootMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.SpringBootMVC.services.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	StudentService serv;
	
	@RequestMapping("/")
	public ModelAndView index()  {
		
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping("/createStudent")
	public ModelAndView createForm()  {
		
		return new ModelAndView("Create.jsp");
	}
	
	@RequestMapping("Create")
	public ModelAndView addStudent(String sname,int marks) {
		ModelAndView mv= new ModelAndView("Create.jsp");
		
		serv.addStudent(sname, marks);
		mv.addObject("msg","Student "+ sname + " is added to database");
		
		return mv;
	}
	
	@RequestMapping("View")
	public ModelAndView listStudent() {
		ModelAndView mv= new ModelAndView("View.jsp");
		
		mv.addObject("students",serv.listStudent());
		return mv;
	}

}
