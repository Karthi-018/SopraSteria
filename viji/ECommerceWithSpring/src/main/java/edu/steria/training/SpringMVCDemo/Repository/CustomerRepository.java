package edu.steria.training.SpringMVCDemo.Repository;

import org.springframework.data.repository.CrudRepository;

import edu.steria.training.SpringMVCDemo.Model.Customer;
import edu.steria.training.SpringMVCDemo.Model.Product;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Customer findByUsername(String name);
	Customer findById(String name);
}
