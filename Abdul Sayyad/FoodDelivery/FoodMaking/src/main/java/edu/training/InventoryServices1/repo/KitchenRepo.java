package edu.training.InventoryServices1.repo;

import edu.training.InventoryServices1.models.Kitchen;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenRepo extends JpaRepository<Kitchen,Integer> {

}
