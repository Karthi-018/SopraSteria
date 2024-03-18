package edu.training;

import java.io.IOException;
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
 * Servlet implementation class UpdateWishlistServlet
 */
@WebServlet("/UpdateWishlistServlet")
public class UpdateWishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext c = getServletContext(); 
		int cid = Integer.parseInt(c.getAttribute("cid").toString());
		
		String[] ch = request.getParameter("choice").split(":");
		int pid = Integer.parseInt(ch[1]);
	
		try {
			conn = DBConnection.getConnection();
	
			if(ch[0].equals("a"))
			{	
				PreparedStatement pst = conn.prepareStatement("select quantity from cart where prid = ? and custid = ?");
				pst.setInt(1, pid);
				pst.setInt(2, cid);
				ResultSet rst = pst.executeQuery();
		
				
				PreparedStatement pstd = conn.prepareStatement("select quantity from products where pid = ?");
				pstd.setInt(1, pid);
				ResultSet rstd = pstd.executeQuery();
				boolean present = rstd.next();
		
				
				if(rst.next())
				{
			
					PreparedStatement ps1 = conn.prepareStatement("update cart set quantity = quantity + 1, availability = ? where prid = ? and custid = ?");
			
					
					if(present && (rstd.getInt(1)>(rst.getInt(1)+1)))
					{
						ps1.setString(1,"Available");
						
					}
					else
					{
				
						ps1.setString(1,"Not Available");
					}
					
					ps1.setInt(2, pid);
					ps1.setInt(3, cid);
					ps1.executeUpdate();
				}
				else
				{
					
					PreparedStatement ps = conn.prepareStatement("insert into cart values(?,?,?,?)");
					ps.setInt(1, pid);
					ps.setInt(2, cid);
					ps.setInt(3,1);
					
					if(present)
					{
						
						ps.setString(4,"Available");
						
					}
					else
					{
						ps.setString(4,"Not Available");
					}
					ps.executeUpdate();
				}
			}
			PreparedStatement ps1 = conn.prepareStatement("delete from wishlist where prodid = ? and customerid = ?");
			ps1.setInt(1, pid);
			ps1.setInt(2, cid);
            ps1.executeUpdate();
            request.getRequestDispatcher("Wishlist").forward(request, response);


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
