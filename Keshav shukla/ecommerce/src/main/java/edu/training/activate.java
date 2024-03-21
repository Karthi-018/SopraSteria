package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class activate
 */
@WebServlet("/activate")
public class activate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public activate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p=Integer.parseInt(request.getParameter("status"));
        try {
        	Class.forName("com.mysql.jdbc.Driver");
 			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost: 3306/ecommerce","root","Sumit@123");
 			PreparedStatement ps =connection.prepareStatement("update user set status=? where customer_id=?");
 			ps.setInt(2, p);
 			ps.setString(1,"active");
 			  int r = ps.executeUpdate();
 	            if(r>0)
 	            {
 	                request.getRequestDispatcher("customerlist").forward(request, response);
 	            }
 	            else
 	            {
 	            	response.getWriter().println("Error Occured To Activate");
 	            }
		} catch (Exception e) {
			// TODO: handle exception
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
