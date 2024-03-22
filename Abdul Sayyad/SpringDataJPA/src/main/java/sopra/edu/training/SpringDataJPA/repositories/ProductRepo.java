package sopra.edu.training.SpringDataJPA.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sopra.edu.training.SpringDataJPA.models.Product;
import java.util.List;


public interface ProductRepo extends CrudRepository<Product, Integer> {

 Product findBypId(int pId);
 List<Product> findByProductName(String productName); 
 
 @Query("from Product where productQuant>?1 order by productName")
 List<Product> sortByProductNameByAsc(int productQuant);
}
