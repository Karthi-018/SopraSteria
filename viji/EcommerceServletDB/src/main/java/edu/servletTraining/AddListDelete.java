package edu.servletTraining;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddListDelete
 */
@WebServlet("/AddListDelete")
public class AddListDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddListDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session=request.getSession();
	       String s=(String) session.getAttribute("username");
	       PrintWriter out=response.getWriter();
	       
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
				PreparedStatement ps1=c.prepareStatement("select * from wishlist where cemail=? and pid=?");
				ps1.setString(1,s );
				ps1.setInt(2,Integer.parseInt(request.getParameter("wishList") ) );
				ResultSet rs=ps1.executeQuery();
				if(rs.next()==false)
				{
					PreparedStatement ps=c.prepareStatement("insert into wishlist values(?,?)");
					ps.setInt(1,Integer.parseInt(request.getParameter("wishList")));
					ps.setString(2, s);
		            ps.executeUpdate();
		            PreparedStatement ps2=c.prepareStatement("delete from cartlist where pid=? and cemail=?");
					ps2.setInt(1,Integer.parseInt(request.getParameter("wishList") ) );
					ps2.setString(2,s );
					ps2.executeUpdate();
				}
				response.sendRedirect("Cart.jsp");
			}
			catch(Exception e)
			{
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
