package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		int result=0;
		try {
				Connection c = DbConnection.getConnection(); 
		        String uname=request.getParameter("uname");
		        String password=request.getParameter("password");
		      
		        PreparedStatement ps= c.prepareStatement("INSERT INTO Usertype(uname,pass) VALUES (?,?)");
		        ps.setString(1,uname);
		        ps.setString(2,password);
		        result=ps.executeUpdate();
		        
		        RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
		
		        if(result>0)
		            {            	
		            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Successfully Registered</h2></Center>");
		            	rd.forward(request,response);
		            }
		        else
		        {
		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Failed to Register</h2></Center>");
		        	rd.forward(request,response);
		        }
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }

	}

}
