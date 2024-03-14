package sopra.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = null;
		login = request.getParameter("Login");
		if(login!=null)
		{
			response.sendRedirect("customerLogin.jsp");
		}
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		String psw_repeat = request.getParameter("psw-repeat");
		PrintWriter out = response.getWriter();
		try
		{
			if(psw.equals(psw_repeat))
			{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	        PreparedStatement ps = connection.prepareStatement("insert into customer_login values(?,?)");
	        ps.setString(1, name);
	        ps.setString(2, psw);
	        int n = ps.executeUpdate();

	        	if(n>0)
	        	{
	        	response.sendRedirect("customerLogin.jsp");
	        	}
	        	else
	        	{
	        	response.sendRedirect("customerRegister.jsp");
	        	}
			}
			else
			{
				out.println("password does not match");
				response.sendRedirect("customerRegister.jsp");
			}
	           
		}
		catch(Exception e)
		{
			response.getWriter().println("<h1>"+e.getStackTrace()+"</h1>");
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
