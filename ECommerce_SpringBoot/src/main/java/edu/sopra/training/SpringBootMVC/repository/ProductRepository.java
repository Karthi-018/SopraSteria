package edu.sopra.training.SpringBootMVC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByName(String name);
	
	void deleteBypId(int id);
	Product findBypId(int pId);
	Product findById(int id);
}
