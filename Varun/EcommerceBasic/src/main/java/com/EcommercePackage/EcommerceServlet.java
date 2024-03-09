package com.EcommercePackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class EcommerceServlet
 */
//@WebServlet("/EcommerceServlet")
public class EcommerceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EcommerceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    List<Product> li=new ArrayList<>();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String func=request.getParameter("method");
		
		PrintWriter ps=response.getWriter();
		ps.println("<!DOCTYPE html>\r\n"
				+ "				<html>\r\n"
				+ "				<head>\r\n"
				+ "				<meta charset=\"ISO-8859-1\">\r\n"
				+ "				<title>Index page</title>\r\n"
				+ "				</head>\r\n"
				+ "				<body>\r\n"
				+ "				<form action=\"EcommerceServlet\">\r\n"
				+ "				<label>Product name</label>\r\n"
				+ "				<br>\r\n"
				+ "				<input type=\"text\" name=\"pname\">\r\n"
				+ "				<br>\r\n"
				+ "				<label>Product description</label>\r\n"
				+ "				<br>\r\n"
				+ "				<input type=\"text\" name=\"pdesc\">\r\n"
				+ "				<br>\r\n"
				+ "				<label>Product price</label>\r\n"
				+ "				<br>\r\n"
				+ "				<input type=\"number\" name=\"pprice\">\r\n"
				+ "				<br>\r\n"
				+ "				<label>Product quantity</label>\r\n"
				+ "				<br>\r\n"
				+ "				<input type=\"number\" name=\"pquantity\">\r\n"
				+ "				<br>\r\n"
				+ "				<br>\r\n"
				+ "\r\n<input type=\"submit\" name='method' value=\"ADD\">\r\n"
				+ "<br>\r\n"
				+ "<br>\r\n"
				+ "	</form>\r\n"
				+ "<form action=\"EcommerceServlet\">\r\n"
				+ "<input type=\"text\" name=\"product\">\r\n"
				+ "\r\n"
				+ "<input type=\"submit\" name = \"method\"  value=\"SEARCH\">\r\n"
				+ "</form>"
				+ "				</body>\r\n"
				+ "				</html>");
		
		
		
		switch(func)
		{
		case "ADD":
			String name = null;
		    String desc = null;
		    int price = 0;
		    int quantity = 0;
			name=request.getParameter("pname");
			desc=request.getParameter("pdesc");
			price=Integer.parseInt(request.getParameter("pprice"));
			quantity=Integer.parseInt(request.getParameter("pquantity"));
			li.add(new Product(name,desc,price,quantity));
			//addmethod(name,desc,price,quantity,ps);
			ps.println("<html><body>"
					+ "<br>\r\n"
					+ "<br>\r\n"
					+ "<table style='border:1px solid black'>"
					+ "<tr style='border:1px solid black'>"
					+ "<th>| Product Name |</th>"
					+ "<th>| Product Desc |</th>"
					+ "<th>| Product Price |</th>"
					+ "<th>| Product Quantity |</th>"
					+ "</tr>");
			for(int i =0;i<li.size();i++)
			{
				Product p = li.get(i);
				ps.println("<tr style='border:1px solid black'>"
						+ "<td>"+p.getPname()+"</td>"
						+ "<td>"+p.getPdescription()+"</td>"
						+ "<td>"+p.getPprice()+"</td>"
						+ "<td>"+p.getPquantity()+"</td>"
						+ "</tr>");
			}
			
			
			
			
			ps.println("</table></body></html>");
			break;
			
		case "SEARCH":
			String searchEle=request.getParameter("product");
			for(Product i:li)
			{
				if(i.getPname().equals(searchEle))
				{
					ps.println(i.getPname()+"  "+i.getPdescription()+"   "+i.getPprice()+"  "+i.getPquantity());
				}
			}
			break;
		}
		
		
		
		
		
		
	    
		
	
	}
	
	
	
//	public void addmethod(String name,String desc,int price,int quantity,PrintWriter ps)
//	{
//		
//
//		
//		li.add(new Product(name,desc,price,quantity));
////		li.add(new Product(name,desc,price,quantity));
//		
////		request.setAttribute("li",li);
////		RequestDispatcher rd=request.getRequestDispatcher();
////		rd.forward(request, response);
//		
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
