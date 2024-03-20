package edu.sopra.training.SpringBootMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sopra.training.SpringBootMVC.model.UserDetailPrinciple;
import edu.sopra.training.SpringBootMVC.model.Users;
import edu.sopra.training.SpringBootMVC.repo.UserRepo;

@Service
public class CustomerUserDetailServices implements UserDetailsService {
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Users customer = repo.findByUsername(username);
		 if(customer == null)
		 {
			 throw new UsernameNotFoundException("User not found Exception");
		 }
		 
		return new UserDetailPrinciple(customer);
	}

}
