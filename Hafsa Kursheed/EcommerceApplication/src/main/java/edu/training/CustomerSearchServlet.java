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
 * Servlet implementation class CustomerSearchServlet
 */
@WebServlet("/CustomerSearchServlet")
public class CustomerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("searchprod");
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from products where pname like ?");
			ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();
            request.setAttribute("result", rs);
            if(rs.next())
            {
            request.setAttribute("msg", "exists");
            }
            else
            {
            	request.setAttribute("msg", "notexists");
            }
        	request.getRequestDispatcher("CustomerSearch.jsp").forward(request, response);
        	
            	
		} 
		catch (SQLException e) 
		{
			response.getWriter().println(e);
//			request.setAttribute("msg", "NO SUCH PRODUCT HAS FOUND");
//        	request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
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
