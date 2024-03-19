package edu.sopra.training.SpringBootMVC.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.sopra.training.SpringBootMVC.models.Student;

@RestController
public class MyRestController {

	List<Student> students= new ArrayList<>(Arrays.asList(new Student(1, "AAA", 98),new Student(2, "BBB", 87),new Student(3, "CCC", 54)));
	
	private static final Logger log = LoggerFactory.getLogger(MyRestController.class);
	
	@GetMapping("Students") @ResponseBody
	public List<Student> showStudents(){
		log.info("This a Student Info Log");
		log.warn("This a Student warning log ");
		log.error("This Student Error Log");
		log.debug("This is Student Debug log");
		return students;
	}
	
	@PostMapping("Students")
	@ResponseBody
	public Student createStudent(int sid, String sname, int marks) {
		
		students.add(new Student(sid,sname,marks));
		return new Student(sid,sname,marks);
	}
	
	@DeleteMapping("student")
	@ResponseBody
	public String deleteStudent(@RequestParam int sid)
	{
		students.remove(sid);
		
		return "Student Deleted";
	}
	

}
