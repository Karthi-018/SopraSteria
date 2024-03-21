package edu.learning;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
            Statement s = connection.createStatement();
            ResultSet result=s.executeQuery("Select * from productdb");
            request.setAttribute("rs",result);
            request.getRequestDispatcher("view.jsp").forward(request,response);
            
            
        }
        catch(Exception e)
    	{
        	request.setAttribute("msg","<h1>Error occured</h1>");
        	request.getRequestDispatcher("view.jsp").forward(request,response);
        	
    	}
//    
//		String choice=request.getParameter("ename");
//		if(choice.equals("edit"))
//		{
//			response.sendRedirect("edit.jsp");
//		}
//		else
//		{
//			response.sendRedirect("delete.jsp");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
