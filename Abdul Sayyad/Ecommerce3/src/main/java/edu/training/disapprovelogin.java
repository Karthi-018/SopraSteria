package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class disapprovelogin
 */
@WebServlet("/disapprovelogin")
public class disapprovelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public disapprovelogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");        
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement statement = connection.createStatement();
			statement.executeUpdate("update customer1 set access = 'deny' where email = '"+email+"'");
			RequestDispatcher rd = request.getRequestDispatcher("/viewaccess");
		  
		   rd.forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
