package sopra.edu.training.SpringDataJPA.repositories;

import org.springframework.data.repository.CrudRepository;

import sopra.edu.training.SpringDataJPA.models.admin;
import java.util.List;


public interface AdminRepo extends CrudRepository<admin, String> {

	admin findByUname(String uname);
}
