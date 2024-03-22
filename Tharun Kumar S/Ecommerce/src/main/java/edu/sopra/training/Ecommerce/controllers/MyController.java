package edu.sopra.training.Ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.Ecommerce.model.Cust_2;
import edu.sopra.training.Ecommerce.model.Product_2;
import edu.sopra.training.Ecommerce.services.AdminService;

@Controller
public class MyController {
	
	@Autowired
	AdminService as;
	
	@GetMapping("/")
	//@ResponseBody
	public ModelAndView welcome() {
		
	//	return new ModelAndView("login.jsp");
		return new ModelAndView("Welcome.jsp");
	}
	
	@GetMapping("AdminLogin")
	//@ResponseBody
	public ModelAndView login() {
		
	//	return new ModelAndView("login.jsp");
		return new ModelAndView("adminlogin.jsp");
	}
	
	@PostMapping("login")
	public ModelAndView setlogin(String admin,String passwrd) {
		
		ModelAndView mv=new ModelAndView();
		if (as.check(admin, passwrd)){
			mv.addObject("admin",admin);
			mv.setViewName("index.jsp");
		}
		else {
			mv.addObject("err","Invalid Credentials!!!");
			mv.setViewName("adminlogin.jsp");
		}
		return mv;
	}
	@GetMapping("Ind")
		public ModelAndView index() {
			
			//	return new ModelAndView("login.jsp");
				return new ModelAndView("index.jsp");
			}
	@GetMapping("Index")
	public ModelAndView toindex() {
		
		//	return new ModelAndView("login.jsp");
			return new ModelAndView("index.jsp");
		}
	@GetMapping("Create")
	public ModelAndView create() {
		
		//	return new ModelAndView("login.jsp");
			return new ModelAndView("create.jsp");
		}
	@PostMapping("Create")
	public ModelAndView toCreate(int id,String pname,String descp,int quan,int price) {
		
		ModelAndView mv=new ModelAndView();
		   if(as.addProduct(id,pname,descp,quan,price)) {
			    mv.addObject("err","Product Added Successfully!!!");
				mv.setViewName("create.jsp");
		}
		else {
			mv.addObject("err","Invalid Credentials or Product already Present!!!");
			mv.setViewName("create.jsp");
		}
		return mv;
	}
	@GetMapping("Search")
	public ModelAndView toSearch() {
		
		//	return new ModelAndView("login.jsp");
			return new ModelAndView("search.jsp");
		}
	@PostMapping("Search")
	public ModelAndView toSearch(String pname) {
		
		ModelAndView mv=new ModelAndView();
		List<Product_2> li=(List<Product_2>)as.searchProduct(pname);
		if(!li.isEmpty()) {
			   mv.addObject("list",li);
			   mv.addObject("pfounf","Product found!!!");
			   mv.setViewName("search.jsp");
		}
		else {
			mv.addObject("list",li);
			mv.addObject("pnotFound","Product not found!!!");
			mv.setViewName("search.jsp");
		}
		return mv;
	}
	@GetMapping("View")
	public ModelAndView toView() {
		
		ModelAndView mv=new ModelAndView();
		List<Product_2> li=(List<Product_2>)as.viewProduct();
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
				mv.setViewName("view.jsp");
		}
		else {
			mv.addObject("err","No Product Present!!!");
			mv.setViewName("view.jsp");
		}
		return mv;
	}
	
	@GetMapping("Edit")
	public ModelAndView toEdit(int id) {
		
		ModelAndView mv=new ModelAndView();
		Optional<Product_2> p=(Optional<Product_2>)as.searcheditProduct(id);
	    mv.addObject("product",p.get());
	    mv.setViewName("edit.jsp");
		return mv;
	}
	
	@PostMapping("Edit")
	public ModelAndView edit(int id,int price,int quan) {
		
		
		as.editProduct(id,price,quan);
		
		ModelAndView mv=new ModelAndView();
		List<Product_2> li=(List<Product_2>)as.viewProduct();
		
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
				mv.setViewName("view.jsp");
		}
		else {
			mv.addObject("err","No Product Present!!!");
			mv.setViewName("view.jsp");
		}
		return mv;
		
	}
	
	@PostMapping("Delete")
	public ModelAndView edit(int id) {
		
		
		
		
		ModelAndView mv=new ModelAndView();
		List<Product_2> li=as.deleteProduct(id);
		
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
				mv.setViewName("view.jsp");
		}
		else {
			mv.addObject("err","No Product Present!!!");
			mv.setViewName("view.jsp");
		}
		return mv;
		
	}
	
	@GetMapping("CustAcc")
	public ModelAndView toAccess() {
		
		ModelAndView mv=new ModelAndView();
		List<Cust_2> li=(List<Cust_2>)as.viewCust();
		
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
				mv.setViewName("accessview.jsp");
		}
		else {
			mv.addObject("err","No Customers Present!!!");
			mv.setViewName("accessview.jsp");
		}
		return mv;
	}
	@PostMapping("CustAcc")
	public ModelAndView togiveAccess(String status) {
		
		ModelAndView mv=new ModelAndView();
		List<Cust_2> li=(List<Cust_2>)as.accessCust(status);
		
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
				mv.setViewName("accessview.jsp");
		}
		else {
			mv.addObject("err","No Customers Present!!!");
			mv.setViewName("accessview.jsp");
		}
		return mv;
	}
	
	
	

	
	

}
