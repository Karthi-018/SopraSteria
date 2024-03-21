package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
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
			PrintWriter o=response.getWriter();
			
			Connection c = DbConnection.getConnection();
	        Statement statement = c.createStatement();  
	        
	        ResultSet rs=statement.executeQuery("Select * from product where pid="+request.getParameter("pid"));
	        
	        RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
	        
	        request.setAttribute("totalQuantity",request.getParameter("pquantity"));
	        request.setAttribute("resultset", rs);
	        rd.forward(request,response);

    	} 
		catch (Exception e) {
	        System.out.println(e);
		}
	}
}
