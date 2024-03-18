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
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("searchProd"));
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from products where pid = ?");
			ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
//            	response.sendRedirect("createProduct.jsp");
            	request.setAttribute("pid", rs.getInt(1));
            	request.setAttribute("pname", rs.getString(2));
            	request.setAttribute("pdesc", rs.getString(3));
            	request.setAttribute("pprice", rs.getInt(4));
            	request.setAttribute("pquant", rs.getInt(5));
            	request.setAttribute("msg", "PRODUCT FOUND");
            	request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
//            	RequestDispatcher rd  = request.getRequestDispatcher("createProduct.jsp?msg='Product created Successfully'");
//            	rd.forward(request, response);
            }
            else
            {
            	request.setAttribute("msg", "NO SUCH PRODUCT HAS FOUND");
            	request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
            }
		} 
		catch (SQLException e) 
		{
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
