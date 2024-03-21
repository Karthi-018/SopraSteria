package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ccart1
 */
@WebServlet("/Ccart1")
public class Ccart1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ccart1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().println("hello");
//		response.getWriter().println("hello");
		String custemail=cusactivation.custemail;
//		response.getWriter().println("hi");

		try {
			 Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost: 3306/ecommerce","root","Sumit@123");
				PreparedStatement ps =conn.prepareStatement("SELECT p.productname, p.productdesc, c.productquantity, p.productprice FROM customer p INNER JOIN cart c ON p.productid = c.productid WHERE email = ?");
//				response.getWriter().println("hi2");
				ps.setString(1,custemail);
				ResultSet result=ps.executeQuery();
//				response.getWriter().println("hi3");
				request.setAttribute("rs",result);
//				response.getWriter().println("hi4");
				request.getRequestDispatcher("cartview.jsp").forward(request, response);
//				response.getWriter().println("hi5");

				
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().println(e);
			response.getWriter().println("hi6");
			
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
