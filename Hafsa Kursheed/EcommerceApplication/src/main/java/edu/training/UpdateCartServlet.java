package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	Connection conn = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext c =getServletContext(); 
		int cid = Integer.parseInt(c.getAttribute("cid").toString());
		
		String[] ch = request.getParameter("choice").split(":");
		int pid = Integer.parseInt(ch[1]);
	
		try {
			conn = DBConnection.getConnection();
			if(ch[0].equals("a"))
			{
				PreparedStatement ps = conn.prepareStatement("insert into wishlist values(?,?)");
				ps.setInt(1, pid);
				ps.setInt(2, cid);
				ps.executeUpdate();
			}
			PreparedStatement ps1 = conn.prepareStatement("delete from cart where prid = ? and custid = ?");
			ps1.setInt(1, pid);
			ps1.setInt(2, cid);
            ps1.executeUpdate();

			request.getRequestDispatcher("Cart").forward(request, response);

		} 
		catch (SQLException e) 
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
