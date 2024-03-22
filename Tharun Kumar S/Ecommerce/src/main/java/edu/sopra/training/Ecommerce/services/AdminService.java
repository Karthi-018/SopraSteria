package edu.sopra.training.Ecommerce.services;
import edu.sopra.training.Ecommerce.model.Product_2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.Ecommerce.model.Admin_1;
import edu.sopra.training.Ecommerce.model.Cust_2;
import edu.sopra.training.Ecommerce.model.Product_2;
import edu.sopra.training.Ecommerce.repository.AdminRepository;
import edu.sopra.training.Ecommerce.repository.CustomerRepository;
import edu.sopra.training.Ecommerce.repository.ProductRepository;

@Service
public class AdminService {
	@Autowired
	ProductRepository pr;
	@Autowired
	AdminRepository ar;
	@Autowired
	CustomerRepository cr;
	
	public boolean check(String admin,String passwrd) {
		
		List<Admin_1> l1= (List<Admin_1>) ar.findByAdminName(admin);
		for(Admin_1 a:l1) {
		
		if((a.getAdminName()).equals(admin) && (a.getAdminPass().equals(passwrd))) {	
			
			return true;
		 }
		
		}
		return false;
	}
	public boolean addProduct(int id,String pname,String descp,int quan,int price) {
		//try {
		List<Product_2> l1= (List<Product_2>) pr.findAll();
		if(l1!=null){
		for(Product_2 a:l1) {
		if((a.getPid())==id) {
			return false;
		 }
		}
		}
		
		Product_2 p=new Product_2(id,pname,descp,quan,price);
		pr.save(p);
		return true;
	}
	
	public List<Product_2> searchProduct(String pname){
		
		List<Product_2> l1= (List<Product_2>)pr.findByPname(pname);
		System.out.println(l1);
		return l1;
			
	}
    public List<Product_2> viewProduct(){
		
		List<Product_2> l1= (List<Product_2>)pr.findAll();
		return l1;
			
	}
	public Optional<Product_2> searcheditProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product_2> p=pr.findById(id);
		return p;
	}
	public boolean editProduct(int id, int price, int quan) {
		
		Product_2 p=(Product_2)pr.findByPid(id);
		
		
		p.setQuan(quan);
		p.setPrice(price);
		pr.save(p);
		
		return true;
	}
	public List<Product_2> deleteProduct(int id) {
		// TODO Auto-generated method stub
		pr.delete(pr.findByPid(id));
		return this.viewProduct();
		
	}
	public List<Cust_2> viewCust() {
		// TODO Auto-generated method stub
		List<Cust_2> l1= (List<Cust_2>)cr.findAll();
		return l1;
	}
	public List<Cust_2> accessCust(String status) {
		// TODO Auto-generated method stub@GetMapping("CustAcc")
		Cust_2 c=(Cust_2)cr.findByUserName(status);
		if((c.getStatus().equals("De-Active")) || (c.getStatus().equals("New"))) {
			c.setStatus("Active");
			cr.save(c);
			return viewCust();
		}
		else {
			c.setStatus("De-Active");
			cr.save(c);
			return viewCust();
		}
		
		
	}
	}
		
	


