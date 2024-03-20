package edu.sopra.training.SpringBootMVC.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sopra.training.SpringBootMVC.model.Users;

public interface UserRepo extends JpaRepository<Users, String> {
	
	Users findByUsername(String username);

}
