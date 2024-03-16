package edu.servletTraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCartDelete
 */
@WebServlet("/AddCartDelete")
public class AddCartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	       String s=(String) session.getAttribute("username");
	       PrintWriter out=response.getWriter();
	 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
				PreparedStatement ps2=c.prepareStatement("select quant from productdata where id=?");
				ps2.setInt(1,Integer.parseInt(request.getParameter("cart") ) );
				ResultSet rs1=ps2.executeQuery();
				rs1.next();
				if(rs1.getInt(1)>0)
				{
				PreparedStatement ps1=c.prepareStatement("select * from cartlist where cemail=? and pid=?");
				ps1.setString(1,s );
				ps1.setInt(2,Integer.parseInt(request.getParameter("cart") ) );
				ResultSet rs=ps1.executeQuery();
				if(rs.next())
				{
			         PreparedStatement ps=c.prepareStatement("update cartlist set quantity=? where cemail=? and pid=?");
					 ps.setInt(1,rs.getInt(3)+1);
					 ps.setString(2, s);
					 ps.setInt(3,Integer.parseInt(request.getParameter("cart") ));
					 ps.executeUpdate();	
					
				}
			    else
				{
				PreparedStatement ps3=c.prepareStatement("insert into cartlist values(?,?,?)");
				ps3.setInt(1,Integer.parseInt(request.getParameter("cart")));
				ps3.setString(2, s);
				ps3.setInt(3,1 );
				ps3.executeUpdate();	
				
				}
				PreparedStatement ps4=c.prepareStatement("delete from wishlist where pid=? and cemail=?");
				ps4.setInt(1,Integer.parseInt(request.getParameter("cart")));
				ps4.setString(2,s );
				ps4.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("WishList.jsp");
				rd.forward(request, response);
				}
				else
				{
					out.println("No Stock");
				}
			    
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
