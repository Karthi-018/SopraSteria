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
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String psw = request.getParameter("psw");
		
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	        PreparedStatement ps = connection.prepareStatement("select * from customer_login where username = ? and password = ?");
	        ps.setString(1, uname);
	        ps.setString(2, psw);
	        ResultSet rs = ps.executeQuery();
	        int flag = 0;
	        while(rs.next())
	        {
	        if(rs.getString(1).equals(rs.getString(2)))
	        {
	        	flag = 1;
	        	response.sendRedirect("customerHome.jsp");
	        	break;
	        }
	        }
	        if(flag==0)
	        {
	        	out.println("Username or password does not match");
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
