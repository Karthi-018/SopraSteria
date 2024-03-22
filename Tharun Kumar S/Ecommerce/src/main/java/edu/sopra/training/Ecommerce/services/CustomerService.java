package edu.sopra.training.Ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sopra.training.Ecommerce.model.Admin_1;
import edu.sopra.training.Ecommerce.model.Cart_1;
import edu.sopra.training.Ecommerce.model.Cust_2;
import edu.sopra.training.Ecommerce.model.Product_2;
import edu.sopra.training.Ecommerce.model.WishList;
import edu.sopra.training.Ecommerce.repository.CartRepository;
import edu.sopra.training.Ecommerce.repository.CustomerRepository;
import edu.sopra.training.Ecommerce.repository.ProductRepository;
import edu.sopra.training.Ecommerce.repository.WishlistRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CustomerService {
	
	@Autowired
	ProductRepository pr;
	
	
	@Autowired
	CustomerRepository cr;
	
	@Autowired
	CartRepository car;
	
	@Autowired
	WishlistRepository wr;
	
	
  public boolean custcheck(String user,String passwrd) {
		
		Cust_2 a= (Cust_2)cr.findByUserName(user);
		
		if((a.getUserName()).equals(user) && (a.getPassword().equals(passwrd)) && (a.getStatus()).equals("Active")) {	
			
			return true;
		 }
		return false;
	}


public boolean custreg(String fname, String lname, String email, String uname, String pass, String dob, String gender) {
	// TODO Auto-generated method stub
	Cust_2 l1= (Cust_2) cr.findByUserName(uname);
	if(l1==null) {
		Cust_2 c=new Cust_2(fname,lname,email,uname,pass,dob,gender,"New",0);
		cr.save(c);
		return true;
	}
	return false;
	
}


public List<Product_2> custsearchProduct(String pname) {
	// TODO Auto-generated method stub
	List<Product_2> l1= (List<Product_2>)pr.findByPname(pname);
	List<Product_2> l2= new ArrayList<Product_2>();
	for(Product_2 ps:l1) {
		if(ps.getQuan()!=0) {
			l2.add(ps);
		}
	}
	//System.out.println(l1);
	return l2;
}


public List<Product_2> viewProduct() {
	// TODO Auto-generated method stub
	List<Product_2> l1= (List<Product_2>)pr.findAll();
	List<Product_2> l2= new ArrayList<Product_2>();
	for(Product_2 ps:l1) {
		if(ps.getQuan()!=0) {
			l2.add(ps);
		}
	}
	//System.out.println(l1);
	return l2;
}


public Optional<Product_2> searcheditProduct(int id) {
	// TODO Auto-generated method stub
	Optional<Product_2> p=(Optional<Product_2>)pr.findById(id);
	return p;
}


public boolean buyProduct(int id, int quan) {
	Product_2 p=(Product_2)pr.findByPid(id);
	
	if((p.getQuan())>=quan) {
	p.setQuan((p.getQuan())-quan);
	pr.save(p);
	
	return true;
	}
	return false;
	// TODO Auto-generated method stub
	
}


public void addtoProduct(int id,HttpSession session) {
	// TODO Auto-generated method stub
	System.out.println((String)session.getAttribute("name"));
	List<Cart_1> c1=(List<Cart_1>)car.findByUser((String)session.getAttribute("name"));
	boolean flag=false;
	Product_2 p1=(Product_2)pr.findByPid(id);
	for(Cart_1 p:c1) {
		if(p.getPid()==id) {
			Cart_1 c=(Cart_1)car.findByPid(id);
			
			int qu=c.getQuant()+1;
			int pri=c.getPrice()+p1.getPrice();
			c.setQuant(qu);
			c.setPrice(pri);
			car.save(c);
			flag=true;
		}
	}
	if(flag==false) {
	Cart_1 c=new Cart_1((String)session.getAttribute("name"),p1.getPid(),p1.getPname(),p1.getDescp(),1,p1.getPrice());
	car.save(c);	
	}
}


public List<Cart_1> viewCart(HttpSession session) {
	// TODO Auto-generated method stub
	String user=(String)session.getAttribute("name");
	List<Cart_1> l1= (List<Cart_1>)car.findByUser(user);
//	List<Cart_1> l2=new ArrayList<Cart_1>();
//	for(Cart_1 a:l1) {
//		if(a.getUser().equals(user)) {
//			l2.add(a);
//		}
//	}
//	System.out.println(l2);
//	System.out.println(l1);
	
	return l1;
	
	
}


public boolean addwishProduct(int id, HttpSession session) {
	System.out.println((String)session.getAttribute("name"));
	List<WishList> c1=(List<WishList>)wr.findByUsername((String)session.getAttribute("name"));
	boolean flag=true;
	Product_2 p1=(Product_2)pr.findByPid(id);
	for(WishList p:c1) {
		if(p.getPid()==id) {
			
			flag=false;
		}
	}
	if(flag==true) {
	WishList c=new WishList((String)session.getAttribute("name"),p1.getPid(),p1.getPname(),p1.getPrice());
	wr.save(c);	
	}
	
	return flag;
}

public List<WishList> viewWish(HttpSession session) {
//	// TODO Auto-generated method stub
	String username=(String)session.getAttribute("name");
	List<WishList> l1=(List<WishList>)wr.findByUsername(username);
	
	return l1;
}


public Cart_1 editcartProduct(int id, HttpSession session) {
	// TODO Auto-generated method stub
	String username=(String)session.getAttribute("name");
	List<Cart_1> l1=(List<Cart_1>)car.findByUser(username);
	for(Cart_1 c:l1) {
		if(c.getPid()==id) {
			return c;
		}
	}
	return null;
	
	
}


public void addeditQuan(int id, int quan, HttpSession session) {
	// TODO Auto-generated method stub
	String username=(String)session.getAttribute("name");
	List<Cart_1> l1=(List<Cart_1>)car.findByUser(username);
	for(Cart_1 c:l1) {
		if(c.getPid()==id) {
			c.setQuant(quan);
			Product_2 p1=(Product_2)pr.findByPid(id);
			int p=p1.getPrice()*quan;
			c.setPrice(p);
			car.save(c);
		}
	}
}

public Product_2 searchcartProduct(int id) {
	// TODO Auto-generated method stub
	Product_2 p=(Product_2)pr.findByPid(id);
	return p;
}


public void deletecartProduct(int id, HttpSession session) {
	// TODO Auto-generated method stub
	String username=(String)session.getAttribute("name");
	List<Cart_1> l1=(List<Cart_1>)car.findByUser(username);
	for(Cart_1 c:l1) {
		if(c.getPid()==id) {
			car.delete(car.findByPid(id));
		}
}

}


public void deletewishProduct(int id, HttpSession session) {
	String username=(String)session.getAttribute("name");
	List<WishList> l1=(List<WishList>)wr.findByUsername(username);
	for(WishList c:l1) {
		if(c.getPid()==id) {
			wr.delete(wr.findByPid(id));
		}
}
	// TODO Auto-generated method stub
	
}


public void addtocartProduct(int id, HttpSession session) {
	
	// TODO Auto-generated method stub
	String username=(String)session.getAttribute("name");
	List<Cart_1> c1=(List<Cart_1>)car.findByUser(username);
	boolean flag=false;
	Product_2 p1=(Product_2)pr.findByPid(id);
	for(Cart_1 p:c1) {
		if(p.getPid()==id) {
			Cart_1 c=(Cart_1)car.findByPid(id);
			
			int qu=c.getQuant()+1;
			int pri=c.getPrice()+p1.getPrice();
			c.setQuant(qu);
			c.setPrice(pri);
			car.save(c);
			flag=true;
		}
	}
	if(flag==false) {
	Cart_1 c=new Cart_1((String)session.getAttribute("name"),p1.getPid(),p1.getPname(),p1.getDescp(),1,p1.getPrice());
	car.save(c);	
	}

	List<WishList> l1=(List<WishList>)wr.findByUsername(username);
	for(WishList c:l1) {
		if(c.getPid()==id) {
			wr.delete(wr.findByPid(id));
		}
}
	
}


public boolean buycartProduct(int id, HttpSession session) {
	// TODO Auto-generated method stub
    Product_2 p=(Product_2)pr.findByPid(id);
    System.out.println(id);
    String username=(String)session.getAttribute("name");
	List<Cart_1> c1=(List<Cart_1>)car.findByUser(username);
	for(Cart_1 c:c1) {
		
		if(c.getPid()==id) {
			
	       if((p.getQuan())>=(c.getQuant())) {
	    	       int quan=(p.getQuan())-(c.getQuant());
	    	       System.out.println(c.getQuant());
	               p.setQuan(quan);
	               pr.save(p);
	               
	           	   car.delete(car.findByPid(id));
	           		
	               return true;
	               
	           }
	       
	      }
		
	}
	return false;
}

	
}

