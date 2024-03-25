package edu.training.ProductServices1.repo;

import edu.training.ProductServices1.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food,Integer> {

}
