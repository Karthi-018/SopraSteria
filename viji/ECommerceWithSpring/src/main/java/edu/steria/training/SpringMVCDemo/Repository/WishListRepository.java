package edu.steria.training.SpringMVCDemo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.steria.training.SpringMVCDemo.Model.Cart;
import edu.steria.training.SpringMVCDemo.Model.WishList;

public interface WishListRepository extends CrudRepository<WishList, Integer>{
	List<WishList> findByUname(String name);
	void deleteById(int id);
}
