package edu.training.InventoryServices1.repo;

import edu.training.InventoryServices1.models.Inventory;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {

}
