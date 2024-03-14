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

/**
 * Servlet implementation class CustomerBuyServlet
 */
@WebServlet("/CustomerBuyServlet")
public class CustomerBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("buy"));
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	    PreparedStatement s=c.prepareStatement("select * from product where id = ?");
	    s.setInt(1,id);
	    ResultSet rs = s.executeQuery();
	    rs.next();
	    	id = rs.getInt(1);
	    	int quantity = rs.getInt(5)-1;
	    	if(quantity>=0)
	    	{
	    	
	    	s=c.prepareStatement("update product set quantity = ? where id = ?");
	    	s.setInt(1,quantity);
	    	s.setInt(2,id);
	    	s.executeUpdate();
	    	}
	    	RequestDispatcher rd = request.getRequestDispatcher("/CustomerViewServlet");
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
