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
import javax.servlet.http.HttpSession;

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
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
            
	        PreparedStatement ps = connection.prepareStatement("select * from customer_details where email = ? and password = ?");
	        ps.setString(1, email);
	        ps.setString(2, psw);
	        ResultSet rs = ps.executeQuery();
	        
	        int flag = 0;
	        while(rs.next())
	        {
	        if(rs.getString(8).equals("active"))
	        {
	        	flag = 1;
	        	int cust_ID = rs.getInt(1);
	        	HttpSession session = request.getSession();
	        	session.setAttribute("cust_ID",cust_ID);
	        	
//	        	int cust_ID = rs.getInt(1);
//	        	request.setAttribute("cust_ID",cust_ID);
//	        	request.getRequestDispatcher("/customerHome.jsp").forward(request,response);
	        	response.sendRedirect("customerHome.jsp");
	        	break;
	        }
	        }
	        if(flag==0)
	        {
	        	out.println("Username, password not valid");
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
