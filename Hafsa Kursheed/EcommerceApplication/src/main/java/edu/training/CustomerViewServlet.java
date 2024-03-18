package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerViewServlet
 */
@WebServlet("/CustomerViewServlet")
public class CustomerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", request.getAttribute("msg"));
		
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select pid,pname from products");
            ResultSet rs = ps.executeQuery();
            request.setAttribute("result", rs);
            request.getRequestDispatcher("CustomerViewProduct.jsp").forward(request, response);
//            	RequestDispatcher rd  = request.getRequestDispatcher("createProduct.jsp?msg='Product created Successfully'");
//            	rd.forward(request, response);
		} 
		catch (SQLException e) 
		{
//			request.setAttribute("msg", "Error has encountered while creating the product");
//        	request.getRequestDispatcher("createProduct.jsp").forward(request, response);
//			e.printStackTrace();
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
