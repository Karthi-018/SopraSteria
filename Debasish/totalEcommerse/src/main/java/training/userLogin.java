package training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	public static String  email;
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		email=request.getParameter("userid");
		PrintWriter out=response.getWriter();
		//RequestDispatcher rd= request.getRequestDispatcher("");
		String user=request.getParameter("userid");
		String pass=request.getParameter("password");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement  st=connection.createStatement();
            ResultSet  re=st.executeQuery("select * from userList where email='"+user+"';");
            re.next();
                if(re.getString(4).equals("In-Active")) {
                	response.sendRedirect("userWithoutAprove.jsp");
                }
            	else if(re.getString(2).equals(user) && re.getString(3).equals(pass)){
            		response.sendRedirect("userMenubar.jsp");
                }
                else{
                    response.sendRedirect("worngPassword.jsp");
                }

            
        }catch(ClassNotFoundException e)
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
