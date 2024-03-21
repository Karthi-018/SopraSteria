package edu.learning;

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
 * Servlet implementation class Customer
 */
@WebServlet("/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String choice=request.getParameter("option");
	if(choice.equals("Register"))
	{
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?,?)");
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, "inactive");
            
            int result = preparedStatement.executeUpdate();
            if(result>0)
            {
            	request.setAttribute("msg","<h1>You are registered successfully</h1>");
            	request.getRequestDispatcher("custlogin.jsp").forward(request,response);
            }
            
        }
        catch(Exception e)
    	{
        	request.setAttribute("msg","<h1>Error occured</h1>");
        	request.getRequestDispatcher("custlogin.jsp").forward(request,response);
        	
    	}
	}
	else
	{
		request.getRequestDispatcher("custlogin.jsp").forward(request,response);
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
