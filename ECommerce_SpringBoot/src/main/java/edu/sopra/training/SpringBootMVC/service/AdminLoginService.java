package edu.sopra.training.SpringBootMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.SpringBootMVC.model.AdminLogin;
import edu.sopra.training.SpringBootMVC.model.Customer;
import edu.sopra.training.SpringBootMVC.model.Product;
import edu.sopra.training.SpringBootMVC.repository.AdminRepository;
import edu.sopra.training.SpringBootMVC.repository.CustomerRepository;
import edu.sopra.training.SpringBootMVC.repository.ProductRepository;

@Service
public class AdminLoginService {
	
	@Autowired
	AdminRepository ar;
	@Autowired
	ProductRepository pr;
	@Autowired
	CustomerRepository cr;


	public boolean adminLogin(String name, String psw)
	{
		AdminLogin a = new AdminLogin();
		
		List<AdminLogin> loginList = (List<AdminLogin>) ar.findAll();
		
		for(AdminLogin i:loginList)
		{
			if(i.getUsername().equals(name) && i.getPassword().equals(psw))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public String chooseFromMenu(String choice)//Create Search View ValidateCustomer Logout
	{
		switch(choice)
		{
		case "Create":
			return "AdminCreateProduct.jsp";
		case "Search":
			return "AdminSearch.jsp";
		case "View":
			return "AdminView";
		case "Logout":
			return "AdminLogin.jsp";	
		}
		return null;
	}
	
	public List<Product> listAllProducts()
	{
		List<Product> product = (List<Product>)pr.findAll();
		return product;
	}
	

	public void saveProductDetails(int id, String name, String descr, int price, int quantity) {
		
		Product p = new Product();
		p.setpId(id);
		p.setName(name);
		p.setDesc(descr);
		p.setPrice(price);
		p.setQuantity(quantity);
		
		pr.save(p);
		
	}

	public Product searchProduct(String search) {
		List<Product> product = pr.findByName(search);
		for(Product p:product)
		{
			if(p.getName().equals(search))
			{
				return p;
			}
		}
		return null;
	}

	public List<Product> deleteProduct(int id) {
		pr.delete(pr.findBypId(id));
		return this.listAllProducts();
	}

	public Product getProductDetails(int id) {
		Product product = pr.findById(id);
		return product;
		
	}

	public List<Product> updateProductDetails(int id, int price, int quantity) {
		Product p = pr.findBypId(id);
		p.setPrice(price);
		p.setQuantity(quantity);
		pr.save(p);
		return this.listAllProducts();
		
	}
	public List<Customer> listNewCustomers() {
		// TODO Auto-generated method stub
		List<Customer> NewCustomers = (List<Customer>)cr.findByStatus("New");
		return NewCustomers;
	}
	public List<Customer> listActiveCustomers() {
		// TODO Auto-generated method stub
		List<Customer> activeCustomers = (List<Customer>)cr.findByStatus("active");
		return activeCustomers;
	}
	public List<Customer> listInactiveCustomers() {
		// TODO Auto-generated method stub
		List<Customer> inactiveCustomers = (List<Customer>)cr.findByStatus("inactive");
		return inactiveCustomers;
	}

	public void validateCustomer(int id) {
		
		Customer c = cr.findBycustId(id);
		c.setStatus("active");
		cr.save(c);
		
	}

	public void invalidateCustomer(int id) {
		
		Customer c = cr.findBycustId(id);
		c.setStatus("inactive");
		cr.save(c);
	}
	
}
