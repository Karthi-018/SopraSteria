package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
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
		try {	            
			Connection c = DbConnection.getConnection();
	        Statement statement = c.createStatement();   
	        ResultSet rs=statement.executeQuery("Select * from usertype where uname='"+request.getParameter("uname")+"'");
	    
	        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	       
	        if(rs.next())
	        {
	        	if(rs.getString("status").equals("ACTIVE"))
	        	{
	        		if(rs.getString("pass").equals(request.getParameter("password"))) 
	        		{
	        			switch(rs.getString("utype"))
	        			{
	        				case "ADMIN":
	        					response.sendRedirect("AdminIndex.jsp");
	        					break;
	        				case "CUSTOMER":
	        					HttpSession session = request.getSession();
	        		        	session.setAttribute("Username",request.getParameter("uname"));
	        					response.sendRedirect("CustomerIndex.jsp");	
	        					break;
	        			}
	        		}	
	        		else
	        		{
	        			request.setAttribute("msg","<Center><h2 style=\"color:Red;\">Invalid Credentials...</h2></Center>");
	        			rd.forward(request,response);	        			
	        		}
	        	}
	        	else
	        	{
	        		request.setAttribute("msg","<Center><h2 style=\"color:Red;\">Your Profile is Still in Admin's Table to Activate. Please Try After SomeTime.....Sorry for the Inconvenience</h2></Center>");
		        	rd.forward(request,response);
	        	}
	        }
	        else
	        {
	        	request.setAttribute("msg","<Center><h2 style=\"color:Red;\">There is No Such UserName. Please Do Register.</h2></Center>");
	        	rd.forward(request,response);	        	
	        }
	        

	    	} 
		catch (Exception e) {
	        System.out.println(e);
	    }
	}

}
