package edu.trainingmar8;

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
 * Servlet implementation class Ecommerce
 */
@WebServlet("/Ecommerce")
public class Ecommerce extends HttpServlet {
	private static final long serialVersionUID = 1L;
     List<Products> ecomList=new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ecommerce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form action=\"Ecommerce\">\r\n"
				+ "<label>Product Id</label><input type=\"number\" name=\"proId\" value=\"\"placeholder=\"Enter product Id\"/><br><br>\r\n"
				+ "<label>Product Name</label><input type=\"text\" name=\"proName\" value=\"\"placeholder=\"Enter Product Name:\"/><br><br>\r\n"
				+ "<label>Product description</label><input type=\"text\" name=\"proDescription\" value=\"\"placeholder=\"Enter Product description\"/><br><br>\r\n"
				+ "<label>Product price</label><input type=\"number\" name=\"proPrice\" value=\"\"placeholder=\"Enter Product price\"/><br><br>\r\n"
				+ "<label>Quantity</label><input type=\"number\" name=\"proQuantity\" value=\"\"placeholder=\"Enter total quantity\"/><br><br>\r\n"
				+ "<input type=\"submit\" name=\"option\"value=\"Add\">\r\n"
				+ "<input type=\"Reset\">\r\n"
				+ "<input type=\"number\" placeholder=\"Type Product Id to search\" name=\"search\"/>  \r\n"
				+ "<input type=\"submit\" name=\"option\" value=\"Search\"/>\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
		        + "</html>");
		String opt=request.getParameter("option");
		if(opt.equals("Add")) {
			int pid=Integer.parseInt(request.getParameter("proId"));
			String pname=request.getParameter("proName");
			String descript=request.getParameter("proDescription");
			int prodprice=Integer.parseInt(request.getParameter("proPrice"));
			int pquantity=Integer.parseInt(request.getParameter("proQuantity"));
			Products pro=new Products(pid,pname,descript,prodprice,pquantity);
			ecomList.add(pro);	
			
		}
		else if(opt.equals("Search")) {
		    int gid=Integer.parseInt(request.getParameter("search"));
		    for(Products p:ecomList)
	        {
	            if(gid==(p.getId()))
	            {
	            	out.println("<table border =\" 1px\" >"
	        				+ "<thead><tr>\r\n"
	        				+ " <th>Product Id</th>\r\n"
	        				+ " <th>Product Name</th>\r\n"
	        				+ " <th>Product Description</th>\r\n"
	        				+ " <th>Product Price</th>\r\n"
	        				+ " <th>Quantity</th>\r\n"
	        				+ " <th>Action</th>\r\n"
	        				+ "</tr> "
	        				+"</thead>"
	        				+"<tbody>");
	        				out.println("<tr>\r\n"
	        						+ " <td>"+p.getId()+"</td>\r\n"
	        						+ " <td>"+p.getName()+"</td>\r\n"
	        						+ " <td>"+p.getDescription()+"</td>\r\n"
	        						+ " <td>"+p.getPrice()+"</td>\r\n"
	        						+ " <td>"+p.getQuantity()+"</td>\r\n"
	        					    + " <td><form action=''><button type=\"submit\"name=\"option\" value=\""+p.getId()+"\">DELETE</button></form></td>\r\n"
	        						+ "</tr>");
	      
	        			out.println("</tbody></table>");
	        			
	            }
	            
	        }
		}
		else  {
			//out.println("kio");
			int gid=Integer.parseInt(request.getParameter("option"));
			for(Products p:ecomList)
	        {
	            if(gid==(p.getId())) 
	            {
	              ecomList.remove(p);
	              break;
	            }
	        }

		} 
		if(ecomList.size()>0) 
		{   out.println("<table border =\" 1px\" >"
				+ "<thead><tr>\r\n"
				+ " <th>Product Id</th>\r\n"
				+ " <th>Product Name</th>\r\n"
				+ " <th>Product Description</th>\r\n"
				+ " <th>Product Price</th>\r\n"
				+ " <th>Quantity</th>\r\n"
				+ " <th>Action</th>\r\n"
				+ "</tr> "
				+"</thead>"
				+"<tbody>");
			for(Products prod:ecomList)
			{
				out.println("<tr>\r\n"
						+ " <td>"+prod.getId()+"</td>\r\n"
						+ " <td>"+prod.getName()+"</td>\r\n"
						+ " <td>"+prod.getDescription()+"</td>\r\n"
						+ " <td>"+prod.getPrice()+"</td>\r\n"
						+ " <td>"+prod.getQuantity()+"</td>\r\n"
					    + " <td><form action=''><button type=\"submit\"name=\"option\" value=\""+prod.getId()+"\">DELETE</button></form></td>\r\n"
						+ "</tr>");
			}
			out.println("</tbody></table>");
			
		}
		else {
			out.println("Nothing exists in here");}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}


