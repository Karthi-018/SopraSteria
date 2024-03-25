package edu.sopra.training.SpringBootMVC.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import edu.sopra.training.SpringBootMVC.model.Cart;
import edu.sopra.training.SpringBootMVC.model.product;

public interface CartRepository extends CrudRepository<Cart, Integer> {

	List<Cart> findByemail(String email);

	
	@Query("from product where pid IN (Select productId from Cart where email=?1)")
	List<product> findByProductInCart(String email);
	
}
