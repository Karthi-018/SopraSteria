package edu.sopra.training.SpringBootMVC.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.SpringBootMVC.model.Cart;
import edu.sopra.training.SpringBootMVC.model.Customer;
import edu.sopra.training.SpringBootMVC.model.product;
import edu.sopra.training.SpringBootMVC.services.CustomerService;

@Controller
public class CustomerControl {
	
	public static String email;
	private String cartMsg=null;
	
	@Autowired
	CustomerService cs;
	
	
	@GetMapping("/CustLogin")
	public ModelAndView logincheck(String email,String password) {
		
		ModelAndView mv= new ModelAndView();
		
		if(cs.logincust(email, password)) {
			
			CustomerControl.email=email;
			mv.addObject("msg1","Welcome to S-Karting");
			mv.addObject("msg2","Happy Shopping");
			mv.setViewName("custIndex.jsp");
		}
		else {
			mv.addObject("msg","Invalid Credentials!!! Please Enter Email ID and Password Correctly.");
			mv.setViewName("CustomerLogin.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/Register")
	public ModelAndView gotoRegistration() {
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("Register.jsp");
		return mv;
	}
	
	@GetMapping("/CustomerRegistration")
	public ModelAndView addCustDatabase(String email, String fname,String lname,String password) {
		
		ModelAndView mv=new ModelAndView();
		
		cs.addDatabase(email,fname,lname,password);
		mv.addObject("msg",fname + " "+ lname+"'s details is added to database");
		mv.setViewName("CustomerLogin.jsp");
		return mv;
	}
	
	@RequestMapping("/viewCustomer")
	public ModelAndView listProduct() {
		ModelAndView mv= new ModelAndView("CardView.jsp");
		mv.addObject("msg", this.cartMsg);
		this.cartMsg = null;
		mv.addObject("products",cs.viewProduct());
		return mv;
	}
	
	@GetMapping("/SearchCust")
	public ModelAndView search(String search) {
		
		ModelAndView mv= new ModelAndView();
		List<product> pro= cs.searchName(search);
		
		if(!pro.isEmpty())
		{
		mv.setViewName("searchCustProduct.jsp");
		mv.addObject("products", pro);
		return mv;
		}
		else
		{
			mv.setViewName("ProductNotFound.jsp");
			return mv;
		}
		
		
	}
	
	@GetMapping("/Cart")
	public ModelAndView addtoCart(int pid) {
		
		
		cs.addCart(pid);
		this.cartMsg="Product added successfully";
		
		return this.listProduct();
	}
	
	@RequestMapping("/viewCart")
	public ModelAndView listCart() {
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("products",cs.viewCart(email));
		mv.setViewName("Cart.jsp");
		return mv;
	}
	
	@GetMapping("/Wishlist")
	public ModelAndView addtoWish(int pid) {
		
		
		cs.addWishlist(pid);
		this.cartMsg="Product added successfully";
		
		return this.listProduct();
	}
	
	@RequestMapping("/viewWish")
	public ModelAndView listWish() {
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("products",cs.viewWish(email));
		mv.setViewName("WishList.jsp");
		return mv;
	}
	
	@GetMapping("/Buy")
	public ModelAndView buyProduct(int pid) {
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("products", cs.buyPage(pid));
		mv.setViewName("Buy.jsp");
		
		return mv;
	}
	
	@GetMapping("/Buy2")
	public ModelAndView buyShow(int pid,int qty,int confirm) {
		
		ModelAndView mv= new ModelAndView();
		int flag= cs.buyDone(pid, qty, confirm);
		
		if(flag==1) {
			mv.setViewName("CartPopUp.jsp");
			return mv;
		}
		else {
			mv.addObject("msg", "Sorry, Please Try Again");
			return this.listProduct();
		}
		
	}
	
	@RequestMapping("/RemoveCart")
	public ModelAndView deleteCart(int pid) {
		
		ModelAndView mv= new ModelAndView();
		
	    cs.deleteCartItem(pid);
	    
	    mv.addObject("products", cs.viewCart(email));
	    mv.setViewName("Cart.jsp");
	    
	    return mv;
	}
	
	@RequestMapping("/RemoveWishlist")
	public ModelAndView deleteWish(int pid) {
		
		ModelAndView mv= new ModelAndView();
		
	    cs.deleteWishItem(pid);
	    
	    mv.addObject("products", cs.viewCart(email));
	    mv.setViewName("Wishlist.jsp");
	    
	    return mv;
	}
	
	@RequestMapping("/BuyAll")
	public ModelAndView buyAllProduct() {
		
		ModelAndView mv= new ModelAndView();
	
		cs.buyAll();
	
		mv.setViewName("CartPopUp.jsp");
		return mv;
	}
	
	
	
	
	
	
}
