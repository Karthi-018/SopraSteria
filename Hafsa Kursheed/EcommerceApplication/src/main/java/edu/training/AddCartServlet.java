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
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext c = getServletContext(); 
		int cid = Integer.parseInt(c.getAttribute("cid").toString());
		PrintWriter out = response.getWriter();
		
		try {
			
			conn = DBConnection.getConnection();
			
			PreparedStatement pst2 = conn.prepareStatement("select quantity from products where pid = ?");
			pst2.setInt(1, Integer.parseInt(request.getParameter("cartprod")));
			ResultSet rst2 = pst2.executeQuery();
			rst2.next();
			int n = rst2.getInt(1);
			
			PreparedStatement pst = conn.prepareStatement("select quantity from cart where prid = ? and custid =?");
			pst.setInt(1, Integer.parseInt(request.getParameter("cartprod")));
			pst.setInt(2,cid);
			ResultSet rst = pst.executeQuery();
			
			
			int r=-1;
			if(rst.next())
			{
				PreparedStatement ps = conn.prepareStatement("update cart set quantity = quantity +1, availability = ? where prid = ? and custid = ?");
				
				int quant = rst.getInt(1);
				if((quant+1)>n)
				{
					ps.setString(1,"Not Available");
				}
				else
				{		
					ps.setString(1,"Available");
				}
				ps.setInt(2, Integer.parseInt(request.getParameter("cartprod")));
				ps.setInt(3,cid);
				r = ps.executeUpdate();
				
			}
			else
			{
				PreparedStatement ps = conn.prepareStatement("insert into cart values(?,?,?,?)");
				ps.setInt(1, Integer.parseInt(request.getParameter("cartprod")));
				ps.setInt(2,cid);
				ps.setInt(3,1);
				ps.setString(4, "Available");
				r = ps.executeUpdate();
			}
			
			if(r>0)
			{
				request.setAttribute("msg","Product Added to Cart");
//				out.println("<html><body><center><h1>Product Added to Cart</h1><center><body></html>");
			}
			else
			{
				request.setAttribute("msg","Error Occured While Adding the Product to Cart");
//				out.println("<html><body><center><h1></h1><center><body></html>");
			}	
			request.getRequestDispatcher("CustomerViewServlet").forward(request, response);

		} 
		catch (SQLException e) 
		{
//			out.println("Not working");
			out.println(e);
//				System.out.println(e);
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
