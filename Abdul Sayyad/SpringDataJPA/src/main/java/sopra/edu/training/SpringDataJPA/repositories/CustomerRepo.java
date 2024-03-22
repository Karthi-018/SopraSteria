package sopra.edu.training.SpringDataJPA.repositories;

import org.springframework.data.repository.CrudRepository;

import sopra.edu.training.SpringDataJPA.models.Customer;
import java.util.List;


public interface CustomerRepo extends CrudRepository<Customer, String> {
	
	Customer findByUserEmail(String userEmail);
	List<Customer> findByaccess(String access);

}
