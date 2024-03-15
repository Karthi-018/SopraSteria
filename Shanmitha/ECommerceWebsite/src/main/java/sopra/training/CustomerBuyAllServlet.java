package sopra.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerBuyAllServlet
 */
@WebServlet("/CustomerBuyAllServlet")
public class CustomerBuyAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerBuyAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    List<Integer> list = new ArrayList<Integer>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	    PreparedStatement s=c.prepareStatement("select * from cart");
	    ResultSet rs = s.executeQuery();
	    while(rs.next())
	    {
	    	list.add(rs.getInt(2));
	    }
	    for(Integer i:list)
	    {
	    	 PreparedStatement s1=c.prepareStatement("select * from product where id=?");
	    	 s1.setInt(1,i);
	    	 ResultSet rs1 = s1.executeQuery();
	    	 rs1.next();
	    	 int quantity = rs1.getInt(5)-1;
	    	 if(quantity>=0)
	    	 {
	    		 PreparedStatement s2 = c.prepareStatement("update product set quantity = ? where id = ?");
	    		 s2.setInt(1,quantity);
	    		 s2.setInt(2,i);
	    		 s2.executeUpdate();
	    	 }
	    }
	    
	    for(Integer i:list)
	    {
	    	PreparedStatement s3 = c.prepareStatement("delete from cart where product_ID=?");
	    	s3.setInt(1, i);
	    	s3.executeUpdate();
	    }
	    
	    	RequestDispatcher rd = request.getRequestDispatcher("/addToCart.jsp");
			rd.forward(request, response);
	}catch(Exception e)
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
