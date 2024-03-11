package edu.learning;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assignment
 */
@WebServlet("/Assignment")
public class Assignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Pojo> li=new ArrayList<>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form action=\"test\">\r\n"
				+ "<label>Product id</label>\r\n"
				+ "<input type=\"text\" name=\"pid\"><br>\r\n"
				+ "\r\n"
				+ "<label>Product Name</label>\r\n"
				+ "<input type=\"text\" name=\"pname\"><br>\r\n"
				+ "\r\n"
				+ "<label>Product Desc</label>\r\n"
				+ "<input type=\"text\" name=\"pdesc\"><br>\r\n"
				+ "\r\n"
				+ "<label>Product Price</label>\r\n"
				+ "<input type=\"text\" name=\"pprice\"><br>\r\n"
				+ "\r\n"
				+ "<label>Product Quantity</label>\r\n"
				+ "<input type=\"text\" name=\"pqty\"><br>\r\n"
				+ "\r\n"
				+ "<input type=\"submit\" name=\"uname\" value=\"add\"><br>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "<input type=\"text\" name=\"search\"><br>\r\n"
				+ "<input type=\"submit\" name=\"uname\" value=\"search\">\r\n"
				+ "\r\n"
				+ "<input type=\"reset\">\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		   
		String option=request.getParameter("uname");
		if(option.equals("add"))
		{
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		String pdesc=request.getParameter("pdesc");
		int pprice=Integer.parseInt(request.getParameter("pprice"));
		int pqty=Integer.parseInt(request.getParameter("pqty"));
		Pojo p=new Pojo(pid,pname,pdesc,pprice,pqty);
		li.add(p);
		out.println("<table border =\" 2px\" >"
				+ "<thead><tr>\r\n"
				+ " <th>Product_Id</th>\r\n"
				+ " <th>Product_Name</th>\r\n"
				+ " <th>Product_Description</th>\r\n"
				+ " <th>Product_Price</th>\r\n"
				+ " <th>Product_Quantity</th>\r\n"
				+ "</tr> "
				+"</thead>"
				+"<tbody>");
		  for(Pojo i:li)
		  {
		   out.println("<tr>\r\n"
				+ " <td>"+i.getProduct_id()+"</td>\r\n"
				+ " <td>"+i.getProduct_name()+"</td>\r\n"
				+ " <td>"+i.getProduct_desc()+"</td>\r\n"
				+ " <td>"+i.getProduct_price()+"</td>\r\n"
				+ " <td>"+i.getProduct_qty()+"</td>\r\n"
			    + " <td><form action=''><button type=\"submit\"name=\"option\" value=\""+i.getProduct_id()+"\">DELETE</button></form></td>\r\n"
				+ "</tr>");
		  }
	      out.println("</tbody></table>");
		}
		else if(option.equals("search")) {
		    String search = request.getParameter("search");
		    boolean found = false; 
		    for (Pojo p : li) {
		        if (search.equals(p.getProduct_name())) {
		            found = true;
		            out.println("<table border =\" 2px\" >"
		                            + "<thead><tr>\r\n"
		                            + " <th>Product_Id</th>\r\n"
		                            + " <th>Product_Name</th>\r\n"
		                            + " <th>Product_Description</th>\r\n"
		                            + " <th>Product_Price</th>\r\n"
		                            + " <th>Product_Quantity</th>\r\n"
		                            + "</tr> "
		                            + "</thead>"
		                            + "<tbody>");
		            out.println("<tr>\r\n"
		                            + " <td>" + p.getProduct_id() + "</td>\r\n"
		                            + " <td>" + p.getProduct_name() + "</td>\r\n"
		                            + " <td>" + p.getProduct_desc() + "</td>\r\n"
		                            + " <td>" + p.getProduct_price() + "</td>\r\n"
		                            + " <td>" + p.getProduct_qty() + "</td>\r\n"
		                            + " <td><form action=''><button type=\"submit\"name=\"option\" value=\"" + p.getProduct_id() + "\">DELETE</button></form></td>\r\n"
		                            + "</tr>");

		            out.println("</tbody></table>");
		        }
		    }
		    if (!found) {
		        out.println("No data match found");
		    }
		} 
		
		else  {
			
			int gid=Integer.parseInt(request.getParameter("option"));
			for(Pojo p:li)
	        {
	            if(gid==(p.getProduct_id()))
	            {
	              li.remove(p);
	              break;
	            }
	        }
			out.println("<table border =\" 2px\" >"
					+ "<thead><tr>\r\n"
					+ " <th>Product_Id</th>\r\n"
					+ " <th>Product_Name</th>\r\n"
					+ " <th>Product_Description</th>\r\n"
					+ " <th>Product_Price</th>\r\n"
					+ " <th>Product_Quantity</th>\r\n"
					+ "</tr> "
					+"</thead>"
					+"<tbody>");
			for(Pojo p:li)
			{
			   out.println("<tr>\r\n"
					+ " <td>"+p.getProduct_id()+"</td>\r\n"
					+ " <td>"+p.getProduct_name()+"</td>\r\n"
					+ " <td>"+p.getProduct_desc()+"</td>\r\n"
					+ " <td>"+p.getProduct_price()+"</td>\r\n"
					+ " <td>"+p.getProduct_qty()+"</td>\r\n"
				    + " <td><form action=''><button type=\"submit\"name=\"option\" value=\""+p.getProduct_id()+"\">DELETE</button></form></td>\r\n"
					+ "</tr>");

		      out.println("</tbody></table>");
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
