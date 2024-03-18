package edu.sopra.training.SpringBootMVC.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sopra.training.SpringBootMVC.model.Student;
import edu.sopra.training.SpringBootMVC.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository rapo;
	
	public void addStudent(String sname,int marks) {
		
		Student s=new Student();
		
		s.setSname(sname);
		s.setMarks(marks);
		
		rapo.save(s);
	}
	
	public List<Student> listStudent(){
		
		List<Student> list= new ArrayList<>();
		
		list=(List<Student>) rapo.findAll();
		
		
		return list;
	}

}
