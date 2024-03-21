package edu.training;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
//		PrintWriter o=response.getWriter();
		int result=0;
		try {
				Connection c = DbConnection.getConnection();
		        Statement statement = c.createStatement();   
		        int pid=Integer.parseInt(request.getParameter("pid"));
		        int pcost=Integer.parseInt(request.getParameter("pcost"));
		        int pquantity=Integer.parseInt(request.getParameter("pquantity"));
		        result=statement.executeUpdate("Update product set pcost="+pcost+" , pquantity="+pquantity+" where pid="+pid);
		        
		        RequestDispatcher rd=request.getRequestDispatcher("ViewProduct.jsp");

		        if(result>0)
	            {            	
	//            	response.sendRedirect("CreateProduct.jsp");
	            	
	            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Updated Successfully</h2></Center>");
	            	rd.forward(request,response);
	            }
		        else
		        {
		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Failed to Update</h2></Center>");
		        	rd.forward(request,response);
		        }
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }
	}

}
