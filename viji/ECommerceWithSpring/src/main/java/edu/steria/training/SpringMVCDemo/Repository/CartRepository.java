package edu.steria.training.SpringMVCDemo.Repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import edu.steria.training.SpringMVCDemo.Model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
	List<Cart> findByUsername(String name);
	void deleteById(int id);
}
