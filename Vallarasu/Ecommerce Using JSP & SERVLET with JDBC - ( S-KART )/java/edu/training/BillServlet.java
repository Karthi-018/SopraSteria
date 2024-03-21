package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
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
		        int pid=Integer.parseInt(request.getParameter("pid"));
		        int pquantity=Integer.parseInt(request.getParameter("pquantity"));
		        result=statement.executeUpdate("Update product set pquantity=pquantity-"+pquantity+" where pid="+pid);
		        
		        
		        
		        RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");

		        ResultSet rs=statement.executeQuery("Select * from product where pid="+request.getParameter("pid"));
		        request.setAttribute("totalQuantity",request.getParameter("pquantity"));
		        request.setAttribute("resultset", rs);
		       
		      
		        if(result>0)
	            {            		            	
	            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Purchased Successfully</h2></Center>");
	            	rd.forward(request,response);
	            }
		        else
		        {
		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Failed to Purchase</h2></Center>");
		        	rd.forward(request,response);
		        }
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }
	}

}
