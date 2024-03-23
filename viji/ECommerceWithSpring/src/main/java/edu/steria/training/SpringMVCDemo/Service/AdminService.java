package edu.steria.training.SpringMVCDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.steria.training.SpringMVCDemo.Model.Admin;
import edu.steria.training.SpringMVCDemo.Model.Customer;
import edu.steria.training.SpringMVCDemo.Model.Product;
import edu.steria.training.SpringMVCDemo.Repository.AdminRepository;
import edu.steria.training.SpringMVCDemo.Repository.CustomerRepository;
import edu.steria.training.SpringMVCDemo.Repository.ProductRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repo;
	@Autowired
	ProductRepository pr;
	@Autowired
	CustomerRepository cus;
	public boolean validate(String uname,String pass)
	{
		
		boolean flag=false;
		List<Admin> adminList=(List<Admin>)repo.findAll();
		for(Admin admin:adminList)
		{
			if(uname.equals(admin.getUsername())&&pass.equals(admin.getPassword()))
			{
				flag= true;
			}
		}
		return flag;
	}
    public boolean add(String name,String uname,String pass)
    {
    	boolean flag=true;
    	int check=0;
    	List<Admin> adminList=(List<Admin>)repo.findAll();
    	for(Admin admin:adminList)
		{
			if(uname.equals(admin.getUsername())&&name.equals(admin.getName()))
			{
				check=1;
				break;
			}
			
		}
    	if(check==1)
    	{
    		flag= false;
    	}
    	else
    	{
    		Admin ad=new Admin(name,uname,pass);
    		repo.save(ad);
    	}
    	return flag;
    }
    public boolean addProduct(String name,String descp,double price,int quant)
    {
    	boolean flag=true;
    	Product product=pr.findByPname(name);
    	if(product==null)
    	{
    		Product pro=new Product(name,descp,price,quant);
			pr.save(pro);
  	    }
    	else
    	{
    	    flag=false;
   	     }
		
    	return flag;
    }
    public List<Product> getList()
    {
    	List<Product> productList=(List<Product>)pr.findAll();
    	return productList;
    }
    public List<Customer> getCustList()
    
    {
    	List<Customer> customerList=(List<Customer>)cus.findAll();
    	return customerList;
    }
    public Product search(String name)
    {
    	Product findProduct=pr.findByPname(name);
    	
    	return findProduct;
    }
    public void delete(int id)
    {
    	pr.deleteById(id);
    }
    public Product fetchData(int id)
    {
    	Product p=(Product)pr.findById(id);
    	return p;
    }
    public void editData(int id,double price,int quant) {
    	Product p=pr.findById(id);
    	p.setPrice(price);
    	p.setQuantity(quant);
    	pr.save(p);
    	
    }
    public void activate(String uname)
    {
    	Customer c=(Customer)cus.findByUsername(uname);
    	if(c.getStatus().equals("InActive"))
    	{
    	c.setStatus("Active");
    	cus.save(c);
    	}
    	else
    	{
    		c.setStatus("InActive");
    		cus.save(c);
    	}
    }
}
