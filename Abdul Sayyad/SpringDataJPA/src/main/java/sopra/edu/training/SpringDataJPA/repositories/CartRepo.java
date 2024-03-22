package sopra.edu.training.SpringDataJPA.repositories;

import org.springframework.data.repository.CrudRepository;

import sopra.edu.training.SpringDataJPA.models.Cart;
import java.util.List;


public interface CartRepo extends CrudRepository<Cart, Integer> {
    List<Cart> findByuserEmail(String userEmail);
    
}
