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
@WebServlet("/custregister")
public class custregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public custregister() {
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
            PreparedStatement ps = connection.prepareStatement("insert into customer1 values(?,?,?,?,?,?,?)");
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, email);
            ps.setString(4, passw);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.setString(7, "new");
            ps.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("custlogin.jsp");
		rd.forward(request, response);
		
		}
		case "login":{
			try {
				String uemail = request.getParameter("uemail");
				String pass = request.getParameter("pass");
				ActionServlet.customerEmail = uemail;
				 Class.forName("com.mysql.cj.jdbc.Driver");        
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
				Statement statement = connection.createStatement();
			    ResultSet rs = statement.executeQuery("select first_name,email,passw,access from customer1 where email =" +"'" + uemail + "' and passw = "+ "'" + pass +"' and access = 'accept'");
				RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
			    if(!rs.next()) {
				    ResultSet rs1 = statement.executeQuery("select first_name,email,passw,access from customer1 where email =" +"'" + uemail + "' and passw = "+ "'" + pass +"' and access = 'deny' ");
				    int flag = 0;
				    if(rs1.next()) {
				    	out.println("<h1>Login Not Accessible</h1>");
				    	flag = 1;
				    }
				    ResultSet rs2 = statement.executeQuery("select first_name,email,passw,access from customer1 where email =" +"'" + uemail + "' and passw = "+ "'" + pass +"' and access = 'new' ");
				    if(rs2.next()) {
				    	out.println("<h1>Login Not Accessible</h1>");
				    }
				    else if(flag == 0) {
			    	out.println("<h1>Who are you?</h1>");
				    }
			    }else {
			    	rd.forward(request, response);
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
