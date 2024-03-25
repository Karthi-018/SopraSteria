package edu.sopra.training.SpringBootMVC.respositories;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	Customer findByEmail(String email);
}
