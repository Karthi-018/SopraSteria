package edu.servletTraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Customer> customerList=new ArrayList<>(); 
    public RegistrationServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
			PreparedStatement ps=c.prepareStatement("select email,activeState from customer");
			ResultSet rs=ps.executeQuery();
			int flag=0;
			while(rs.next())
			{
				if(rs.getString(1).equals(request.getParameter("email"))&&rs.getString(2).equals("active"))
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				PreparedStatement ps1=c.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
				ps1.setString(1,request.getParameter("fname"));
				ps1.setString(2,request.getParameter("lname"));
				ps1.setString(3,request.getParameter("email"));
				ps1.setString(4,request.getParameter("pass"));
				ps1.setString(5,request.getParameter("dob"));
				ps1.setString(6,request.getParameter("gender"));
				ps1.setString(7,"inactive");
				ps1.executeUpdate();
			}
			else
			{
				out.println("<h2> user already exist! Try to login</h2>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
		response.sendRedirect("LogIn.jsp");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
