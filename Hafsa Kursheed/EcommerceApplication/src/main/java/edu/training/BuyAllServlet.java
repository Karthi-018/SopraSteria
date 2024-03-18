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
 * Servlet implementation class BuyAllServlet
 */
@WebServlet("/BuyAllServlet")
public class BuyAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext c =getServletContext(); 
		int cid = Integer.parseInt(c.getAttribute("cid").toString());
		boolean flag = false;
		
		try
		{
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select prid,quantity from cart where custid = ? and availability = ? ");
			ps.setInt(1, cid);
			ps.setString(2, "Available");
			ResultSet rs = ps.executeQuery();
			request.setAttribute("result", rs);
			
			
			while(rs.next())
			{
				flag = true;
				
				PreparedStatement psd = conn.prepareStatement("select quantity from products where pid = ?");
				psd.setInt(1, rs.getInt(1));
				ResultSet rsd = psd.executeQuery();
				rsd.next();
				
				int quant = rs.getInt(2)-rsd.getInt(1);
				
				if(quant==0)
				{
					PreparedStatement psd1 = conn.prepareStatement("delete from products where pid=?");
					psd1.setInt(1, rs.getInt(1));
					psd1.executeUpdate();
					
					PreparedStatement psd2 = conn.prepareStatement("update cart set availability = ? where prid = ?");
					psd2.setString(1, "Not Available");
					psd2.setInt(2, rs.getInt(1));
					psd2.executeUpdate();
					
				}
				else
				{
					PreparedStatement psd11 = conn.prepareStatement("update products set quantity = quantity - ? where pid = ?");
					psd11.setInt(1, rs.getInt(2));
					psd11.setInt(2, rs.getInt(1));
					psd11.executeUpdate();
					
					
					
					PreparedStatement psd12 = conn.prepareStatement("update cart set availability = ? where prid = ? and quantity > ?");
					psd12.setString(1, "Not Available");
					psd12.setInt(2, rs.getInt(1));
					psd12.setInt(3,quant);
					psd12.executeUpdate();
				}
				
				PreparedStatement ps2 = conn.prepareStatement("delete from cart where prid = ? and custid = ?");
				ps2.setInt(1, rs.getInt(1));
				ps2.setInt(2, cid);
				ps2.executeUpdate();
				
				
		 }
			if(flag)
			{
				response.getWriter().println("<html><body><a href='Customerhome.jsp'>Go To Home</a><center><h1>Bought All Available Products</h1></center></body></html>");
			}
			else
			{
				response.getWriter().println("<html><body><a href='Customerhome.jsp'>Go To Home</a><center><h1>No Products Are Available To Buy</h1></center></body></html>");
			}
			
			
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
