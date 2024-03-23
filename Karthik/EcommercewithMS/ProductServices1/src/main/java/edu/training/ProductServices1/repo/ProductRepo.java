package edu.training.ProductServices1.repo;

import edu.training.ProductServices1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
