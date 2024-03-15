package sopra.training;

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
 * Servlet implementation class MoveToCartServlet
 */
@WebServlet("/MoveToCartServlet")
public class MoveToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		int cust_ID = (int) session.getAttribute("cust_ID");
		int id=Integer.parseInt(request.getParameter("move"));
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
	    Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	    
	    PreparedStatement s2=c.prepareStatement("insert into cart values(?,?)");
	    s2.setInt(1, cust_ID);
	    s2.setInt(2, id);
	    s2.executeUpdate();
	    
	    PreparedStatement s1=c.prepareStatement("delete from wishlist where product_ID = ?");
	    s1.setInt(1,id);
	    s1.executeUpdate();
	    
        RequestDispatcher rd = request.getRequestDispatcher("/DisplayWishlistServlet");
        rd.forward(request, response);

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
