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
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext c = getServletContext(); 
		int cid = Integer.parseInt(c.getAttribute("cid").toString());
		try {
			
			 
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select p.pid, p.pname, p.pdesc,p.price,c.quantity, c.availability from cart c join products p on c.prid = p.pid where c.custid = ?");
			ps.setInt(1,cid);
	        ResultSet rs = ps.executeQuery();
	        request.setAttribute("result", rs);
//	           
//			conn = DBConnection.getConnection();
//			PreparedStatement ps = conn.prepareStatement("select * from products where pid in (select prid from cart where custid=?)");
//			ps.setInt(1,cid);
//            ResultSet rs = ps.executeQuery();
//            request.setAttribute("result", rs);
//            
//            PreparedStatement ps1 = conn.prepareStatement("select quantity,availability from cart where custid= ?");
//			ps1.setInt(1,cid);
//            ResultSet rs1 = ps1.executeQuery();
//            request.setAttribute("res", rs1);
                       
            request.getRequestDispatcher("ViewCart.jsp").forward(request, response);

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
