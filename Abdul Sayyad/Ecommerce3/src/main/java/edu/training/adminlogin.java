package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			 Class.forName("com.mysql.cj.jdbc.Driver");        
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement statement = connection.createStatement();
		    ResultSet rs = statement.executeQuery("select username,passwor from admi where username =" +"'" + uname + "' and passwor = "+ "'" + pass +"'");
			RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
		    if(!rs.next()) {
		    	out.println("<h1>Who are you?</h1>");
		    }else {
		    	rd.forward(request, response);
		    }
//		    out.println(rs.next());
		}catch(Exception e) {
			System.out.println(e);
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
