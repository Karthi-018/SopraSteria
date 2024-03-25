package edu.training.OrderServices1.repo;

import edu.training.OrderServices1.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Integer> {
}
