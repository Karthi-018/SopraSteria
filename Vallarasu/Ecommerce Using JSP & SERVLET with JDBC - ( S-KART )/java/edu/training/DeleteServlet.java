package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result=0;
		try {
				Connection c = DbConnection.getConnection();
		        Statement statement = c.createStatement();   
		        int pid=Integer.parseInt(request.getParameter("del"));
		        result=statement.executeUpdate("delete from product where pid="+pid);

		        RequestDispatcher rd=request.getRequestDispatcher("ViewProduct.jsp");
		        		        
		        if(result>0)
		            {            		
		            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Successfully Deleted</h2></Center>");
		            	rd.forward(request,response);
		            }
		        else
		        {
		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">There is no such record to delete</h2></Center>");
		        	rd.forward(request,response);
		        }
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }
	}

}
