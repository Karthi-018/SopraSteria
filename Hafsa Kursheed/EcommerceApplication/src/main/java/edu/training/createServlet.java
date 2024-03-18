package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createServlet
 */
@WebServlet("/createServlet")
public class createServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("pname");
		String desc = request.getParameter("pdesc");
		int price = Integer.parseInt(request.getParameter("pprice"));
		int quantity = Integer.parseInt(request.getParameter("pquant"));
		
			try {
				conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("insert into products values(?,?,?,?,?)");
	            ps.setInt(1,id);
				ps.setString(2, name);
	            ps.setString(3, desc);
	            ps.setInt(4, price);
	            ps.setInt(5,quantity);
	            int rs = ps.executeUpdate();
	            if(rs>0)
	            {
		            
		            PreparedStatement ps2 = conn.prepareStatement("update cart set availability = ? where prid = ? and quantity <= ?");
		            ps2.setString(1, "Available");
		            ps2.setInt(1,id);
		            ps2.setInt(3, quantity);
		            ps2.executeUpdate();
					
//	            	response.sendRedirect("createProduct.jsp");
	            	request.setAttribute("msg", "PRODUCT ADDED SUCCESSFULLY");
	            	request.getRequestDispatcher("createProduct.jsp").forward(request, response);
//	            	RequestDispatcher rd  = request.getRequestDispatcher("createProduct.jsp?msg='Product created Successfully'");
//	            	rd.forward(request, response);
	            }
			} 
			catch (SQLException e) 
			{
				request.setAttribute("msg", "Error has encountered while creating the product");
				response.getWriter().println(e);
//            	request.getRequestDispatcher("createProduct.jsp").forward(request, response);
//				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
