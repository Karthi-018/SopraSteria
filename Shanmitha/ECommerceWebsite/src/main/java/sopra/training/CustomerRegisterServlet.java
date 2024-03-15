package sopra.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerRegister
 */
@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String login = null;
//		login = request.getParameter("Login");
//		if(login!=null)
//		{
//			response.sendRedirect("customerLogin.jsp");
//		}
//		String name = request.getParameter("name");
//		String psw = request.getParameter("psw");
//		String psw_repeat = request.getParameter("psw-repeat");
//		PrintWriter out = response.getWriter();
//		try
//		{
//			if(psw.equals(psw_repeat))
//			{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
//	        PreparedStatement ps = connection.prepareStatement("insert into customer_login values(?,?)");
//	        ps.setString(1, name);
//	        ps.setString(2, psw);
//	        int n = ps.executeUpdate();
//
//	        	if(n>0)
//	        	{
//	        	response.sendRedirect("customerLogin.jsp");
//	        	}
//	        	else
//	        	{
//	        	response.sendRedirect("customerRegister.jsp");
//	        	}
//			}
//			else
//			{
//				out.println("password does not match");
//				response.sendRedirect("customerRegister.jsp");
//			}
//	           
//		}
//		catch(Exception e)
//		{
//			response.getWriter().println("<h1>"+e.getStackTrace()+"</h1>");
//		}
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();

		try {
			String login = null;
			login = request.getParameter("Login");
			if(login!=null)
			{
				response.sendRedirect("customerLogin.jsp");
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
			PreparedStatement ps=c.prepareStatement("select * from customer_details");
			ResultSet rs=ps.executeQuery();
			int flag=0;
			while(rs.next())
			{
				if(rs.getString(4).equals(request.getParameter("email")) && rs.getString(8).equals("active"))
				{
					flag=1;
				}
			}
			if(flag==0)
			{
				PreparedStatement ps1=c.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?,?)");
				ps1.setInt(1, 0);
				ps1.setString(2,request.getParameter("fname"));
				ps1.setString(3,request.getParameter("lname"));
				ps1.setString(4,request.getParameter("email"));
				ps1.setString(5,request.getParameter("pass"));
				ps1.setString(6,request.getParameter("dob"));
				ps1.setString(7,request.getParameter("gender"));
				ps1.setString(8,"inactive");
				ps1.executeUpdate();
				response.sendRedirect("customerLogin.jsp");
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
		
			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
