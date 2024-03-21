package edu.sopra.training.SpringBootMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sopra.training.SpringBootMVC.model.Cart;
import edu.sopra.training.SpringBootMVC.model.Customer;
import edu.sopra.training.SpringBootMVC.model.Product;
import edu.sopra.training.SpringBootMVC.model.Wishlist;
import edu.sopra.training.SpringBootMVC.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	static String custEmail = null; 
	
	static int buyProdId;
	
	
	@RequestMapping("CustomerRegister")
	public ModelAndView customerRegister(String fname, String lname, String email, String pass, String dob)
	{
		ModelAndView mv = new ModelAndView("CustomerLogin.jsp");
		cs.customerDetails(fname, lname, email, pass, dob);
		return mv;
	}	
	@RequestMapping("LoginButton")
	public ModelAndView customerLogin()
	{
		return new ModelAndView("CustomerLogin.jsp");
	}
	
	@RequestMapping("CustomerLoginPage")
	public ModelAndView customerLoginPage(String email, String psw)
	{
		//Customer c = new Customer();
		
		ModelAndView mv = new ModelAndView();
		if(cs.custLogin(email,psw))
		{
			custEmail = email;
//			HttpSession session = request.getSession();
//        	session.setAttribute("email",email);
			mv.setViewName("CustomerHome.jsp");
		}
		else
		{
			mv.addObject("invalid","Not valid!");
			mv.setViewName("CustomerLogin.jsp");
		}

		return mv;
	}
	
	@RequestMapping("CustomerAction")
	public ModelAndView custAction(String choice)
	{
		ModelAndView mv = new ModelAndView();
		switch(choice)
		{
		case "Search":
			mv.setViewName("CustomerSearch.jsp");
			break;
			
		case "View":
			 List<Product> product_list = cs.listAllProducts();
			 mv.addObject("product_list",product_list);
			mv.setViewName("CustomerView.jsp");
			break;
			
		case "Cart":
			List<Cart> cart_list = cs.listCartProducts(custEmail);
			mv.addObject("cart_list",cart_list);
			mv.setViewName("CustomerCart.jsp");
			break;
		
		case "Wishlist":
			List<Wishlist> wish_list = cs.listWishlistProducts(custEmail);
			mv.addObject("wish_list",wish_list);
			mv.setViewName("CustomerWishlist.jsp");
			break;
			
		case "Logout":
			mv.setViewName("index.jsp");
			break;
		}
		return mv;
	}
	
	@RequestMapping("CustSearchProd")
	public ModelAndView custSearch(String search)
	{
		ModelAndView mv = new ModelAndView();
		Product p = cs.searchProduct(search);
		if(p==null)
		{
			mv.addObject("notFound","Product not available!!!");
			mv.setViewName("CustomerSearch.jsp");
		}
		else
		{
			mv.addObject("product",p);
			mv.setViewName("CustomerSearch.jsp");
		}
		return mv;
	}
	
	
	@RequestMapping("AddToCartProduct")
	public ModelAndView custCart(int cart)
	{
		ModelAndView mv = new ModelAndView();
		cs.saveToCart(cart,custEmail);
		
		List<Product> product_list = cs.listAllProducts();
		mv.addObject("product_list",product_list);
		
		mv.setViewName("CustomerView.jsp");
		return mv;
	}
	
	@RequestMapping("AddToWishlistProduct")
	public ModelAndView custWishlist(int wishlist)
	{
		ModelAndView mv = new ModelAndView();
		cs.saveToWishlist(wishlist,custEmail);
		
		List<Product> product_list = cs.listAllProducts();
		mv.addObject("product_list",product_list);
		
		mv.setViewName("CustomerView.jsp");
		return mv;
	}
	
	@RequestMapping("BuyProduct")
	public ModelAndView custBuy(int buyId)
	{
		buyProdId = buyId;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CustomerBuyQuantity.jsp");
		return mv;
	}
	
	@RequestMapping("BuyQuantity")
	public ModelAndView buyQuantity(int quantity)
	{
		ModelAndView mv = new ModelAndView();
		cs.buyProduct(quantity,buyProdId);
		
		List<Product> product_list = cs.listAllProducts();
		mv.addObject("product_list",product_list);
		 
		mv.setViewName("CustomerView.jsp");
		return mv;
	}
	
	@RequestMapping("DeleteFromCart")
	public ModelAndView deleteFromCart(int delete)
	{
		ModelAndView mv = new ModelAndView();
		List<Cart> cart = cs.deleteFromCart(delete,custEmail);
		mv.addObject("cart_list",cart);
		mv.setViewName("CustomerCart.jsp");
		return mv;
	}
	
	@RequestMapping("DeleteFromWishlist")
	public ModelAndView deleteFromWishlist(int delete)
	{
		ModelAndView mv = new ModelAndView();
		List<Wishlist> wishlist = cs.deleteFromWishlist(delete,custEmail);
		mv.addObject("wish_list",wishlist);
		mv.setViewName("CustomerWishlist.jsp");
		return mv;
	}
	
	@RequestMapping("MoveToWishlist")
	public ModelAndView moveToWishlist(int move) {
		ModelAndView mv = new ModelAndView();
		cs.saveToWishlist(move,custEmail);
		List<Cart> cart = cs.deleteFromCart(move, custEmail);
		mv.addObject("cart_list",cart);
		mv.setViewName("CustomerCart.jsp");
		return mv;
	}
	
	@RequestMapping("MoveToCart")
	public ModelAndView moveToCart(int move) {
		ModelAndView mv = new ModelAndView();
		cs.saveToCart(move,custEmail);
		List<Wishlist> wishlist = cs.deleteFromWishlist(move,custEmail);
		mv.addObject("wish_list",wishlist);
		mv.setViewName("CustomerWishlist.jsp");
		return mv;
	}
	
	@RequestMapping("BuyFromCart")
	public ModelAndView buyFromCart(int buy)
	{
		buyProdId = buy;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CustomerBuyQuantity.jsp");
		return mv;
	}
	
	@RequestMapping("CustomerBuyAll")
	public ModelAndView buyAll()
	{
		ModelAndView mv = new ModelAndView();
		
		
		cs.buyAllProducts(custEmail);
		List<Cart> cart_list = cs.listCartProducts(custEmail);
		mv.addObject("cart_list",cart_list);
		mv.setViewName("CustomerCart.jsp");
		return mv;
	}
	

}
