package edu.sopra.training.Ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.Ecommerce.model.Cart_1;
import edu.sopra.training.Ecommerce.model.Product_2;
import edu.sopra.training.Ecommerce.model.WishList;
import edu.sopra.training.Ecommerce.services.AdminService;
import edu.sopra.training.Ecommerce.services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomController {
	
	@Autowired
	CustomerService cs;
	
	//static String name="";
	
	
	@GetMapping("Custlogin")
	//@ResponseBody
	public ModelAndView custlogin() {
		
	//	return new ModelAndView("login.jsp");
		return new ModelAndView("custlogin.jsp");
	}
	
	@PostMapping("Custlogin")
	public ModelAndView custlogin(String user,String passwrd,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		if (cs.custcheck(user, passwrd)){
			request.getSession().setAttribute("name",user);
			mv.setViewName("custindex.jsp");
		}
		else {
			mv.addObject("err","Invalid Credentials!!!");
			mv.setViewName("custlogin.jsp");
		}
		return mv;
	}
	
	@GetMapping("CustReg")
	public ModelAndView forcustreg() {
		
		return new ModelAndView("custreg.jsp");
	}

	
	
	
	@PostMapping("CustReg")
	public ModelAndView toCustreg(String fname,String lname,String email,String uname,String pass,String dob,String gender) {
		
		ModelAndView mv=new ModelAndView();
		if (cs.custreg(fname, lname,email,uname,pass,dob,gender)){
			mv.setViewName("custlogin.jsp");
		}
		else {
			mv.addObject("err","Invalid Credentials!!!");
			mv.setViewName("custlogin.jsp");
		}
		return mv;
	}
	
//	@GetMapping("/")
//	public ModelAndView custindex() {
//		
//		return new ModelAndView("custindex.jsp");
//	}
	@GetMapping("CustIndex")
	public ModelAndView forcustindex() {
		
		return new ModelAndView("custindex.jsp");
	}
	@GetMapping("CustSearch")
	public ModelAndView forcustsearch() {
		
		return new ModelAndView("custsearch.jsp");
	}
	
	@PostMapping("CustSearch")
	public ModelAndView toSearch(String search) {
		
		ModelAndView mv=new ModelAndView();
		List<Product_2> li=(List<Product_2>)cs.custsearchProduct(search);
		if(!li.isEmpty()) {
			   mv.addObject("list",li);
			   mv.addObject("pfounf","Product found!!!");
			   mv.setViewName("custsearch.jsp");
		}
		else {
			mv.addObject("list",li);
			mv.addObject("pnotFound","Product not found!!!");
			mv.setViewName("custsearch.jsp");
		}
		return mv;
	}
	
	@GetMapping("CustView")
	public ModelAndView toView() {
		
		ModelAndView mv=new ModelAndView();
		List<Product_2> li=(List<Product_2>)cs.viewProduct();
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
				mv.setViewName("custview.jsp");
		}
		else {
			mv.addObject("err","No Product Present!!!");
			mv.setViewName("custview.jsp");
		}
		return mv;
	}
	
	@GetMapping("SearchBuy")
	public ModelAndView tosearchbuy(int id) {
		
		ModelAndView mv=new ModelAndView();
		Optional<Product_2> p=(Optional<Product_2>)cs.searcheditProduct(id);
	    mv.addObject("product",p.get());
	    mv.setViewName("searchbuy.jsp");
		return mv;
	}
	
	@PostMapping("SearchBuy")
	public ModelAndView searchbuy(int id,int quan) {
		
		ModelAndView mv=new ModelAndView();
	    if(cs.buyProduct(id,quan)) {
	    	mv.addObject("buy","Product Bought SucessFully !!!");
				mv.setViewName("custsearch.jsp");
		}
		else {
			mv.addObject("err","Invalid Product Quantity!!!");
			mv.setViewName("searchbuy.jsp");
		}
		return mv;
		
	}
	
	@GetMapping("ViewBuy")
	public ModelAndView toviewbuy(int id) {
		
		ModelAndView mv=new ModelAndView();
		Optional<Product_2> p=(Optional<Product_2>)cs.searcheditProduct(id);
	    mv.addObject("product",p.get());
	    mv.setViewName("viewbuy.jsp");
		return mv;
	}
	
	@PostMapping("ViewBuy")
	public ModelAndView viewbuy(int id,int quan) {
		
		ModelAndView mv=new ModelAndView();
	    if(cs.buyProduct(id,quan)) {
	    	    mv.addObject("buy","Product Bought SucessFully !!!");
	    		List<Product_2> li=(List<Product_2>)cs.viewProduct();
	    		System.out.println(li);
	    	    if(!li.isEmpty()) {
	    			    mv.addObject("list",li);
	    				mv.setViewName("custview.jsp");
	    		}
	    		else {
	    			mv.addObject("err","No Product Present!!!");
	    			mv.setViewName("custview.jsp");
	    		}
	    		return mv;
				
		}
		else {
			mv.addObject("err","Invalid Product Quantity!!!");
			mv.setViewName("viewbuy.jsp");
		}
		return mv;
		
	}
	
	@GetMapping("ViewAddToCart")
	public ModelAndView  toViewaddcart(int id,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		cs.addtoProduct(id,request.getSession());
	    mv.addObject("cart","Product is Added to the Cart!!!");
	    
		List<Product_2> li=(List<Product_2>)cs.viewProduct();
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    mv.addObject("cart","Product is Added to the Cart!!!");
				mv.setViewName("custview.jsp");
		}
		else {
			mv.addObject("err","No Product Present!!!");
			mv.setViewName("custview.jsp");
		}
		return mv;
		
		
	}
