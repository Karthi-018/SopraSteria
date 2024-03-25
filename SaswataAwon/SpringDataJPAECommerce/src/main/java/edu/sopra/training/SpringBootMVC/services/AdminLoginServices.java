package edu.sopra.training.SpringBootMVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sopra.training.SpringBootMVC.model.Admin;
import edu.sopra.training.SpringBootMVC.respositories.AdminRepository;

@Service
public class AdminLoginServices {
	
	@Autowired
	AdminRepository rapo;
	
	public boolean loginCheck(String email,String password) {
		
		Admin a = rapo.findByEmail(email);
		
		if(a!=null && password.equals(a.getPassword())) {
			return true;
		}
		else {
			return false;
		}
		
	} 
	
	

}
