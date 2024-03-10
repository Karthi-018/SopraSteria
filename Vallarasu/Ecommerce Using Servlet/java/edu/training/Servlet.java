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
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	product p=new product();
	List<product> productList=new ArrayList<>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(request.getParameter("Name")!=null)
				productList.add(new product((int)Integer.parseInt(request.getParameter("id").toString())
				,request.getParameter("Name"),
				request.getParameter("Description"),(int)Integer.parseInt(request.getParameter("Price").toString()),
				(int)Integer.parseInt(request.getParameter("Quantity").toString())));
		PrintWriter o=response.getWriter();
		o.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<style>\r\n"
				+ "div {\r\n"
				+ "  width:400px;\r\n"
				+ "  height:150px;\r\n"
				+ "  margin:auto;\r\n"
				+ "    background-color: navy;\r\n"
				+ "    border: solid black;\r\n"
				+ "    border-radius:50px;\r\n"
				+ "}\r\n"
				+ "label{\r\n"
				+ "color:white;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "<center>\r\n"
				+ "<form action=\"MyServlet\" method=\"post\">\r\n"
				+ "<div><label>Product id  </label><input type=\"text\" name=\"id\" value=\"\" placeholder=\"Enter the ProductID\">\r\n"
				+ "<br><label>Product Name  </label><input type=\"text\" name=\"Name\" value=\"\" placeholder=\"Enter the Product Name\">\r\n"
				+ "<br><label>Product Description  </label><input type=\"text\" name=\"Description\" value=\"\" placeholder=\"Enter the Product Description\">\r\n"
				+ "<br><label>Product Price  </label><input type=\"text\" name=\"Price\" value=\"\" placeholder=\"Enter the Product Price\">\r\n"
				+ "<br><label>Product Quantity  </label><input type=\"text\" name=\"Quantity\" value=\"\" placeholder=\"Enter the Product Quantity\">\r\n"
				+ "<br><input type=\"Submit\"/></div>\r\n"
				+ "</form></center>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		o.println("<br><br>");
		
		o.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Ecommerce</title>\r\n"
				+ "</head>\r\n"
				+ "<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border:1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<h2>Product table</h2>\r\n"
				+ "\r\n"
				+ "<table style=\"width:100%\">\r\n"
				+ "  <tr>\r\n"
				+ "    <th>ProductID</th>\r\n"
				+ "    <th>ProductName</th>\r\n"
				+ "    <th>Description</th>\r\n"
				+ "    <th>Price</th>\r\n"
				+ "    <th>Quantity</th>\r\n"
				+ "    <th></th>\r\n"
				+ "  </tr>");
		if(request.getParameter("del")!=null)
		{
			for(int i=0;i<productList.size();i++)
				if(productList.get(i).getPid()==Integer.parseInt(request.getParameter("del")))
				productList.remove(i);
		}
			
		for(product p:productList)
		{
			o.println("<tr>\r\n"
					+ "    <td>"+p.getPid()+"</td>\r\n"
					+ "    <td>"+p.getPname()+"</td>\r\n"
					+ "    <td>"+p.getDesc()+"</td>\r\n"
					+ "    <td>"+p.getPrice()+"</td>\r\n"
					+ "    <td>"+p.getQuantity()+"</td>\r\n"
					+ "    <td><form action=\"MyServlet\" method=\"post\"><input type=\"hidden\" name=\"del\" value="+p.getPid()+"><input type=\"submit\" value=\"DELETE\"></form></td>\r\n"
					+ "  </tr>");
		}
		
		o.println("</table>\r\n");
		o.println("  <form action=\"MyServlet\" method=\"post\">\r\n"
				+ " <input type=\"text\" name=\"search\" placeholder=\"Enter the Productname\" />\r\n"
				+ " <input type=\"submit\" value=\"Search\"/></form>");

		if(request.getParameter("search")!=null)
		{
			o.println("<h2>Product table</h2>\r\n"
					+ "\r\n"
					+ "<table style=\"width:100%\">\r\n"
					+ "  <tr>\r\n"
					+ "    <th>ProductID</th>\r\n"
					+ "    <th>ProductName</th>\r\n"
					+ "    <th>Description</th>\r\n"
					+ "    <th>Price</th>\r\n"
					+ "    <th>Quantity</th>\r\n"
					+ "  </tr>");
			
			for(product p:productList)
			{
				if(p.getPname().equalsIgnoreCase(request.getParameter("search")))
					o.println("<tr>\r\n"
							+ "    <td>"+p.getPid()+"</td>\r\n"
							+ "    <td>"+p.getPname()+"</td>\r\n"
							+ "    <td>"+p.getDesc()+"</td>\r\n"
							+ "    <td>"+p.getPrice()+"</td>\r\n"
							+ "    <td>"+p.getQuantity()+"</td>\r\n"
							+ "  </tr>");
			}
			o.println("</table>\r\n");
		}
		o.println("</body>\r\n"
				+ "</html>");
	}
}
