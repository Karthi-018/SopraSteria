package edu.trainingmar11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Custaccess
 */
@WebServlet("/Custaccess")
public class Custaccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String name;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Custaccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String cname=request.getParameter("cuname");
		name=request.getParameter("cuname");
		String cpwd=request.getParameter("cpwd");
		PrintWriter out=response.getWriter();
		try
	    {			
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Root");
        Statement  st=connection.createStatement();
        ResultSet  rs=st.executeQuery("select * from custtable where cname='"+cname+"' and cpwd='"+cpwd+"';");
        if(rs.next())
        {
        	if(rs.getString(6).equals("Inactive")) 
        	{
            	request.setAttribute("msg", "Account not activated");
	        	request.getRequestDispatcher("Custlgn.jsp").forward(request, response);
            }
        	else
        	{
        		response.sendRedirect("Custactions.jsp");
        	}
        	   
        	
        }
        
        else{
        	request.setAttribute("msg", "Invalid credentials");
        	request.getRequestDispatcher("Custlgn.jsp").forward(request, response);
            
        }
            
        	
            
	    }
	    catch(ClassNotFoundException e)
	    {
	        out.println(e);
	    }
	    catch(SQLException e)
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
