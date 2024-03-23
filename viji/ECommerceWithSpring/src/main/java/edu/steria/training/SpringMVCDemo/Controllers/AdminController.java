package edu.steria.training.SpringMVCDemo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.steria.training.SpringMVCDemo.Model.Customer;
import edu.steria.training.SpringMVCDemo.Model.Product;
import edu.steria.training.SpringMVCDemo.Service.AdminService;


@Controller
public class AdminController {
	@Autowired
	AdminService admin;
@RequestMapping("/")
public ModelAndView index()
{
	  return new ModelAndView("Index.jsp");
}
@RequestMapping("adminValidation")
public ModelAndView validateAdmin(String username,String pass)
{
	  ModelAndView mv=new ModelAndView();
	  boolean i=admin.validate(username, pass);
	  if(i==true)
	  {
		  mv.addObject("msg","Logged in successfully");
		  mv.setViewName("home.jsp");
	  }
	  else
	  {
		  mv.addObject("msg","Admin not found !!! Try to Sign up");
		  mv.setViewName("SignUp.jsp");
	  }
	  return mv;
}
@RequestMapping("addAdmin")
public ModelAndView addAdmin(String name,String uname,String pass)
{
	 ModelAndView mv=new ModelAndView();
	 boolean i=admin.add(name,uname, pass);
	 if(i==true)
	 {
		 mv.addObject("msg", "Admin Added Successfully!!!");
		
	 }
	 else
	 {
		 mv.addObject("msg","Admin already exixt! Try to LogIn");
		 
	 }
	 mv.setViewName("AdminLogin.jsp");
	 return mv;
}
@RequestMapping("Action")
public ModelAndView action(String adm)
{
	 ModelAndView mv=new ModelAndView();
	 mv.addObject("type", "Admin");
	 switch(adm)
	 {
	 case "Create":
		 mv.setViewName("Create.jsp");
		 break;
	 case "Search":
		 //mv.addObject("type", "Admin");
		 mv.setViewName("Search.jsp");
		 break;
	 case "View":
		 //mv.addObject("type", "Admin");
		 List<Product> productList=(List<Product>)admin.getList();
		 if(!productList.isEmpty())
		 {
			 mv.addObject("flag","true");
		     mv.addObject("list", productList);
		     mv.setViewName("View.jsp");
		 }
		 else
		 {
			 mv.addObject("flag","false");
			 mv.addObject("msg","No Products in the List!");
			 mv.setViewName("View.jsp");
		 }
		 break;
	 case "ValidateCustomer":
		 List<Customer> customerList=(List<Customer>)admin.getCustList();
		
		 if(!customerList.isEmpty())
		 {
			 mv.addObject("flag","true");
			 mv.addObject("list", customerList);
			 
		 }
		 else
		 {
			 mv.addObject("flag","false");
			 mv.addObject("msg","No Customers in the List!");
			
		 }
	 
		 mv.setViewName("CustomerList.jsp");
		 break;
	 case "LogOut":
		 mv.setViewName("Index.jsp");
		 break;
	 }
	 return mv;
}
@RequestMapping("Create")
public ModelAndView addProduct(String name,String descp,double price,int quan)
{
	 ModelAndView mv=new ModelAndView();
	 boolean i=admin.addProduct(name,descp, price,quan);
	 if(i==true)
	 {
		 mv.addObject("msg", "Product Added Successfully!!!");
		 
	 }
	 else
	 {
		 mv.addObject("msg","Product already exixt! Try to add new product");
		 
	 }
	 mv.setViewName("Create.jsp");
	 return mv;
}
@RequestMapping("Search")
public ModelAndView search(String search)
{
	ModelAndView mv=new ModelAndView();
	Product pr=admin.search(search);
	mv.addObject("type", "Admin");
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
@RequestMapping("Delete")
public ModelAndView delete(int delete)
{
	
	ModelAndView mv=new ModelAndView();
	admin.delete(delete);
	List<Product> productList=(List<Product>)admin.getList();
	mv.addObject("list", productList);
	mv.addObject("type", "Admin");
	mv.addObject("flag","true");
	mv.setViewName("View.jsp");
	return mv;
}
@RequestMapping("EditData")
public ModelAndView fetchData(int edit)
{
	ModelAndView mv=new ModelAndView();
	Product p=(Product)admin.fetchData(edit);
	mv.addObject("pro",p);
	mv.setViewName("Edit.jsp");
	return mv;
}
@RequestMapping("Edit")
public ModelAndView edit(int id,double price,int quan)
{
	ModelAndView mv=new ModelAndView();
	admin.editData(id,price,quan);
	List<Product> productList=(List<Product>)admin.getList();
	mv.addObject("list", productList);
	mv.addObject("type", "Admin");
	mv.addObject("flag","true");
	mv.setViewName("View.jsp");
	return mv;
}
@RequestMapping("ActivateCustomer")
public ModelAndView activate(String username)
{ 
	ModelAndView mv=new ModelAndView();
	admin.activate(username);
	List<Customer> customerList=(List<Customer>)admin.getCustList();
	mv.addObject("list", customerList);
	mv.addObject("flag","true");
	mv.setViewName("CustomerList.jsp");
	return mv;
}
}
