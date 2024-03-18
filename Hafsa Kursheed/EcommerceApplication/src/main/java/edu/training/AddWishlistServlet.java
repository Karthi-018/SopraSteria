package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddWishlistServlet
 */
@WebServlet("/AddWishlistServlet")
public class AddWishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext c =getServletContext(); 
		int cid = Integer.parseInt(c.getAttribute("cid").toString());
		PrintWriter out = response.getWriter();
		
		try {
			
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into wishlist values(?,?)");
			ps.setInt(1, Integer.parseInt(request.getParameter("wishprod")));
			ps.setInt(2,cid);
			int r = ps.executeUpdate();
			
			if(r>0)
			{
				request.setAttribute("msg","Product Added to Wishlist");
//				out.println("<html><body><center><h1>Product Added to Wishlist</h1><center><body></html>");
			}
			else
			{
				request.setAttribute("msg","Error Occured While Adding the Product to Wishlist");
//				
//				out.println("<html><body><center><h1>Error Occured While Adding the Product to Wishlist</h1><center><body></html>");
			}
			
            request.getRequestDispatcher("CustomerViewServlet").forward(request, response);

		} 
		catch (SQLException e) 
		{

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
