package edu.sopra.training.Ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.Ecommerce.model.WishList;

public interface WishlistRepository extends CrudRepository<WishList, Integer> {
	
	List<WishList> findByUsername(String username);

	WishList findByPid(int id);

	

}
