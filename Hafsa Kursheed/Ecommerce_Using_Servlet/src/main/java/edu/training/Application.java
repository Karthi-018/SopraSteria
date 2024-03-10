package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Application
 */
//@WebServlet("/Application")

public class Application extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Product> prodList = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Application() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+"<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border:1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>"
				+ "<title>Ecommerce</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "<center>\r\n"
				+ "	<h1>Welcome to Ecommerce Application</h1>\r\n"
				+ "</center>\r\n"
				+ "<form action=\"Application\" method=\"post\">\r\n"
				+ "\r\n"
				+ "	<label>Enter Product ID:</label>\r\n"
				+ "	<input type = \"number\" name = \"pid\" placeholder =\"Product ID\"/><br><br>\r\n"
				+ "	\r\n"
				+ "	<label>Enter Product Name:</label>\r\n"
				+ "	<input type=\"text\" name=\"pname\" placeholder = \"Product Name\"/><br><br>\r\n"
				+ "	\r\n"
				+ "	<label>Enter Product Description:</label>\r\n"
				+ "	<input type=\"text\" name=\"pdesc\" placeholder = \"Product Description\"/><br><br>\r\n"
				+ "	\r\n"
				+ "	<label>Enter Product Price:</label>\r\n"
				+ "	<input type=\"number\" name=\"pprice\" placeholder = \"Product Price\"/><br><br>\r\n"
				+ "	\r\n"
				+ "	<label>Enter Product Quantity:</label>\r\n"
				+ "	<input type=\"number\" name=\"pquant\" placeholder = \"Product Quantity\"/><br><br>\r\n"
				+ "	\r\n"
				+ "<input type=\"submit\" name = \"option\" value=\"Add\"/>\r\n"
				+ "<input type=\"reset\" value=\"Reset\"/>\r\n"
				+ "\r\n"
				+ "<br><br><br> \r\n"
				+ "<input type=\"number\" placeholder=\"Enter Product ID to search\" name=\"searchProd\"/>  \r\n"
				+ "<input type=\"submit\" name=\"option\" value=\"Search\"/>\r\n"
				+ "</form>");
		out.println("<br><br>");
		String opt = request.getParameter("option");
		if(opt.equals("Add"))
		{
			Product po = new Product(Integer.parseInt(request.getParameter("pid")),request.getParameter("pname"),request.getParameter("pdesc"),Integer.parseInt(request.getParameter("pprice")),Integer.parseInt(request.getParameter("pquant")));
			prodList.add(po);
		}
		else if(opt.equals("Search"))
		{
			int pid = Integer.parseInt(request.getParameter("searchProd"));
			boolean flag = true;
			for(int i=0; i<prodList.size();i++)
			{
				if(pid==((prodList.get(i)).getId()))
				{
					out.println("<b>SEARCHED PRODUCT</b>");
					out.println("<br><br>");
					out.println("<table><tr><th>PRODUCT ID</th>" +
							"<th>PRODUCT NAME</th>" +
							"<th>PRODUCT DESC</th>" +
							"<th>PRODUCT PRICE</th>" +
							"<th>PRODUCT QUANTITY</th>"+
							"<th>ACTION</th>" +
							"</tr>"
						);
					out.println("<tr><td>"+prodList.get(i).getId()+ "</td>" +
							"<td>"+prodList.get(i).getName()+ "</td>" +
							"<td>"+prodList.get(i).getDesc()+ "</td>" +
							"<td>"+prodList.get(i).getPrice()+ "</td>" +
							"<td>"+prodList.get(i).getQuantity()+ "</td>" +
							"<td><a href='Application?option="+ prodList.get(i).getId()+"'>Delete</a></td></tr>");
					flag = false;
					break;
				}
			}
			if(flag)
			{
				out.println("<b>NO PRODUCT WITH PRODUCT ID IS PRESENT</b>");
				out.println("<br><br>");
			}
			else
			{
				out.println("</table></body></html>");
				out.println("<br><br>");
			}
		}
		else
		{
			int prid = Integer.parseInt(request.getParameter("option"));

			for(int i=0; i<prodList.size();i++)
			{
				if(prid==((prodList.get(i)).getId()))
				{
					prodList.remove(i);
					
					break;
				}
			}
	}
	if(!prodList.isEmpty())
	{
		out.println("<b>All PRODUCTS<b>");
		out.println("<br><br>");
		out.println("<table><tr><th>PRODUCT ID</th>" +
					"<th>PRODUCT NAME</th>" +
					"<th>PRODUCT DESC</th>" +
					"<th>PRODUCT PRICE</th>" +
					"<th>PRODUCT QUANTITY</th>"+
					"<th>ACTION</th>" +
					"</tr>"
				);
		for(Product p: prodList)
		{
			out.println("<tr><td>"+p.getId()+ "</td>" +
					"<td>"+p.getName()+ "</td>" +
					"<td>"+p.getDesc()+ "</td>" +
					"<td>"+p.getPrice()+ "</td>" +
					"<td>"+p.getQuantity()+ "</td>" +
					"<td><a href='Application?option="+ p.getId()+"'>Delete</a></td></tr>"
					);
		}
	}
	else
	{
		out.println("<b>NO PRODUCTS ARE PRESENT</b>");
	}
		
}
}
	

