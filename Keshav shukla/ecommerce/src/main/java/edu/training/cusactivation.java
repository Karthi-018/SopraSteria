package edu.training;

import java.io.IOException;
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
 * Servlet implementation class cusactivation
 */
@WebServlet("/cusactivation")
public class cusactivation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String custemail;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cusactivation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost: 3306/ecommerce","root","Sumit@123");
			PreparedStatement ps = conn.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, request.getParameter("username"));
			ps.setString(2,request.getParameter("pw"));
			ResultSet rs = ps.executeQuery();
			custemail = request.getParameter("username");
			
            if(rs.next())
            {
            	if(rs.getString(6).equals("active"))
            	{
            		
            		request.setAttribute("cname",rs.getString(1));
                    request.getRequestDispatcher("Customerhome.jsp").forward(request, response);
            	}
            	else
            	{
            		request.setAttribute("msg", "OOPS!!! Your Account has not yet activated......");
                    request.getRequestDispatcher("customermain.jsp").forward(request, response);
            		
            	}
            	
            }
            else
            {
            	request.setAttribute("msg", "Invalid Credentials......");
                request.getRequestDispatcher("customermain.jsp").forward(request, response);
            }	
		} catch (Exception e) {
			// TODO: handle exception
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
