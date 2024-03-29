package edu.training;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
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
		        int pid=Integer.parseInt(request.getParameter("pid"));
		        String pname=request.getParameter("pname");
		        int pcost=Integer.parseInt(request.getParameter("pcost"));
		        int pquantity=Integer.parseInt(request.getParameter("pquantity"));
		        
		        PreparedStatement ps= c.prepareStatement("INSERT INTO Product VALUES (?,?,?,?)");
		        ps.setInt(1,pid);
		        ps.setString(2,pname);
		        ps.setInt(3,pcost);
		        ps.setInt(4,pquantity);
		        result=ps.executeUpdate();
		        
		        RequestDispatcher rd=request.getRequestDispatcher("CreateProduct.jsp");
		
		        if(result>0)
		            {            	
		//            	response.sendRedirect("CreateProduct.jsp");
		            	
		            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Successfully Added</h2></Center>");
		            	rd.forward(request,response);
		            }
		        else
		        {
		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Failed to Add</h2></Center>");
		        	rd.forward(request,response);
		        }
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }
	}

}
