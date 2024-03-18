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
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int prid = Integer.parseInt(request.getParameter("delprodid"));
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from products where pid = ?");
			ps.setInt(1, prid);
            int rs = ps.executeUpdate();
            
            if(rs>0)
            {
            	PreparedStatement ps2 = conn.prepareStatement("update cart set availability = ? where prid = ?");
	            ps2.setString(1, "Not Available");
	            ps2.setInt(1,prid);
	            ps2.executeUpdate();
	            request.getRequestDispatcher("viewServlet").forward(request, response);
            }
            
//            	RequestDispatcher rd  = request.getRequestDispatcher("createProduct.jsp?msg='Product created Successfully'");
//            	rd.forward(request, response);
		} 
		catch (SQLException e) 
		{
			response.getWriter().println("Error has encountered while deleting the product");
//			request.setAttribute("msg", "Error has encountered while deleting the product");
//        	request.getRequestDispatcher("viewServlet").forward(request, response);
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
