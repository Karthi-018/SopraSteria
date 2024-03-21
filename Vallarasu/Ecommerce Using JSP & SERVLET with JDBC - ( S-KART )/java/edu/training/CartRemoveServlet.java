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
 * Servlet implementation class CartRemoveServlet
 */
@WebServlet("/CartRemoveServlet")
public class CartRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartRemoveServlet() {
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
		        int cid=Integer.parseInt(request.getParameter("buycid"));
		      
		        result=statement.executeUpdate("Delete from cart where cartid="+cid);
		        
		        RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
		        
		        ResultSet rs=statement.executeQuery("Select c.cartid, c.pid, p.pname, c.pquantity, (c.pquantity)*(p.pcost) from product p join cart c using(pid) where c.uname='"+uname+"'");
			     
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
