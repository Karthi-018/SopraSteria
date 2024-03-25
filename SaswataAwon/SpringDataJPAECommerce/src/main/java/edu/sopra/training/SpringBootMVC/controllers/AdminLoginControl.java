package edu.sopra.training.SpringBootMVC.controllers;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.SpringBootMVC.model.product;
import edu.sopra.training.SpringBootMVC.services.AdminLoginServices;
import edu.sopra.training.SpringBootMVC.services.Create;
import edu.sopra.training.SpringBootMVC.start.main;



@Controller
public class AdminLoginControl {

	@Autowired
	AdminLoginServices serv;
	
	@Autowired
	main m;
	
	@Autowired
	Create c;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv= new ModelAndView("Start.jsp");
		return mv;
	}
	
	@RequestMapping("/choice")
	public ModelAndView choiceCheck(String choice) {
		
		ModelAndView mv= new ModelAndView();
		
		if(m.choiceCheck(choice)) {
			mv.setViewName("AdminLogin.jsp");
		}
		else {
			mv.setViewName("Customer.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping("/AdminLogin")
	public ModelAndView loginCheck(String email,String password) {
		
		ModelAndView mv= new ModelAndView();
		
		if(serv.loginCheck(email, password)) {
			mv.addObject("msg1","Welcome to S-Karting");
			mv.addObject("msg2","Happy Shopping");
			mv.setViewName("index.jsp");
		}
		else {
			mv.addObject("msg","Invalid Credentials!!! Please Enter Email ID and Password Correctly.");
			mv.setViewName("AdminLogin.jsp");
		}
		
		return mv;
	}
	
	@GetMapping("/Create")
	public ModelAndView createForm()
	{
		return new ModelAndView("Create.jsp");
	}
	
	@RequestMapping("/create")
	public ModelAndView addproduct(String pname,String pdesc,int pprice,int qty,MultipartFile pImg) {
		ModelAndView mv= new ModelAndView();
		try {
			byte[] bytes = pImg.getBytes();
			Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			c.addProduct(pname,pdesc,pprice,qty,blob);
			mv.addObject("msg","Product "+ pname + " details is added to database");
			mv.setViewName("Create.jsp");
		} catch (IOException| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	@RequestMapping("View")
	public ModelAndView listProduct() {
		ModelAndView mv= new ModelAndView("View.jsp");
		
		mv.addObject("products",c.listProduct());
		return mv;
	}
	
	@RequestMapping("Delete")
	public ModelAndView deleteProduct(int pid)
	{
		ModelAndView mv= new ModelAndView("View.jsp");
		
		c.deleteProduct(pid);
		mv.addObject("products",c.listProduct());
		mv.setViewName("View.jsp");
		
		return mv;
	}
	
	@GetMapping("Edit")
	public ModelAndView editProduct(int pid) {
		ModelAndView mv= new ModelAndView("Edit.jsp");
		
		mv.addObject("products", c.editProduct(pid));
		return mv;
	}
	
	@RequestMapping("edit")
	public ModelAndView updatedProduct(int pid,int pprice,int qty) {
		
		ModelAndView mv= new ModelAndView("View.jsp");
		
		String msg= c.updateProduct(pid, pprice, qty);
		mv.addObject("msg", msg);
		mv.addObject("products",c.listProduct());
		return mv;		
	}
	
	@GetMapping("Search")
	public ModelAndView search(int search) {
		
		ModelAndView mv= new ModelAndView();
		product pro = c.search(search);
		if(pro!=null)
		{
		mv.setViewName("SearchedProduct.jsp");
		mv.addObject("products", pro);
		}
		else
		{
			mv.setViewName("index.jsp");
			mv.addObject("nopro", "Product 404");
		}
		
		return mv;
		
	}
	
}
