package edu.sopra.training.SpringBootMVC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
	
	Cart findByproductId(int prodId);
	
	List<Cart> findByemail(String email);

}
