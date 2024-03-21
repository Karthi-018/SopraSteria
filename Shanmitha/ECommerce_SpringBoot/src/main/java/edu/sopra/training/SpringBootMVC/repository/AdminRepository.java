package edu.sopra.training.SpringBootMVC.repository;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.AdminLogin;

public interface AdminRepository extends CrudRepository<AdminLogin, Integer> {

}
