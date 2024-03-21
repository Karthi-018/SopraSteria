package edu.sopra.training.SpringBootMVC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.Customer;
import edu.sopra.training.SpringBootMVC.model.Product;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
		
	List<Customer> findByStatus(String status);
	Customer findBycustId(int id);
}
