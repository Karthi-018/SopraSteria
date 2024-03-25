package edu.sopra.training.SpringBootMVC.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sopra.training.SpringBootMVC.controllers.CustomerControl;
import edu.sopra.training.SpringBootMVC.model.Cart;
import edu.sopra.training.SpringBootMVC.model.Customer;
import edu.sopra.training.SpringBootMVC.model.Wishlist;
import edu.sopra.training.SpringBootMVC.model.product;
import edu.sopra.training.SpringBootMVC.respositories.CartRepository;
import edu.sopra.training.SpringBootMVC.respositories.CustomerRepository;
import edu.sopra.training.SpringBootMVC.respositories.ProductRepository;
import edu.sopra.training.SpringBootMVC.respositories.WishlistRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository rpo;
	
	@Autowired
	ProductRepository repos;
	
	@Autowired
	CartRepository carts;
	
	@Autowired
	WishlistRepository wish;
	
	private static String email=CustomerControl.email;
	
	public boolean logincust(String email,String password) {
		
		Customer a = rpo.findByEmail(email);
		
		if(a!=null && password.equals(a.getPassword())) {
			return true;
		}
		else {
			return false;
		}
		
	} 
	
	public void addDatabase(String email,String fname,String lname,String password) {
		
		Customer c=new Customer();
		
		c.setEmail(email);
		c.setFname(fname);
		c.setLname(lname);
		c.setPassword(password);
		
		rpo.save(c);
	}
	
	public List<product> viewProduct(){
		
		List<product> list= new ArrayList<>();
		
		list=(List<product>) repos.findAll();
		
		
		return list;
	}
	
	public List<product> searchName(String pname){
		
		return repos.findByPname(pname);
	}
	
	 
	public void addCart(int pid){
		List<Cart> ca = carts.findByemail(CustomerControl.email);
		for(Cart c:ca) {
			if(c.getProductId() == pid) {
				product p = repos.findBypid(pid);
				if(p.getQty()>c.getQuantity()+1) {
					
					c.setQuantity(c.getQuantity()+1);
					carts.save(c);
				}
				return;
			
			
			}
		}
		
		Cart c = new Cart();
		c.setEmail(CustomerControl.email);
		c.setQuantity(1);
		c.setProductId(pid);
		carts.save(c);
		
	}
	

	
	public List<product> viewCart(String email){
		
		List<product> list= new ArrayList<>();
		
		list=(List<product>) carts.findByProductInCart(email);
		
		return list;
	}
	
	public void addWishlist(int pid){
		List<Wishlist> ca = wish.findByemail(email);
		for(Wishlist c:ca) {
			if(c.getProductId() == pid) {
				wish.save(c);
				return;
			
			}
		}
		
		Wishlist c = new Wishlist();
		c.setEmail(email);
		c.setProductId(pid);
		wish.save(c);
		
	}
	
	public List<product> viewWish(String email){
		
		List<product> list= new ArrayList<>();
		
		list=(List<product>) wish.findByProductInWish(email);
		
		return list;
	}
	
	public product buyPage(int pid) {
		
		product p=repos.findBypid(pid);
		
		return p;
	}
	
	public int buyDone(int pid,int qty,int confirm) {
		product p= repos.findBypid(pid);
		int flag=0;
		if (p != null) {
            int updatedQty = p.getQty() - qty;
            if (confirm==1 && updatedQty > 0) {
                p.setQty(updatedQty);
                repos.save(p);
                flag=1;
            } else {
                repos.delete(p);
            }
        }
		return flag;
	}
	
	public void deleteCartItem(int pid) {
		
		carts.deleteById(pid);
	}
	
	public void deleteWishItem(int pid) {
		
		wish.deleteById(pid);
	}
	
	public void buyAll() {
   	 List<Cart> list = carts.findByemail(CustomerControl.email);
		if(!list.isEmpty()) {
			for(Cart c:list) {
				product p = repos.findBypid(c.getProductId());
				p.setQty(p.getQty()-c.getQuantity());
				repos.save(p);
				carts.delete(c);
			}
		}
    }
	
}
