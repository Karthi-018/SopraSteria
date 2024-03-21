package edu.sopra.training.SpringBootMVC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.SpringBootMVC.model.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {
	
	List<Wishlist> findByemail(String email);

}
