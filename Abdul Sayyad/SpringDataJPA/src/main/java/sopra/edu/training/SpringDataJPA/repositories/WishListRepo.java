package sopra.edu.training.SpringDataJPA.repositories;

import org.springframework.data.repository.CrudRepository;

import sopra.edu.training.SpringDataJPA.models.Wishlist;
import java.util.List;


public interface WishListRepo extends CrudRepository<Wishlist, Integer> {
	
	List<Wishlist> findByuemail(String uemail);

}
