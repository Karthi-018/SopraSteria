package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserStatusServlet
 */
@WebServlet("/UserStatusServlet")
public class UserStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	            
			Connection c = DbConnection.getConnection();
	        Statement statement = c.createStatement();   
	        ResultSet rs=statement.executeQuery("Select uname,status from usertype WHERE UNAME!='Vallarasu287'");
	        
	        RequestDispatcher rd=request.getRequestDispatcher("UserStatus.jsp");
	        
	        request.setAttribute("resultset", rs);
	        rd.forward(request,response);

    	} 
	catch (Exception e) {
        System.out.println(e);
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	            
			Connection c = DbConnection.getConnection();
	        Statement statement = c.createStatement();   
	        switch(request.getParameter("status"))
	        {
	        case "ACTIVATE":
	        	statement.executeUpdate("UPDATE USERTYPE SET STATUS='ACTIVE' WHERE UNAME='"+request.getParameter("activate")+"'");
	        	break;
	        case "DE-ACTIVATE":
	        	statement.executeUpdate("UPDATE USERTYPE SET STATUS='INACTIVE' WHERE UNAME='"+request.getParameter("de-activate")+"'");
	        	break;
	        }
	        doGet(request,response);

    	} 
	catch (Exception e) {
        System.out.println(e);
    }
	}
}
