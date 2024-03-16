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

/**
 * Servlet implementation class ActivateCustomerServlet
 */
@WebServlet("/ActivateCustomerServlet")
public class ActivateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int flag=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
			PreparedStatement ps=c.prepareStatement("update customer set activeState=? where email=?");
			PreparedStatement ps1=c.prepareStatement("select activeState from customer where email=?");
			ps1.setString(1, request.getParameter("username"));
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				if(rs1.getString(1).equals("active"))
				{
					ps.setString(1, "inactive");
				}
				else
				{
					ps.setString(1,"active");
				}
				ps.setString(2, request.getParameter("username"));
				ps.executeUpdate();
			}

			RequestDispatcher rd=request.getRequestDispatcher("CustomerListServlet");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			out.print(e);
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
