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
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session=request.getSession();
       String s=(String)session.getAttribute("username");
       PrintWriter out=response.getWriter();
		try {
			int quan;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
			PreparedStatement ps1=c.prepareStatement("select  quant from productData where id=?");
			ps1.setInt(1,Integer.parseInt(request.getParameter("buy")) );
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1)>0)
				{
					PreparedStatement ps=c.prepareStatement("update productData set quant=? where id=?");
					ps.setInt(1,rs.getInt(1)-1 );
					ps.setInt(2, Integer.parseInt(request.getParameter("buy")));
					ps.executeUpdate();
				}
//			if(Integer.parseInt(request.getParameter("quantity"))>rs.getInt(1))
//			{
//				out.println("<html><body><h3>Only "+rs.getInt(1)+" available</h3></body></html>");
//			}
			else
			{
			PreparedStatement ps=c.prepareStatement("update productData set quant=? where id=?");
			ps.setInt(1,rs.getInt(1)-Integer.parseInt(request.getParameter("quantity")) );
			ps.setInt(2, Integer.parseInt(request.getParameter("buy")));
			ps.executeUpdate();
			}	
			}
			response.sendRedirect("View.jsp");
       }
       catch(Exception e)
       {
    	   out.println(e);
       }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
