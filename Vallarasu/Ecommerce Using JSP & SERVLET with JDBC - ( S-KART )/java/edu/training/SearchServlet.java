package edu.training;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
//		PrintWriter o=response.getWriter();
//		o.println("Vallarasu");
		try {	            
				Connection c = DbConnection.getConnection();
		        Statement statement = c.createStatement();   
		        ResultSet rs=statement.executeQuery("Select * from product where pname='"+request.getParameter("search")+"'");
		        
		        RequestDispatcher rd=request.getRequestDispatcher("SearchProduct.jsp");
		        
		        request.setAttribute("resultset", rs);
		        rd.forward(request,response);
		        
//		        if(rs.next())
//		            {            	
////		           	response.sendRedirect("SearchProduct.jsp");
//		    
//		        		request.setAttribute("resultset", rs);
//		            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">The Product is Available</h2></Center>");
//		            	rd.forward(request,response);
//		            }
//		        else
//		        {
//		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">The Product is Not Available</h2></Center>");
//		        	rd.forward(request,response);
//		        }
        } 
		catch (Exception e) {
            System.out.println(e);
        }
	}

}
