package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.BranchElement;

/**
 * Servlet implementation class ecom
 */
//@WebServlet("/ecom")
public class ecom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<keshavecom>  obj=new ArrayList<>();
	private String border;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ecom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\r\n"
				+ "    pageEncoding=\"UTF-8\"%>\r\n"
				+ "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form action=\"/ecom\" >\r\n"
				+ "<label>product id</label>\r\n"
				+ "<input type=\"number\" name=\"productid\" ><br><br>\r\n"
				+ "<label>product name</label>\r\n"
				+ "<input type=\"text\" name=\"productname\"><br><br>\r\n"
				+ "<label>product desc</label>\r\n"
				+ "<input type=\"text\" name=\"productdesc\"><br><br>\r\n"
				+ "<label>product price</label>\r\n"
				+ "<input type=\"text\" name=\"productprice\"><br><br>\r\n"
				+ "<label>product quantity</label>\r\n"
				+ "<input type=\"text\" name=\"productquantity\" ><br><br>\r\n"
				+ "<input type=\"submit\" name=\"demo\" value=\"add\"><br><br>\r\n"
				+ "<label>search</label>\r\n"
				+ "<input type=\"number\" name=\"demo\" value=\"search\">\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String num=request.getParameter("demo");
		
		if(num.equals("add")) {
			int productid=Integer.parseInt(request.getParameter("productid"));
			int productprice=Integer.parseInt(request.getParameter("productprice"));
			int productquantity=Integer.parseInt(request.getParameter("productquantity"));
			String productdesc=request.getParameter("productdesc");
			String productname=request.getParameter("productdesc");
			obj.add(new keshavecom(productname,productprice, productid, productdesc, productquantity));
		    }
		else if(num.equals("search")) {
			boolean flag=false;
		for(keshavecom i:obj) {
			if(Integer.parseInt(request.getParameter("search"))==(i.getproductid())){
				   flag=true;
				
				out.println("<table border=\"1\">\r\n"
						+ "  <thead>\r\n"
						+ "    <tr>\r\n"
						+ "      <th>ProductId</th>\r\n"
						+ "      <th>ProductName</th>\r\n"
						+ "      <th>ProductDesc</th>\r\n"
						+ "      <th>ProductQuantity</th>\r\n"
						+ "      <th>ProductPrice</th>\r\n"
						+ "    </tr>\r\n"
						+ "  </thead>\r\n"
						+ "  <tbody>\r\n");
				out.println("<tr>\r\n"
						+ "      <td>"+i.getproductid()+"</td>\r\n"
						+ "      <td>"+i.getproductname()+"</td>\r\n"
						+ "      <td>"+i.getproductdesc()+"</td>\r\n"
						+ "      <td>"+i.getproductprice()+"</td>\r\n"
						+ "      <td>"+i.productquantity()+"</td>\r\n"
						+ "    </tr>");
				out.println("</tbody>\r\n"
						+ "</table>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
			}
		}
		if(flag==false) {
			out.println("product not found");
		}
	   }
		if(obj.size()==0) {
			out.println("<div>file empty</div>");
		}
		else if(obj.size()>0) {
			out.println("<br><br><table border=\"1\">\r\n"
					+ "  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "      <th>ProductId</th>\r\n"
					+ "      <th>ProductName</th>\r\n"
					+ "      <th>ProductDesc</th>\r\n"
					+ "      <th>ProductQuantity</th>\r\n"
					+ "      <th>ProductPrice</th>\r\n"
					+ "      <th>action</th>\r\n"
					+ "    </tr>\r\n"
					+ "  </thead>\r\n"
					+ "  <tbody>\r\n");
			for(keshavecom i:obj)	
			out.println("<tr>\r\n"
					+ "      <td>"+i.getproductid()+"</td>\r\n"
					+ "      <td>"+i.getproductname()+"</td>\r\n"
					+ "      <td>"+i.getproductdesc()+"</td>\r\n"
					+ "      <td>"+i.getproductprice()+"</td>\r\n"
					+ "      <td>"+i.productquantity()+"</td>\r\n"
					+ "     <td><form action=''><button type=\"submit\" name=\"method\" value=\""+i.getproductid() +"\">delete</button></form></td>"
					+ "    </tr>");

			out.println("</tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");			
		}
}		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