//	@GetMapping("CustCart")
//	public ModelAndView tocart() {
//		
//			
//			return new ModelAndView("custcart.jsp");
//		
//		
//	}
	@GetMapping("CustCart")	
     public ModelAndView toViewCart(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		List<Cart_1> li=(List<Cart_1>)cs.viewCart(request.getSession());
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    //mv.addObject("err","No Product Present in cart!!!");
				mv.setViewName("custcart.jsp");
		}
		else {
			mv.addObject("err","No Product Present in cart!!!");
			mv.setViewName("custcart.jsp");
		}
		return mv;
	}
	@GetMapping("SearchAddToCart")
	public ModelAndView  toSeacrhaddcart(int id,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		cs.addtoProduct(id,request.getSession());
	    mv.addObject("cart","Product is Added to the Cart!!!");
	    mv.setViewName("custsearch.jsp");
		return mv;
		
		
	}
	@GetMapping("SearchWishList")
	public ModelAndView  toSeacrhaddwish(int id,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		if(cs.addwishProduct(id,request.getSession())) {
	    mv.addObject("cart","Product is Added to WishList!!!");
	    mv.setViewName("custsearch.jsp");
		}
		else {
			mv.addObject("err","Product is Already in WishList!!!");
		    mv.setViewName("custsearch.jsp");
		}
		return mv;
		
		
	}
	
	
	@GetMapping("ViewWishList")
	public ModelAndView  toViewaddwish(int id,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		if(cs.addwishProduct(id,request.getSession())) {
		    mv.addObject("cart","Product is Added to WishList!!!");
		    
			}
			else {
				mv.addObject("err","Product is Already in WishList!!!");
			   
			}
		List<Product_2> li=(List<Product_2>)cs.viewProduct();
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    
				mv.setViewName("custview.jsp");
		}
		else {
			
			mv.setViewName("custview.jsp");
		}
		return mv;
		
		
	}
	
	
	@GetMapping("CustWish")	
    public ModelAndView toViewWish(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		List<WishList> li=(List<WishList>)cs.viewWish(request.getSession());
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    //mv.addObject("err","No Product Present in cart!!!");
				mv.setViewName("wishlist.jsp");
		}
		else {
			mv.addObject("err","No Product Present in wishlist!!!");
			mv.setViewName("wishlist.jsp");
		}
		return mv;
	}
	@GetMapping("EditCartQuantity")
    public ModelAndView tocartQuan(int id,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		Cart_1 c=(Cart_1)cs.editcartProduct(id,request.getSession());
		Product_2 p=cs.searchcartProduct(id);
	    mv.addObject("product",p);
	    mv.addObject("cart",c);
	    mv.setViewName("editcartQuan.jsp");
		return mv;
	}
	@PostMapping("EditCartQuantity")
	public ModelAndView tocartQuant(int id,int quan,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		cs.addeditQuan(id,quan,request.getSession());
		List<Cart_1> li=(List<Cart_1>)cs.viewCart(request.getSession());
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    //mv.addObject("err","No Product Present in cart!!!");
				mv.setViewName("custcart.jsp");
		}
		else {
			mv.addObject("err","No Product Present in cart!!!");
			mv.setViewName("custcart.jsp");
		}
		return mv;
		
	}
	
	@GetMapping("CartDelete")
	public ModelAndView edit(int id,HttpServletRequest request) {
		
		
		
		
		ModelAndView mv=new ModelAndView();
		cs.deletecartProduct(id,request.getSession());
		List<Cart_1> li=(List<Cart_1>)cs.viewCart(request.getSession());
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    //mv.addObject("err","No Product Present in cart!!!");
				mv.setViewName("custcart.jsp");
		}
		else {
			mv.addObject("err","No Product Present in cart!!!");
			mv.setViewName("custcart.jsp");
		}
		return mv;
		
	}
	
	
	@GetMapping("WishDelete")
	public ModelAndView delwish(int id,HttpServletRequest request) {
		
		
		
		
		ModelAndView mv=new ModelAndView();
		cs.deletewishProduct(id,request.getSession());
		List<WishList> li=(List<WishList>)cs.viewWish(request.getSession());
		System.out.println(li);
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    //mv.addObject("err","No Product Present in cart!!!");
				mv.setViewName("wishlist.jsp");
		}
		else {
			mv.addObject("err","No Product Present in cart!!!");
			mv.setViewName("wishlist.jsp");
		}
		return mv;
		
	}
	
	

	@GetMapping("MoveCart")
	public ModelAndView movewish(int id,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		cs.addtocartProduct(id,request.getSession());
	    mv.addObject("cart","Product is Added to the Cart!!!");
	    
	    List<WishList> li=(List<WishList>)cs.viewWish(request.getSession());
		
	    if(!li.isEmpty()) {
			    mv.addObject("list",li);
			    //mv.addObject("err","No Product Present in cart!!!");
				mv.setViewName("wishlist.jsp");
		}
		else {
			mv.addObject("err","No Product Present in wishlist!!!");
			mv.setViewName("wishlist.jsp");
		}
		return mv;
		
	}
	
	
	@PostMapping("CartBuy")
	public ModelAndView viewbuy(int id,HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
	    if(cs.buycartProduct(id,request.getSession())) {
	    	List<Cart_1> li=(List<Cart_1>)cs.viewCart(request.getSession());
			System.out.println(li);
		    if(!li.isEmpty()) {
				    mv.addObject("list",li);
				    //mv.addObject("err","No Product Present in cart!!!");
					mv.setViewName("custcart.jsp");
			}
			else {
				mv.addObject("err","No Product Present in cart!!!");
				mv.setViewName("custcart.jsp");
			}
			return mv;
				
		}
		else {
			List<Cart_1> li=(List<Cart_1>)cs.viewCart(request.getSession());
			System.out.println(li);
		    if(!li.isEmpty()) {
				    mv.addObject("list",li);
				    //mv.addObject("err","No Product Present in cart!!!");
					mv.setViewName("custcart.jsp");
			
			mv.addObject("err","Invalid Product Quantity!!!");
			mv.setViewName("custcart.jsp");
		}
		return mv;
		
	}
	}
	

}
