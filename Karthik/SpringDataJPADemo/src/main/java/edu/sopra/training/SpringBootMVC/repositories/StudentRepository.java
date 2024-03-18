package edu.sopra.training.SpringBootMVC.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	
}
