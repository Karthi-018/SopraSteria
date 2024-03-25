package edu.sopra.training.SpringBootMVC.start;

import org.springframework.stereotype.Service;

@Service
public class main {

	public boolean choiceCheck(String choice) {
		
		switch(choice) {
		
		case "admin":return true;
		case "customer": return false;
		
		}
		
		return true;
	} 

}
