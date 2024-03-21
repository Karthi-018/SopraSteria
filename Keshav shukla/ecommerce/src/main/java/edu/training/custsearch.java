package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class custsearch
 */
@WebServlet("/custsearch")
public class custsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public custsearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost: 3306/ecommerce","root","Sumit@123");
			  PreparedStatement ps = conn.prepareStatement("Select * from customer where productname =?");
			  String search=request.getParameter("pname");
			  ps.setString(1,search );
			  ResultSet result=ps.executeQuery();
			  request.setAttribute("rs",result);
            	request.setAttribute("msg","<h1>Product "+search+" is found</h1>");
            	request.getRequestDispatcher("csearch.jsp").forward(request,response);
        }
        catch(Exception e)
    	{
        	request.setAttribute("msg","<h1>Error occured</h1>");
        	request.getRequestDispatcher("customersearch.jsp").forward(request,response);
        	
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
