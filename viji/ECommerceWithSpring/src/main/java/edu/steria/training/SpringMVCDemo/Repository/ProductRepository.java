package edu.steria.training.SpringMVCDemo.Repository;

import org.springframework.data.repository.CrudRepository;

import edu.steria.training.SpringMVCDemo.Model.Product;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findById(int id);
	@Override
   void deleteById(Integer id) ;
	Product findByPname(String name);
   
	
	
}
