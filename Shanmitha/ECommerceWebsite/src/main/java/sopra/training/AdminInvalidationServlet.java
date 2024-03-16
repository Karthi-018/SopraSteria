package sopra.training;

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

/**
 * Servlet implementation class AdminInvalidationServlet
 */
@WebServlet("/AdminInvalidationServlet")
public class AdminInvalidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInvalidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String email = request.getParameter("invalidate");
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	    
	    
	    PreparedStatement s=c.prepareStatement("update customer_details set status = ?, cust_Id = ? where email = ?");
	    s.setString(1, "inactive");
	    s.setInt(2, 0);
	    s.setString(3,email);
	    s.executeUpdate();
	    response.sendRedirect("ValidateCustomerServlet");
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
