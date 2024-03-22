package edu.sopra.training.Ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.Ecommerce.model.Cust_2;

public interface CustomerRepository extends CrudRepository<Cust_2, String> {
	
	Cust_2 findByUserName(String userName);
	
//	List<Cust_2> findByUserName1(String userName);
	
	
	
	
	

}
