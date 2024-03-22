package edu.sopra.training.Ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.Ecommerce.model.Product_2;

public interface ProductRepository extends CrudRepository<Product_2, Integer> {
	
	Product_2 findByPid(int pid);
	
	List<Product_2> findByPname(String pname);
	

}
