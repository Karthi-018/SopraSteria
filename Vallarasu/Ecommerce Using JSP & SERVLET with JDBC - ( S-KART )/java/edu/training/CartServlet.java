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
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
				
				int pid=Integer.parseInt(request.getParameter("pid"));
		        int pquantity=Integer.parseInt(request.getParameter("pquantity"));
		 
		        PreparedStatement ps= c.prepareStatement("INSERT INTO cart (uname,pid,pquantity) VALUES (?,?,?)");
		        ps.setString(1,uname);
		        ps.setInt(2,pid);
		        ps.setInt(3,pquantity);
		        result=ps.executeUpdate();
		        
		        RequestDispatcher rd=request.getRequestDispatcher("CustomerViewProduct.jsp");
		        
		        
		        Statement statement = c.createStatement();   
		        ResultSet rs=statement.executeQuery("Select * from product");
		        request.setAttribute("resultset", rs);
		        
		        
		        if(result>0)
		            {            	
		//            	response.sendRedirect("CreateProduct.jsp");
		            	
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
