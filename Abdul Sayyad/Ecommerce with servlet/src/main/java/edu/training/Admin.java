package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	List<product> list = new ArrayList<>();

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
//		out.println("<!DOCTYPE html>\r\n"
//				+ "<html>\r\n"
//				+ "<head>\r\n"
//				+ "<meta charset=\"UTF-8\">\r\n"
//				+ "<title>Ecommerce</title>\r\n"
//				+ "</head>\r\n"
//				+ "<body>\r\n"
//				+ "<form action = \"Admin\" method = 'post'>\r\n"
//				+ "<label>Product Id</label><br><input type = \"number\" name = \"pid\" ><br>\r\n"
//				+ "<label>Product Name</label><br><input type = \"text\" name = \"pname\" ><br>\r\n"
//				+ "<label>Product Desc</label><br><input type = \"text\" name = \"pdesc\" ><br>\r\n"
//				+ "<label>Product Quantity</label><br><input type = \"number\" name = \"pquant\" ><br>\r\n"
//				+ "<label>Product Price</label><br><input type = \"number\" name = \"pprice\" ><br><br>\r\n"
//				+ "<input type = \"submit\" name = \"method\" value = \"Add\">\r\n"
//				+ "<br>\r\n"
//				+ "<form action = \"Admin\">\r\n"
//				+ "<br><br><br><input type = \"text\" name = \"pname1\" placeholder = 'Enter product name'><br><br>\r\n"
//				+ "<input type = \"submit\" name = \"method\"  value= \"search\">\r\n"
//				+ "</form>\r\n"
//				+ "</form>\r\n"
//				+ "</body>\r\n"
//				+ "</html>");
		String op = request.getParameter("method");
		if(op!="" && !op.equals("Add") && !op.equals("search")) {
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Ecommerce</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<form action = \"Admin\" method = 'post'>\r\n"
					+ "<label>Product Id</label><br><input type = \"number\" name = \"pid\" ><br>\r\n"
					+ "<label>Product Name</label><br><input type = \"text\" name = \"pname\" ><br>\r\n"
					+ "<label>Product Desc</label><br><input type = \"text\" name = \"pdesc\" ><br>\r\n"
					+ "<label>Product Quantity</label><br><input type = \"number\" name = \"pquant\" ><br>\r\n"
					+ "<label>Product Price</label><br><input type = \"number\" name = \"pprice\" ><br><br>\r\n"
					+ "<input type = \"submit\" name = \"method\" value = \"Add\">\r\n"
					+ "<br>\r\n"
					+ "<form action = \"Admin\">\r\n"
					+ "<br><br><br><input type = \"text\" name = \"pname1\" placeholder = 'Enter product name'><br><br>\r\n"
					+ "<input type = \"submit\" name = \"method\"  value= \"search\">\r\n"
					+ "</form>\r\n"
					+ "</form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			String name = op;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getProductName().equals(name)) {
					list.remove(i);
					break;
				}
			}
		}
		switch(op) {
		case "Add":{
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Ecommerce</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<form action = \"Admin\" method = 'post'>\r\n"
					+ "<label>Product Id</label><br><input type = \"number\" name = \"pid\"><br>\r\n"
					+ "<label>Product Name</label><br><input type = \"text\" name = \"pname\" ><br>\r\n"
					+ "<label>Product Desc</label><br><input type = \"text\" name = \"pdesc\" ><br>\r\n"
					+ "<label>Product Quantity</label><br><input type = \"number\" name = \"pquant\" ><br>\r\n"
					+ "<label>Product Price</label><br><input type = \"number\" name = \"pprice\" ><br><br>\r\n"
					+ "<input type = \"submit\" name = \"method\" value = \"Add\">\r\n"
					+ "<br>\r\n"
					+ "<form action = \"Admin\">\r\n"
					+ "<br><br><br><input type = \"text\" name = \"pname1\" placeholder = 'Enter product name'><br><br>\r\n"
					+ "<input type = \"submit\" name = \"method\"  value= \"search\">\r\n"
					+ "</form>\r\n"
					+ "</form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			   list.add(new product(Integer.parseInt(request.getParameter("pid")) , request.getParameter("pname"),
					   request.getParameter("pdesc"),Integer.parseInt(request.getParameter("pquant")),
					   Integer.parseInt(request.getParameter("pprice"))));	
			   break;
		}
		case "search":{
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Ecommerce</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<form action = \"Admin\" method = 'post'>\r\n"
					+ "<label>Product Id</label><br><input type = \"number\" name = \"pid\" required><br>\r\n"
					+ "<label>Product Name</label><br><input type = \"text\" name = \"pname\" required><br>\r\n"
					+ "<label>Product Desc</label><br><input type = \"text\" name = \"pdesc\" required><br>\r\n"
					+ "<label>Product Quantity</label><br><input type = \"number\" name = \"pquant\" required><br>\r\n"
					+ "<label>Product Price</label><br><input type = \"number\" name = \"pprice\" required><br><br>\r\n"
					+ "<input type = \"submit\" name = \"method\" value = \"Add\">\r\n"
					+ "<br>\r\n"
					+ "<form action = \"Admin\">\r\n"
					+ "<br><br><br><input type = \"text\" name = \"pname1\" placeholder = 'Enter product name'><br><br>\r\n"
					+ "<input type = \"submit\" name = \"method\"  value= \"search\">\r\n"
					+ "</form>\r\n"
					+ "</form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			String productName = request.getParameter("pname1");
			product p =null;
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getProductName().equals(productName)) {
					p = list.get(i);
				}
			}
		
			if(p!=null) {
			out.println("<h3>Searched product</h3><table> \r\n"
					+ "<tr>\r\n"
					+ "<th>| Product Id |</th>\r\n"
					+ "<th>| Product Name |</th>\r\n"
					+ "<th>| Product Desc |</th>\r\n"
					+ "<th>| Product Quantity |</th>\r\n"
					+ "<th>| Product price |</th>\r\n"
					+ "<th>| Action |</th>\r\n"
					+ "</tr>\r\n"
					+ "<td>"+ p.getProductId()+"</td>\r\n"
					+ "<td>"+p.getProductName()+"</td>\r\n"
					+ "<td>"+p.getProductDesc()+"</td>\r\n"
					+ "<td>"+p.getProductQuant()+"</td>\r\n"
					+ "<td>"+p.getProductPrice()+"</td>\r\n"
					+ "<td><form>\r\n"
					+ "\r\n"
					+ "<button type = \"submit\" name = \"method\" value = '"+ p.getProductName()+"'>delete\r\n </button>"
					+ "</form></td>\r\n"
					+ "</table>");
			}
			else {
				out.println("<p>No products</p>");
			}
			break;
		}
		}
		if(!list.isEmpty()) {
			out.println("<h3>All products</h3>");
			product p = null;
			for(int i=0;i<list.size();i++) {
				p = list.get(i);
				out.println("<table> \r\n"
						+ "<tr>\r\n"
						+ "<th>| Product Id |</th>\r\n"
						+ "<th>| Product Name |</th>\r\n"
						+ "<th>| Product Desc |</th>\r\n"
						+ "<th>| Product Quantity |</th>\r\n"
						+ "<th>| Product price |</th>\r\n"
						+ "<th>| Action |</th>\r\n"
						+ "</tr>\r\n"
						+ "<td>"+ p.getProductId()+"</td>\r\n"
						+ "<td>"+p.getProductName()+"</td>\r\n"
						+ "<td>"+p.getProductDesc()+"</td>\r\n"
						+ "<td>"+p.getProductQuant()+"</td>\r\n"
						+ "<td>"+p.getProductPrice()+"</td>\r\n"
						+ "<td><form>\r\n"
						+ "\r\n"
						+ "<button type = \"submit\" name = \"method\" value = '"+ p.getProductName()+"'>delete\r\n </button>"
						
						+ "</form></td>\r\n"
						+ "</table>");
			}
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
