package edu.sopra.training.SpringBootMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.SpringBootMVC.model.Customer;
import edu.sopra.training.SpringBootMVC.model.Product;
import edu.sopra.training.SpringBootMVC.service.AdminLoginService;
@Controller
public class AdminController {

	@Autowired
	AdminLoginService al;

	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("index.jsp");
	}

	@RequestMapping("UserType")
	public ModelAndView userType(String choice)
	{
		ModelAndView mv = new ModelAndView();
		switch(choice)
		{
		case "Admin":
			mv.setViewName("AdminLogin.jsp");
			break;
		case "Customer":
			mv.setViewName("CustomerRegisteration.jsp");
			break;
		}
		return mv;
	
	}
		
		@RequestMapping("login")
		public ModelAndView login(String name, String psw)
		{
			ModelAndView mv = new ModelAndView();
			if(al.adminLogin(name,psw))
			{
				mv.setViewName("AdminHome.jsp");
			}
			else
			{
				mv.addObject("invalid","invalid username or password");
				mv.setViewName("AdminLogin.jsp");
			}

			return mv;
		}
		
		@RequestMapping("AdminMenubar")
		public ModelAndView menu(String choice)
		{
			ModelAndView mv = new ModelAndView();
			switch(choice)
			{
			case "Create":
				mv.setViewName("AdminCreateProduct.jsp");
				break;
			case "Search":
				mv.setViewName("AdminSearch.jsp");
				break;
			case "View":
				 List<Product> product_list = al.listAllProducts();
				 mv.addObject("product_list",product_list);
				mv.setViewName("AdminView.jsp");
				break;
			case "ValidateCustomer":
				
				List<Customer> NewCustomers = al.listNewCustomers();
				List<Customer> activeCustomers = al.listActiveCustomers();
				List<Customer> inactiveCustomers = al.listInactiveCustomers();
				mv.addObject("NewCustomers",NewCustomers);
				mv.addObject("activeCustomers",activeCustomers);
				mv.addObject("inactiveCustomers",inactiveCustomers);
				mv.setViewName("AdminValidation.jsp");
				break;
			case "Logout":
				mv.setViewName("index.jsp");
				break;
			}
			return mv;
			
		}
		
		@RequestMapping("CreateProduct")
		public ModelAndView createProduct(int id, String name, String descr, int price, int quantity)
		{
			ModelAndView mv = new ModelAndView();
			al.saveProductDetails(id,name,descr,price,quantity);
			mv.setViewName("AdminCreateProduct.jsp");
			return mv;
		}
		
		@RequestMapping("SearchProd")
		public ModelAndView searchProduct(String search)
		{
			ModelAndView mv = new ModelAndView();
			Product p = al.searchProduct(search);
			if(p==null)
			{
				mv.addObject("notFound","Product not available!!!");
				mv.setViewName("AdminSearch.jsp");
			}
			else
			{
				mv.addObject("product",p);
				mv.setViewName("AdminSearch.jsp");
			}
			return mv;
		}
		
		@RequestMapping("DeleteProduct")
		public ModelAndView deleteproduct(int delete)
		{
			ModelAndView mv = new ModelAndView("AdminView.jsp");
			mv.addObject("product_list",al.deleteProduct(delete));
			return mv;
			
		}
		
		@RequestMapping("EditProduct")
		public ModelAndView editproduct(int edit)
		{
			ModelAndView mv = new ModelAndView();
			Product p = al.getProductDetails(edit);
			mv.addObject("product_obj", p);
			mv.setViewName("AdminEdit.jsp");
			return mv;
		}
		
		@RequestMapping("UpdateDetails")
		public ModelAndView updateProduct(int id, int price, int quantity)
		{
			ModelAndView mv = new ModelAndView("AdminView.jsp");
			mv.addObject("product_list",al.updateProductDetails(id,price,quantity));
			return mv;
		}
		
		@RequestMapping("AdminValidation")
		public ModelAndView adminValidation(int validate)
		{
			ModelAndView mv = new ModelAndView();
			al.validateCustomer(validate);
			List<Customer> NewCustomers = al.listNewCustomers();
			List<Customer> activeCustomers = al.listActiveCustomers();
			List<Customer> inactiveCustomers = al.listInactiveCustomers();
			mv.addObject("NewCustomers",NewCustomers);
			mv.addObject("activeCustomers",activeCustomers);
			mv.addObject("inactiveCustomers",inactiveCustomers);
			
			mv.setViewName("AdminValidation.jsp");
			return mv;
		}
	
		@RequestMapping("AdminInvalidation")
		public ModelAndView adminInvalidation(int invalidate)
		{
			ModelAndView mv = new ModelAndView();
			al.invalidateCustomer(invalidate);
			List<Customer> NewCustomers = al.listNewCustomers();

			List<Customer> activeCustomers = al.listActiveCustomers();
			List<Customer> inactiveCustomers = al.listInactiveCustomers();
			mv.addObject("NewCustomers",NewCustomers);

			mv.addObject("activeCustomers",activeCustomers);
			mv.addObject("inactiveCustomers",inactiveCustomers);
			mv.setViewName("AdminValidation.jsp");
			return mv;
		}

}
