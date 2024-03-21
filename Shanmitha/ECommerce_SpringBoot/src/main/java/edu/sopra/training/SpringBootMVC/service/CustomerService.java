package edu.sopra.training.SpringBootMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sopra.training.SpringBootMVC.model.AdminLogin;
import edu.sopra.training.SpringBootMVC.model.Cart;
import edu.sopra.training.SpringBootMVC.model.Customer;
import edu.sopra.training.SpringBootMVC.model.Product;
import edu.sopra.training.SpringBootMVC.model.Wishlist;
import edu.sopra.training.SpringBootMVC.repository.CartRepository;
import edu.sopra.training.SpringBootMVC.repository.CustomerRepository;
import edu.sopra.training.SpringBootMVC.repository.ProductRepository;
import edu.sopra.training.SpringBootMVC.repository.WishlistRepository;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository cr;
	
	@Autowired
	ProductRepository pr;
	
	@Autowired
	CartRepository car;
	
	@Autowired
	WishlistRepository wr;
	
	public void customerDetails(String fname, String lname, String email, String pass, String dob) {
		Customer c = new Customer();
		c.setFname(fname);
		c.setLname(lname);
		c.setEmail(email);
		c.setPass(pass);
		c.setDob(dob);
		cr.save(c);

	}
	public boolean custLogin(String email, String psw) {

		List<Customer> loginList = (List<Customer>) cr.findAll();
		
		for(Customer i:loginList)
		{
			if((i.getEmail().equals(email) && i.getPass().equals(psw)) && i.getStatus().equals("active"))
			{
				return true;
			}
		}
		
		return false;
		
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
	public List<Product> listAllProducts() {
		List<Product> product = (List<Product>)pr.findAll();
		return product;
	}
	
	public void buyProduct(int requiredQuantity, int buyProdId) {
		
		Product product = pr.findBypId(buyProdId);
		int old_quantity = product.getQuantity();

		if(old_quantity+1>requiredQuantity)
		{
			product.setQuantity(old_quantity-requiredQuantity);
		}
		pr.save(product);
	}
	
	public void saveToCart(int prodId, String custEmail) {
		
		List<Cart> products = (List<Cart>)car.findAll();
		int flag = 0;
		for(Cart c:products)
		{
			if(c.getProductId()==prodId)//product already present in cart
			{
				Product p = pr.findBypId(prodId);
				if(p.getQuantity()>=c.getQuantity()+1) {
					c.setQuantity(c.getQuantity()+1);
					car.save(c);
				}
				return;
			}
		}
		
		Product product = pr.findBypId(prodId);
		int prodPrice = product.getPrice();
		String prodName = product.getName();
		Cart cart = new Cart();
		cart.setEmail(custEmail);
		cart.setProductId(prodId);
		cart.setQuantity(1);
		cart.setPrice(prodPrice);
		cart.setProdName(prodName);
		
		car.save(cart);
	}
	public List<Cart> listCartProducts(String custEmail) {
		
		List<Cart> cart = (List<Cart>) car.findByemail(custEmail);
		//List<Cart> cart = (List<Cart>)car.findAll();
		return cart;
	}
	
	public List<Wishlist> listWishlistProducts(String custEmail) {

		List<Wishlist> wishlist = (List<Wishlist>)wr.findByemail(custEmail);
		return wishlist;
	}
	
	public void saveToWishlist(int prodId, String custEmail) {
		
		List<Wishlist> products = (List<Wishlist>)wr.findAll();
		int flag = 0;
		for(Wishlist w:products)
		{
			if(w.getProductId()==prodId)//product already present in wishlist
			{
				flag = 1;
				break;
			}
		}
		if(flag==0)
		{
		Product product = pr.findBypId(prodId);
		int prodQuantity = product.getQuantity();
		int prodPrice = product.getPrice();
		String prodName = product.getName();
		
		Wishlist wish = new Wishlist();
		wish.setEmail(custEmail);
		wish.setProductId(prodId);
		wish.setQuantity(prodQuantity);
		wish.setPrice(prodPrice);
		wish.setProdName(prodName);
		
		wr.save(wish);
		}
		
	}
	public List<Cart> deleteFromCart(int prodId, String custEmail) {
		
		List<Cart> products = (List<Cart>) car.findByemail(custEmail);
		for(Cart c:products)
		{
			int id = c.getProductId();
			if(prodId==id)
			{
				car.delete(c);
				break;
			}
		}
		return this.listCartProducts(custEmail);
		
	}
	public List<Wishlist> deleteFromWishlist(int prodId, String custEmail) {

		List<Wishlist> products = (List<Wishlist>) wr.findByemail(custEmail);
		for(Wishlist c:products)
		{
			int id = c.getProductId();
			if(prodId==id)
			{
				wr.delete(c);
				break;
			}
		}
		return this.listWishlistProducts(custEmail);
	}
	
	public void buyAllProducts(String custEmail) {
		List<Cart> cartProd = (List<Cart>)car.findByemail(custEmail);
		
		for(Cart c:cartProd)
		{
			Product p = (Product)pr.findBypId(c.getProductId());
			p.setQuantity(p.getQuantity()-c.getQuantity());
			pr.save(p);
			car.delete(c);
		}
		
		
	}
}
