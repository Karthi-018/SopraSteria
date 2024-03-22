package sopra.edu.training.SpringDataJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import sopra.edu.training.SpringDataJPA.Services.CustomerService;
import sopra.edu.training.SpringDataJPA.models.Product;

@Controller
public class CustomerController {
	
	
	
    @Autowired
	CustomerService cus;
    
//    HttpSession session;
    
    
    
    
    @RequestMapping("/cusregister")
    public ModelAndView register(String fname,String lname,String uemail,String passw,String dob,String gender) {
    	
    	ModelAndView mv = new ModelAndView();
    	if(cus.cusRegister(fname, lname, uemail, passw, dob, gender)) {
    		mv.setViewName("cuslogin.jsp");
    		return mv;
    	}
    	mv.addObject("msg", "<h3>User already Present</h3>");
    	mv.setViewName("cusregister.jsp");
    	return mv;
    }
    
    @RequestMapping("/cuslogin")
    public ModelAndView login(String uemail,String pass,HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
    	
		if(cus.cusLogin(uemail, pass)) {
//			this.cusEmail = uemail;
			request.getSession().setAttribute("cusemail", uemail);
			mv.setViewName("home2.jsp");
		}
		else {
			mv.addObject("msg", "<h1 style = 'color:red'>Log In Not Accessible</h1>");
			mv.setViewName("cuslogin.jsp");
		}
		return mv;
    }
    
    @RequestMapping("/action2")
	public ModelAndView Adminaction(String choice1,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(choice1.equals("search")) {
			mv.setViewName("cussearch.jsp");
		}
		else if(choice1.equals("view")) {
			return this.cusView();
		}
		else if(choice1.equals("view Cart")) {
			return this.cusViewCart(request);
		}
		else if(choice1.equals("log out")) {
			mv.setViewName("identity.jsp");
			try {
			request.getSession().invalidate();
			}catch(Exception e){
				
			}
		}else if(choice1.equals("view wishlist")) {
			return this.viewwishlist(request);
		}
		
		return mv;
	}
    @RequestMapping("/Search3")
	public ModelAndView search(String pname) {
		ModelAndView mv= new ModelAndView("cussearch.jsp");
		List<Product> p = cus.searchProduct(pname);
		if(!p.isEmpty()) {
		mv.addObject("products", p);
		}
		else {
			mv.addObject("msg","Product Not Found");
		}
		return mv;
	}
	
    public ModelAndView cusView() {
    	ModelAndView mv = new ModelAndView("view2.jsp");
		mv.addObject("products", cus.viewProducts());
		return mv;
    }
    
    
    @RequestMapping("/buy")
    public ModelAndView cusBuy(int pid,int pquant) {
    	ModelAndView mv = new ModelAndView();
    	if(cus.cusBuy(pid, pquant)) {
        	return this.cusView();
    	}
    		mv.addObject("pid",pid);
    		mv.addObject("msg", "<h3 style = 'color:red'>Product or Quantity Not Available</h3>");
    		mv.setViewName("buy.jsp");
    	return mv;
    }
    
    @RequestMapping("/addcart")
    public ModelAndView addCart(int pid,HttpServletRequest request) {
    	cus.cusAddCart(pid,request.getSession());
    	return this.cusView();
    }
    
    
    public ModelAndView cusViewCart(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
    	List<Product> list = cus.viewcart(request.getSession());
    	mv.addObject("totalcost", cus.calcCost(list));
    	mv.addObject("products",list );
    	mv.setViewName("viewcart.jsp");
    	return mv;
    }
    
    @RequestMapping("/addwishlist")
    public ModelAndView addWishList(int pid,HttpServletRequest request) {
    	cus.addwishlist(pid,request.getSession());
    	return this.cusView();
    }
    
    public ModelAndView viewwishlist(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("products", cus.viewWishlist(request.getSession()));
    	mv.setViewName("viewwishlist.jsp");
    	return mv;
    }
    
    @RequestMapping("/buyall")
    public ModelAndView buyAll(HttpServletRequest request) {
    	cus.buyAll(request.getSession());
    	return this.cusViewCart(request);
    }
    
    @RequestMapping("/deletecart")
    public ModelAndView deleteCart(int pid,HttpServletRequest request) {
    	cus.deleteCart(pid,request.getSession());
    	return this.cusViewCart(request);
    }
    
    @RequestMapping("/deletewishlist")
    public ModelAndView deleteWishList(int pid,HttpServletRequest request) {
    	cus.deleteWishList(pid,request.getSession());
    	return this.viewwishlist(request);
    }
    
    @RequestMapping("/movecart")
    public ModelAndView moveCart(int pid,HttpServletRequest request) {
    	cus.moveCart(pid,request.getSession());
    	return this.viewwishlist(request);
    }
    
    @RequestMapping("/movewishlist")
    public ModelAndView moveWishlist(int pid,HttpServletRequest request) {
    	cus.moveWishlist(pid,request.getSession());
    	return this.cusViewCart(request);
    }
    
     
  
    
}
