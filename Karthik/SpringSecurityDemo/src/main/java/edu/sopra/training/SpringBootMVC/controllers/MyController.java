package edu.sopra.training.SpringBootMVC.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/customer")
public class MyController {
	
	List<String> names= new ArrayList<>(List.of("Saswata","Chandra","Nivas","Karthi","Tharun","Priya","Shanmitha"));

	@GetMapping("/") // api/customer/
	@ResponseBody
	public String welcome(HttpServletRequest req) {
		
		return "Welcome to Spring Security <br>" + req.getSession().getId() ;
	}
	
	@GetMapping("/thankyou") // api/customer/tnankyou
	@ResponseBody
	public String thankyou(HttpServletRequest req) {
		
		return "Thank you for visiting Spring Security <br>" + req.getSession().getId();
	}
	
	@GetMapping("/names") // api/customer/names
	@ResponseBody
	public List<String> getnames() {
		
		return names;
	}
	
	@PostMapping("/names")
	@ResponseBody
	public List<String> putnames(@RequestBody String name) {
		
		names.add(name);
		return names;
	}
	
	@GetMapping("token")
	@ResponseBody
	public CsrfToken getToken(HttpServletRequest req) {
		
		return (CsrfToken) req.getAttribute("_csrf");
	}
	
	
	
}
