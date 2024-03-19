package edu.trainingmar11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserStatus
 */
@WebServlet("/UserStatus")
public class UserStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String opt=request.getParameter("status");
		PrintWriter out=response.getWriter();
		try
	    {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Root");
	        PreparedStatement ps1=connection.prepareStatement("select * from custtable where cemail=?");
	        ps1.setString(1,opt);
	        ResultSet rs=ps1.executeQuery();
	        if(rs.next()) {
	        	if(rs.getString(6).equals("Active")){
	        		PreparedStatement ps=connection.prepareStatement("update custtable set status=? where cemail=?");
	        		ps.setString(1, "Inactive");
	        		ps.setString(2, opt);
	        		ps.executeUpdate();
	        		 response.sendRedirect("Custlist");
	        	}else {
	        		PreparedStatement ps=connection.prepareStatement("update custtable set status=? where cemail=?");
	        		ps.setString(1, "Active");
	        		ps.setString(2, opt);
	        		ps.executeUpdate();
	        		response.sendRedirect("Custlist");
	        		
	        	}
	        	
	        	
	        	//request.getRequestDispatcher(".jsp").forward(request, response);
	        	
	        }
            
	    }
		catch(ClassNotFoundException e)
	    {
	        out.println(e);
	    }
	    catch(SQLException e)
	    {
	        out.println(e);}
	    }
		
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
