package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Ccart
 */
@WebServlet("/Ccart")
public class Ccart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ccart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String custemail=cusactivation.custemail;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost: 3306/ecommerce","root","Sumit@123");
				PreparedStatement ps = conn.prepareStatement("insert into cart values( ? ,?, ?)");
				ps.setString(1, custemail);
				ps.setInt(2,Integer.parseInt(request.getParameter("cart")));
				ps.setInt(3, 1);
				ps.executeUpdate();
//				ResultSet result= ps.executeQuery();
//				request.setAttribute("rs",result);
//				request.getRequestDispatcher("cartview.jsp").forward(request,response);
//				ps.executeUpdate();
				
					response.sendRedirect("customerview");
				
		} catch (Exception e) {
			out.println(e);
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
