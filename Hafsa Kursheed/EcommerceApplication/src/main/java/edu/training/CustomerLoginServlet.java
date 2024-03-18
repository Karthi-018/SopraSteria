package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
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
	Connection conn = null;
       
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
		try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from customers where email=? and password=?");
            ps.setString(1,request.getParameter("email"));
            ps.setString(2,request.getParameter("pwd"));
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	if(rs.getString(8).equals("Active"))
            	{
            		ServletContext c = request.getServletContext(); 
                	c.setAttribute("cid",String.valueOf(rs.getInt(7)));
                	
                	c.setAttribute("cName",rs.getString(1));
                	
                    request.getRequestDispatcher("Customerhome.jsp").forward(request, response);
            	}
            	else
            	{
            		request.setAttribute("msg", "OOPS!!! Your Account Is Not In Active State......");
                    request.getRequestDispatcher("Customerlogin.jsp").forward(request, response);
            		
            	}
            	
            }
            else
            {
            	request.setAttribute("msg", "Invalid Credentials......");
                request.getRequestDispatcher("Customerlogin.jsp").forward(request, response);
            }
            	
        }
         catch (SQLException e)
         {
            	request.setAttribute("msg", "Error Occured");
                request.getRequestDispatcher("Customerlogin.jsp").forward(request, response);
                System.out.println(e);
         }
         finally
         {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    System.out.println(e);
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
