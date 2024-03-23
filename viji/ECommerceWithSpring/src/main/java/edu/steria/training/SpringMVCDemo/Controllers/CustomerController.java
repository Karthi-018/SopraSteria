package edu.steria.training.SpringMVCDemo.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.steria.training.SpringMVCDemo.Model.Cart;
import edu.steria.training.SpringMVCDemo.Model.Customer;
import edu.steria.training.SpringMVCDemo.Model.Product;
import edu.steria.training.SpringMVCDemo.Model.WishList;
import edu.steria.training.SpringMVCDemo.Service.CustomerService;

@Controller
public class CustomerController {
  @Autowired
  CustomerService  customer;
  @Autowired
  HttpSession session;
//  public void setSession(HttpServletRequest request)
//  {
//	  session=request.getSession();
//	  session.setAttribute(null, session);
//  }
  @RequestMapping("Validation")
  public ModelAndView validateCustomer(String username,String pass,HttpServletRequest request)
  {
  	  ModelAndView mv=new ModelAndView();
  	  boolean i=customer.validate(username, pass);
  	  if(i==true)
  	  {
  		  session=request.getSession();
  		  session.setAttribute("user", username);
  		  mv.setViewName("CustomerHome.jsp");
  	  }
  	  else
  	  {
  		  mv.addObject("msg","Invalid username or password!!!");
  		  mv.setViewName("LogIn.jsp");
  	  }
  	  return mv;
  }
  @RequestMapping("Registration")
  public ModelAndView add(String fname,String lname,String email,String uname,String pass,String dob,String gender)
  {
  	 ModelAndView mv=new ModelAndView();
  	 boolean i=customer.add(fname,lname,email,uname, pass,dob,gender);
  	 if(i==true)
  	 {
  		 mv.addObject("msg", "User Added Successfully!!!");
  		
  	 }
  	 else
  	 {
  		 mv.addObject("msg","User already exixt! Try to LogIn");
  		 
  	 }
  	 mv.setViewName("LogIn.jsp");
  	 return mv;
  }
  @RequestMapping("CustomerAction")
  public ModelAndView action(String cus,HttpServletRequest request)
  {
	 session=request.getSession();
	 String u=(String)session.getAttribute("user");
  	 ModelAndView mv=new ModelAndView();
  	 mv.addObject("type", "Customer");
  	 switch(cus)
  	 {
  	 case "Search":
  		 mv.setViewName("Search.jsp");
  		 break;
  	 case "Cart":
  		
  	  List<Cart> cartList=(List<Cart>)customer.getCartList(u);
  	  if(cartList!=null)
  	  	{
  		  mv.addObject("flag","true");
  		  mv.addObject("cart", cartList);
  		  mv.setViewName("CartList.jsp");
  	  	}
  	  else
  	  {
  		  mv.addObject("flag","false");
  		  mv.addObject("msg","Your Cart is empty");
  		  mv.setViewName("CartList.jsp");
  	  }
  		 break;
  	 case "View":
  		 List<Product> product=(List<Product>)customer.getList();
  		 if(!product.isEmpty())
  		 {
  			 mv.addObject("flag","true");
  		     mv.addObject("list", product);
  		     mv.setViewName("View.jsp");
  		 }
  		 else
  		 {
  			 mv.addObject("flag","false");
  			 mv.addObject("msg","No Products in the List!");
  			 mv.setViewName("View.jsp");
  		 }
  		 break;
  	 case "WishList":
  		  List<Product> wishList=(List<Product>)customer.getWishList(u);
    	  if(wishList!=null)
    	  	{
    		  mv.addObject("flag","true");
    		  mv.addObject("wish",wishList);
    		  mv.setViewName("WishList.jsp");
    	  	}
    	  else
    	  {
    		  mv.addObject("flag","false");
    		  mv.addObject("msg","Your WishList is empty");
    		  mv.setViewName("WishList.jsp");
    	  }
  		
 		
  		 break;
  	 case "LogOut":
  		session=request.getSession();
  		session.invalidate();
  		 mv.setViewName("Index.jsp");
  		 break;
  	 }
  	 return mv;
  }
  @RequestMapping("ProductSearch")
  public ModelAndView search(String search)
  {
  	ModelAndView mv=new ModelAndView();
  	Product pr=customer.search(search);
  	mv.addObject("type", "Customer");
  	if(pr!=null)
  	{
  		mv.addObject("flag","true");
  		 mv.addObject("res", pr);
  		 mv.setViewName("Search.jsp");
  	}
  	else
  	{
  		mv.addObject("flag","false");
  		mv.addObject("msg","Product not found!!");
  		mv.setViewName("Search.jsp");
  	}
  	 return mv;
  }
  @RequestMapping("buyProduct")
  public ModelAndView buy(int buy,int quantity)
  {
	  ModelAndView mv=new ModelAndView();
	  customer.buy( buy,quantity);
	  List<Product> productList=(List<Product>)customer.getList();
	  mv.addObject("flag","true");
	  mv.addObject("list", productList);
	  mv.setViewName("View.jsp");
	  return mv;
  }
  @RequestMapping("AddToCart")
  public ModelAndView cartList(int cart,HttpServletRequest request)
  {
	  ModelAndView mv=new ModelAndView();
	  session=request.getSession();
	  String u=(String)session.getAttribute("user");
	  customer.addToCart(cart,u);
	  List<Product> productList=(List<Product>)customer.getList();
	  mv.addObject("flag","true");
	  mv.addObject("list", productList);
	  mv.setViewName("View.jsp");	  
	  return mv;
	  
  }
  @RequestMapping("AddToWishList")
  public ModelAndView wishList(int wishList,HttpServletRequest request)
  {
	  ModelAndView mv=new ModelAndView();
	  session=request.getSession();
	  String u=(String)session.getAttribute("user");
	  customer.addToWishList(wishList,u);
	  List<Product> productList=(List<Product>)customer.getList();
	  mv.addObject("flag","true");
	  mv.addObject("list", productList);
	  mv.setViewName("View.jsp");	  
	  return mv;
	  
  }
  @RequestMapping("DeleteCart")
  public ModelAndView delete(int delete,HttpServletRequest request)
  {
	  ModelAndView mv=new ModelAndView();
	  session=request.getSession();
	  String u=(String)session.getAttribute("user");
	  customer.deleteCart(delete,u);
	  List<Cart> cartList=(List<Cart>)customer.getCartList(u);
  	  if(cartList!=null)
  	  	{
  		  mv.addObject("flag","true");
  		  mv.addObject("cart", cartList);
  		  mv.setViewName("CartList.jsp");
  	  	}
  	  else
  	  {
  		  mv.addObject("flag","false");
  		  mv.addObject("msg","Your Cart is empty");
  		  mv.setViewName("CartList.jsp");
  	  }
  	  return mv;
	  
  }
  @RequestMapping("DeleteWishList")
  public ModelAndView deleteWish(int delete,HttpServletRequest request)
  {
	  ModelAndView mv=new ModelAndView();
	  session=request.getSession();
	  String u=(String)session.getAttribute("user");
	  customer.deleteWishlist(delete,u);
	  List<Product> wishList=(List<Product>)customer.getWishList(u);
  	  if(wishList!=null)
  	  	{
  		  mv.addObject("flag","true");
  		  mv.addObject("wish", wishList);
  		  mv.setViewName("WishList.jsp");
  	  	}
  	  else
  	  {
  		  mv.addObject("flag","false");
  		  mv.addObject("msg","Your WishList is empty");
  		  mv.setViewName("WishList.jsp");
  	  }
  	  return mv;
	  
  }
  @RequestMapping("AddToWhishlistAndDelete")
  public ModelAndView addToWishlist(int wishList,HttpServletRequest request)
  {
	  ModelAndView mv=new ModelAndView();
	  session=request.getSession();
	  String u=(String)session.getAttribute("user");
	  customer.addToWishList(wishList,u);
	  List<Cart> cartList=(List<Cart>)customer.getCartList(u);
  	  if(cartList!=null)
  	  	{
  		  mv.addObject("flag","true");
  		  mv.addObject("cart", cartList);
  		  mv.setViewName("CartList.jsp");
  	  	}
  	  else
  	  {
  		  mv.addObject("flag","false");
  		  mv.addObject("msg","Your Cart is empty");
  		  mv.setViewName("CartList.jsp");
  	  }	  
	  return mv;
  }
  @RequestMapping("AddToCartAndDelete")
  public ModelAndView addToCartlist(int cart,HttpServletRequest request)
  {
	  ModelAndView mv=new ModelAndView();
	  session=request.getSession();
	  String u=(String)session.getAttribute("user");
	  customer.addToCart(cart,u);
	  List<Product> wishList=(List<Product>)customer.getWishList(u);
  	  if(wishList!=null)
  	  	{
  		  mv.addObject("flag","true");
  		  mv.addObject("wish", wishList);
  		  mv.setViewName("WishList.jsp");
  	  	}
  	  else
  	  {
  		  mv.addObject("flag","false");
  		  mv.addObject("msg","Your WishList is empty");
  		  mv.setViewName("WishList.jsp");
  	  }	  
	  return mv;
  }
}
