package edu.servletTraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
			if(request.getParameter("username").equals("Admin")&&request.getParameter("pass").equals("Admin@123"))
			{
				HttpSession s=request.getSession();
				s.setAttribute("type", "admin");
				
				RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
			}
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
				PreparedStatement ps=c.prepareStatement("select pass,activeState from customer where email=?");
				ps.setString(1,request.getParameter("username") );
				ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(request.getParameter("pass"))&&rs.getString(2).equals("active"))
				{
					HttpSession session=request.getSession();
					session.setAttribute("username",request.getParameter("username"));
					RequestDispatcher rd=request.getRequestDispatcher("/CustomerHome.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.println("<h3> Invalid username or password!!</h3>");
				}
				
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
