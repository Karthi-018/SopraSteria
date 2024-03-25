package edu.sopra.training.SpringBootMVC.respositories;


import java.util.List;


import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.product;

public interface ProductRepository extends CrudRepository<product, Integer> {

	product findBypid(int pid);
	List<product> findByPname(String Pname);
	
}
