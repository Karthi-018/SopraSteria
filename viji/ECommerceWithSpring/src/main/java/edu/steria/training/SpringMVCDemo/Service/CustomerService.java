package edu.steria.training.SpringMVCDemo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.steria.training.SpringMVCDemo.Model.Admin;
import edu.steria.training.SpringMVCDemo.Model.Cart;
import edu.steria.training.SpringMVCDemo.Model.Customer;
import edu.steria.training.SpringMVCDemo.Model.Product;
import edu.steria.training.SpringMVCDemo.Model.WishList;
import edu.steria.training.SpringMVCDemo.Repository.AdminRepository;
import edu.steria.training.SpringMVCDemo.Repository.CartRepository;
import edu.steria.training.SpringMVCDemo.Repository.CustomerRepository;
import edu.steria.training.SpringMVCDemo.Repository.ProductRepository;
import edu.steria.training.SpringMVCDemo.Repository.WishListRepository;

@Service 
public class CustomerService {
	@Autowired
	ProductRepository pr;
	@Autowired
	CustomerRepository cus;
	@Autowired
	CartRepository car;
	@Autowired
	WishListRepository wish;
	public boolean validate(String username,String pass)
	{
		
		boolean flag=false;
		List<Customer> customerList=(List<Customer>)cus.findAll();
		for(Customer cust:customerList)
		{
			if(username.equals(cust.getUsername())&&pass.equals(cust.getPassword())&&cust.getStatus().equals("Active"))
			{
				flag= true;
			}
		}
		return flag;
	}
    public boolean add(String fname,String lname,String email,String uname,String pass,String dob,String gender)
    {
    	boolean flag=true;
    	int check=0;
    	List<Customer> customerList=(List<Customer>)cus.findAll();
    	for(Customer cust:customerList)
		{
			if(uname.equals(cust.getUsername())&&email.equals(cust.getEmail()))
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
    		Customer cust=new Customer(fname,lname,uname,pass,email,dob,gender,"InActive");
    		cus.save(cust);
    	}
    	return flag;
    }
    public List<Product> getList()
    {
    	List<Product> productList=(List<Product>)pr.findAll();
    	return productList;
    }
    public Product search(String name)
    {
    	Product findProduct=pr.findByPname(name);
    	
    	return findProduct;
    }
    public boolean buy(int pid,int quant)
    {
    	Product p=(Product)pr.findById(pid);
    	if(p.getQuantity()>1 && quant<p.getQuantity())
    	{
    		p.setQuantity(p.getQuantity()-quant);
    		pr.save(p);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    public List<Cart> getCartList(String user)
    {
    	
    	List<Cart> cartList=(List<Cart>)car.findByUsername(user);
    	
    	if(!cartList.isEmpty())
    	{
    	  return cartList;
    	}
    	else
    	{
    		return null;
    	}
    }
    public List<Product> getWishList(String user)
    {
    	
    	List<WishList> wishList=(List<WishList>)wish.findByUname(user);
    	List<Product> p=new ArrayList<>();
    	if(!wishList.isEmpty())
    	{
    		for(WishList w:wishList)
    		{
    			Product pro=(Product)pr.findById(w.getProductId());
    			if(pro!=null)
    			{
    				p.add(pro);
    			}
    		}
    	  return p;
    	}
    	else
    	{
    		return null;
    	}
    }
    public void addToCart(int pid,String uname)
    {
    	List<Cart> cartList=(List<Cart>)car.findByUsername(uname);
    	Product p=(Product)pr.findById(pid);
    	int flag=0;
    	for(Cart c:cartList)
    	   {
    		if(c.getProductId()==pid)
    		{
    			flag=1;
    			c.setpQuantity(c.getpQuantity()+1);
    			car.save(c);
    			break;
    		}
    	   }
    	
    	if(flag==0)
    	{
    		Cart cart=new Cart(pid,p.getPname(),p.getDescription(),p.getPrice(),uname,1);
    		car.save(cart);
    	}
    	List<WishList> wishList=(List<WishList>)wish.findByUname(uname);
    	if(!wishList.isEmpty())
    	{
    	for(WishList c:wishList)
 	   {
 		if(c.getProductId()==pid)
 		{
    	wish.deleteById(c.getId());
 		}
 	   }
    	}
    	
    }
    public void deleteCart(int pid,String uname)
    {
    	List<Cart> cartList=(List<Cart>)car.findByUsername(uname);
    	for(Cart c:cartList)
 	   {
 		if(c.getProductId()==pid)
 		{
    	car.deleteById(c.getId());
 		}
 	   }
    }
    public void addToWishList(int pid,String uname)
    {
    	List<WishList> wishList=(List<WishList>)wish.findByUname(uname);
    	Product p=(Product)pr.findById(pid);
    	int flag=0;
    	for(WishList c:wishList)
    	   {
    		if(c.getProductId()==pid)
    		{
    			flag=1;
    			break;
    		}
    	   }
    	
    	if(flag==0)
    	{
    		WishList wishlis=new WishList(pid,uname);
    		wish.save(wishlis);
    	}
    	List<Cart> cartList=(List<Cart>)car.findByUsername(uname);
    	if(!cartList.isEmpty())
    	{
    	for(Cart c:cartList)
 	   {
 		if(c.getProductId()==pid)
 		{
    	car.deleteById(c.getId());
 		}
 	   }
    	}
    	
    }
    public void deleteWishlist(int pid,String uname)
    {
    	List<WishList> wishList=(List<WishList>)wish.findByUname(uname);
    	for(WishList c:wishList)
 	   {
 		if(c.getProductId()==pid)
 		{
    	wish.deleteById(c.getId());
 		}
 	   }
    }
}
