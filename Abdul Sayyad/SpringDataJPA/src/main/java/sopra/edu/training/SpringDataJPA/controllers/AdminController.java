package sopra.edu.training.SpringDataJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sopra.edu.training.SpringDataJPA.Services.AdminService;
import sopra.edu.training.SpringDataJPA.models.Product;

@Controller
public class AdminController {
	

	@RequestMapping("/")
public ModelAndView start() {
	return new ModelAndView("identity.jsp");
}
	@Autowired
	AdminService admin;
	
	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin(String uname,String pass) {
		ModelAndView mv = new ModelAndView();
		if(admin.adminLogin(uname, pass)) {
			mv.setViewName("home.jsp");
		}
		else {
			mv.addObject("msg", "<h1 style = 'color:red'>Invalid Credentials</h1>");
			mv.setViewName("adminlogin.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/action")
	public ModelAndView Adminaction(String choice) {
		ModelAndView mv = new ModelAndView();
		if(choice.equals("Create")) {
			mv.setViewName("create.jsp");
		}
		else if(choice.equals("Search")) {
			mv.setViewName("search.jsp");
		}
		else if(choice.equals("View")) {
			return this.adminView();
		}
		else if(choice.equals("Log Out")) {
			mv.setViewName("identity.jsp");
		}else if(choice.equals("Customer List")) {
			return this.customerList();
		}
		return mv;
	}
	@RequestMapping("/Create")
	public ModelAndView create(int pid,String pname,String pdesc,int pquant,int pprice) {
		if(admin.addproduct(pid,pname,pdesc,pquant,pprice)) {
			return new ModelAndView("create.jsp");
		}else {
			return new ModelAndView("create.jsp").addObject("msg", "<h3 style = 'color:red'>Invalid Details</h3>");
		}
	}
	@RequestMapping("/Search")
	public ModelAndView search(int pid) {
		ModelAndView mv= new ModelAndView("search.jsp");
		Product p = admin.searchProduct(pid);
		if(p!=null) {
		mv.addObject("pid", p.getpId());
		mv.addObject("pname", p.getProductName());
		mv.addObject("pdesc", p.getProductDesc());
		mv.addObject("pquant", p.getProductQuant());
		mv.addObject("pprice", p.getProductPrice());
		}
		else {
			mv.addObject("msg","<h2 style = 'color:red'>Product Not Found</h2>");
		}
		return mv;
	}
	public ModelAndView adminView() {
		ModelAndView mv = new ModelAndView("view.jsp");
		mv.addObject("products", admin.viewProducts());
		return mv;
	}
	
	@RequestMapping("/Delete")
	public ModelAndView delete(int pid) {
		ModelAndView mv = new ModelAndView("view.jsp");
		admin.deleteProduct(pid);
		mv.addObject("products", admin.viewProducts());
		return mv;
	}
	@RequestMapping("/Search2")
	public ModelAndView search2(int pid) {
		ModelAndView mv= new ModelAndView("edit.jsp");
		Product p = admin.searchProduct(pid);
		if(p!=null) {
		mv.addObject("pid", p.getpId());
		mv.addObject("pname", p.getProductName());
		mv.addObject("pdesc", p.getProductDesc());
		mv.addObject("pquant", p.getProductQuant());
		mv.addObject("pprice", p.getProductPrice());
		}
		else {
			mv.addObject("msg","Product Not Found");
		}
		return mv;
	}

	
	@RequestMapping("/Edit")
	public ModelAndView edit(int pid,int pquant,int pprice) {
		ModelAndView mv = new ModelAndView();
		if(admin.editProduct(pid,pquant,pprice)) {
			mv.addObject("products", admin.viewProducts());
			mv.setViewName("view.jsp");
			return mv;
		}
		mv.addObject("msg", "<h3 style = 'color:red'>Invalid value</h3>");
		mv.setViewName("Search2");
		return mv;
	}
	
	  public ModelAndView  customerList() {
	    	ModelAndView mv = new ModelAndView();
	    	mv.addObject("emaillist",admin.Newuser());
	    	mv.addObject("emaillist1",admin.Accept());
	    	mv.addObject("emaillist2",admin.Deny());
	    	mv.setViewName("customerlist.jsp");
	    	return mv;
	    }
	
	  @RequestMapping("/approvelogin")
	  public ModelAndView approvelogin(String email) {
		  admin.approve(email);
		  return this.customerList();
	  }
	
	  @RequestMapping("/disapprovelogin")
	  public ModelAndView disapprovelogin(String email) {
		  admin.disapprove(email);
		  return this.customerList();
	  }
	
	
}
