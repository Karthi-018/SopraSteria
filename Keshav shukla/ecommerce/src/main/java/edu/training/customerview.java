package edu.training;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class customerview
 */
@WebServlet("/customerview")
public class customerview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		// TODO Auto-generated method stub
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost: 3306/ecommerce","root","Sumit@123");
//			  PreparedStatement ps = conn.prepareStatement("Select * from customer");
//			  ResultSet result=ps.executeQuery();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Sumit@123");
            java.sql.Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from customer");
			  request.setAttribute("rs",rs);
          	  request.getRequestDispatcher("customerview.jsp").forward(request,response);

		} catch(ClassNotFoundException e)
	    {
			try {
				response.getWriter().println(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }catch (SQLException e){
	    	try {
				response.getWriter().println(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
