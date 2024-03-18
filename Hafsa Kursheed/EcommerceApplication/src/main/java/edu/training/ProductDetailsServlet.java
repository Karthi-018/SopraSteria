package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("prodid"));
		try
		{
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select pname,pdesc,price from products where pid=?");
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			request.setAttribute("pid", pid);
			request.setAttribute("pname", rs.getString(1));
			request.setAttribute("pdesc", rs.getString(2));
			request.setAttribute("pprice", rs.getInt(3));
			request.getRequestDispatcher("Product.jsp").forward(request, response);
			
			
		}
		catch(SQLException e)
		{
			response.getWriter().println(e);
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
