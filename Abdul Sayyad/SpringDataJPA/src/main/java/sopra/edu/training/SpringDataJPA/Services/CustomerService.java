package sopra.edu.training.SpringDataJPA.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sopra.edu.training.SpringDataJPA.controllers.CustomerController;
import sopra.edu.training.SpringDataJPA.models.Cart;
import sopra.edu.training.SpringDataJPA.models.Customer;
import sopra.edu.training.SpringDataJPA.models.Product;
import sopra.edu.training.SpringDataJPA.models.Wishlist;
import sopra.edu.training.SpringDataJPA.repositories.CartRepo;
import sopra.edu.training.SpringDataJPA.repositories.CustomerRepo;
import sopra.edu.training.SpringDataJPA.repositories.ProductRepo;
import sopra.edu.training.SpringDataJPA.repositories.WishListRepo;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo repo;
	@Autowired
	ProductRepo repo1;
	
	@Autowired
	CartRepo repo2;
	
	@Autowired
	WishListRepo repo3;
	
	
	public boolean cusRegister(String fname,String lname,String uemail,String passw,String dob,String gender) {
		
		Customer c = new Customer(uemail,fname,lname,passw,dob,gender);
		try {
		repo.save(c);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean cusLogin(String uemail,String pass) {
		Customer c = repo.findByUserEmail(uemail);
		return c.getUserPassWord().equals(pass) && c.getAccess().equals("accept");
	}
	
	
	public List<Product> searchProduct(String pname) {
		return repo1.findByProductName(pname);
	}
	
	
	
	public List<Product> viewProducts(){
		return (List<Product>)repo1.findAll();
	}
	
	
	@RequestMapping("/buy")
	public boolean cusBuy(int pid,int pquant) {
		Product p = repo1.findBypId(pid);
		if(pquant<=0)return false;
		if(pquant<p.getProductQuant()) {
			p.setProductQuant(p.getProductQuant()-pquant);
			repo1.save(p);
			return true;
		}
		return false;
		
	}
	
	public void cusAddCart(int pid,HttpSession session) {
		List<Cart> list = repo2.findByuserEmail((String)session.getAttribute("cusemail"));
		Product p = repo1.findBypId(pid);
		if(p.getProductQuant()<1)return;
		if(!list.isEmpty()) {
		for(Cart c1:list) {
			if(c1.getpId() == pid) {
				if(p.getProductQuant()>=c1.getQuantity()+1) {
				c1.setQuantity(c1.getQuantity()+1);
				repo2.save(c1);
				}
				return;
			}
		}
		}
			Cart c = new Cart();
			c.setpId(pid);
			c.setQuantity(1);
			c.setUserEmail((String)session.getAttribute("cusemail"));
			repo2.save(c);
	}
	
	public List<Product> viewcart(HttpSession session){
		List<Cart> list = repo2.findByuserEmail((String)session.getAttribute("cusemail"));
		List<Product> list1 = new ArrayList<>();
		if(!list.isEmpty()) {
			for(Cart c:list) {
				Product p = repo1.findBypId(c.getpId());
				p.setProductQuant(c.getQuantity());
				list1.add(p);
			}
		}
		return list1;
		
	
	}
     public int calcCost(List<Product> list) {
    	 int cost = 0;
    	 if(!list.isEmpty()) {
    	 for(Product p:list) {
    		 cost+=(p.getProductPrice()*p.getProductQuant());
    	 }
    	 }
    	 return cost;
	}
     
     public void addwishlist(int pid,HttpSession session) {
 		List<Wishlist> list = repo3.findByuemail((String)session.getAttribute("cusemail"));
 		for(Wishlist w:list) {
 			if(w.getPid()==pid)return;
 		}
 		Wishlist w = new Wishlist();
 		w.setPid(pid);
 		w.setUemail((String)session.getAttribute("cusemail"));
 		repo3.save(w);
     }
	
     public List<Product> viewWishlist(HttpSession session){
    	 List<Wishlist> list = repo3.findByuemail((String)session.getAttribute("cusemail"));
 		List<Product> list1 = new ArrayList<>();
 		if(!list.isEmpty()) {
 			for(Wishlist w:list) {
 				Product p = repo1.findBypId(w.getPid());
 				list1.add(p);
 			}
 		}
 		return list1;
     }
     public void buyAll(HttpSession session) {
    	 List<Cart> list = repo2.findByuserEmail((String)session.getAttribute("cusemail"));
 		if(!list.isEmpty()) {
 			for(Cart c:list) {
 				Product p = repo1.findBypId(c.getpId());
 				p.setProductQuant(p.getProductQuant()-c.getQuantity());
 				repo1.save(p);
 				repo2.delete(c);
 			}
 		}
     }
     public void deleteCart(int pid,HttpSession session) {
    	 List<Cart> list = repo2.findByuserEmail((String)session.getAttribute("cusemail"));
 		if(!list.isEmpty()) 
 			for(Cart c:list) {
 				if(c.getpId() == pid) {repo2.delete(c); return ;}
 			}
 		}
     
     
     
     public void deleteWishList(int pid,HttpSession session) {
    	 List<Wishlist> list = repo3.findByuemail((String)session.getAttribute("cusemail"));
 		if(!list.isEmpty()) {
 			for(Wishlist w:list) {
 				if(w.getPid() == pid) {
 				repo3.delete(w);
 				return ;
 				}
 			}
 		}
     }
     
     public void moveCart(int pid,HttpSession session) {
    	 this.cusAddCart(pid,session);
    	 this.deleteWishList(pid,session);
     }
     
     public void moveWishlist(int pid,HttpSession session) {
    	 this.addwishlist(pid,session);
    	 this.deleteCart(pid,session);
     }
     
     
     
}
