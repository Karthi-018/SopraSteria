package edu.sopra.training.SpringBootMVC.respositories;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {

	Admin findByEmail(String email);

}
