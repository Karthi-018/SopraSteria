package edu.sopra.training.Ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import edu.sopra.training.Ecommerce.model.Admin_1;

public interface AdminRepository extends CrudRepository<Admin_1, String> {
	
	Admin_1 findByAdminName(String admin);

}
