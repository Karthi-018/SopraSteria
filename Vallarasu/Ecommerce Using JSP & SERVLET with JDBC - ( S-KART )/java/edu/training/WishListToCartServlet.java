package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class WishListToCartServlet
 */
@WebServlet("/WishListToCartServlet")
public class WishListToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListToCartServlet() {
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
		        
				HttpSession session = request.getSession();
				String uname = session.getAttribute("Username").toString();
				
				int wlistid=Integer.parseInt(request.getParameter("wishlistid"));
				int pid=Integer.parseInt(request.getParameter("wishlistpid"));
		        int pquantity=Integer.parseInt(request.getParameter("wishlistpquantity"));
		 
		        PreparedStatement ps= c.prepareStatement("INSERT INTO cart (uname,pid,pquantity) VALUES (?,?,?)");
		        ps.setString(1,uname);
		        ps.setInt(2,pid);
		        ps.setInt(3,pquantity);
		        result=ps.executeUpdate();
		        
		        Statement statement1 = c.createStatement();   
		        statement1.executeUpdate("Delete from wishlist where listid="+wlistid);
		        
		        RequestDispatcher rd=request.getRequestDispatcher("WishList.jsp");
		        
		        Statement statement2 = c.createStatement();   
		        ResultSet rs=statement2.executeQuery("Select w.listid, w.pid, p.pname, w.pquantity, (w.pquantity)*(p.pcost) from product p join wishlist w using(pid) where w.uname='"+uname+"'");
		        request.setAttribute("resultset", rs);
		        
		      
		        
		        
		        if(result>0)
		            {            	
		            	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Successfully Added to the Cart</h2></Center>");
		            	rd.forward(request,response);
		            }
		        else
		        {
		        	request.setAttribute("msg","<Center><h2 style=\"color:Green;\">Failed to Add to the Cart</h2></Center>");
		        	rd.forward(request,response);
		        }
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }
	}
}
