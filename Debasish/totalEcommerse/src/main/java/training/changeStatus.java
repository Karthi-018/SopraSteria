package training;

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
 * Servlet implementation class changeStatus
 */
@WebServlet("/changeStatus")
public class changeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("change");
PrintWriter out=response.getWriter();
		
		try
	    {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
	        Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from userList where email ='"+email+"'");
            while(resultSet.next())
            {
            if(resultSet.getString(4).equals("In-Active"))
            
            {
	        PreparedStatement ps = connection.prepareStatement("update userList set statusid=\"Active\" where email =\""+email+"\"");
	        int res=ps.executeUpdate();
	        response.sendRedirect("edit");
            }
            
            
            else 
            {
            	PreparedStatement ps = connection.prepareStatement("update userList set statusid=\"In-Active\" where email =\""+email+"\"");
    	        int res=ps.executeUpdate();
    	        response.sendRedirect("edit");
            }
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
