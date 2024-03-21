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
 * Servlet implementation class CartViewServlet
 */
@WebServlet("/CartViewServlet")
public class CartViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	            
			
			HttpSession session = request.getSession();
			String uname = session.getAttribute("Username").toString();
			
			Connection c = DbConnection.getConnection();
	        Statement statement = c.createStatement(); 
	        ResultSet rs=statement.executeQuery("Select c.cartid, c.pid, p.pname, c.pquantity, (c.pquantity)*(p.pcost) from product p join cart c using(pid) where c.uname='"+uname+"'");
	        
	        RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
	        
	        request.setAttribute("resultset", rs);
	        rd.forward(request,response);

    	} 
	catch (Exception e) {
        System.out.println(e);
    }
	}
}
