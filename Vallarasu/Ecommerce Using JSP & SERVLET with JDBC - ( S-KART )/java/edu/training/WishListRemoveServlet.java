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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WishListRemoveServlet
 */
@WebServlet("/WishListRemoveServlet")
public class WishListRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListRemoveServlet() {
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
				HttpSession session = request.getSession();
				String uname = session.getAttribute("Username").toString();
				
				Connection c = DbConnection.getConnection();
		        Statement statement = c.createStatement();   
		        int listid=Integer.parseInt(request.getParameter("wishlistid"));
		      
		        result=statement.executeUpdate("Delete from wishlist where listid="+listid);
		        
		        RequestDispatcher rd=request.getRequestDispatcher("WishList.jsp");
		        
		        ResultSet rs=statement.executeQuery("Select w.listid, w.pid, p.pname, w.pquantity, (w.pquantity)*(p.pcost) from product p join wishlist w using(pid) where w.uname='"+uname+"'");
			     
		        request.setAttribute("resultset", rs);
		       
		      
		        if(result>0)
	            {            		            	
	            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Successfully Removed</h2></Center>");
	            	rd.forward(request,response);
	            }
		        else
		        {
		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Failed to Remove</h2></Center>");
		        	rd.forward(request,response);
		        }
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }

	}

}
