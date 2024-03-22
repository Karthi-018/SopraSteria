package edu.sopra.training.Ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.Ecommerce.model.Cart_1;

public interface CartRepository extends CrudRepository<Cart_1,Integer> {
	
	List<Cart_1> findByUser(String user);
	
    Cart_1 findByPid(int pid);

}
