package edu.training;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String op = request.getParameter("method");
		switch(op) {
		case "Register":{
      	String first_name = request.getParameter("fname");
      	String last_name = request.getParameter("lname");
      	String email = request.getParameter("uemail");
      	String passw = request.getParameter("passw");
      	String dob = request.getParameter("dob");
      	String gender = request.getParameter("gender");
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            PreparedStatement ps = connection.prepareStatement("insert into customer1 values(?,?,?,?,?,?)");
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, email);
            ps.setString(4, passw);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("secondindex.jsp");
		rd.forward(request, response);
		
		}
		case "login":{
			try {
				String uemail = request.getParameter("uemail");
				String pass = request.getParameter("pass");
				 Class.forName("com.mysql.cj.jdbc.Driver");        
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
				Statement statement = connection.createStatement();
			    ResultSet rs = statement.executeQuery("select first_name,email,passw from customer1 where email =" +"'" + uemail + "' and passw = "+ "'" + pass +"'");
			    if(!rs.next()) {
			    	out.println("<h1>Who are you?</h1>");
			    }else {
			    	out.println("<h1>Welcome "+rs.getString(1)+"</h1>");
			    }
//			    out.println(rs.next());
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
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
