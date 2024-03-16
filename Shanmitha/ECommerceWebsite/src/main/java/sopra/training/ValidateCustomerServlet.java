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
 * Servlet implementation class ValidateCustomerServlet
 */
@WebServlet("/ValidateCustomerServlet")
public class ValidateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	        PreparedStatement ps = connection.prepareStatement("select * from customer_details where status = ?");
	        ps.setString(1, "inactive");
	        ResultSet rs = ps.executeQuery();
	        
	        PreparedStatement ps1 = connection.prepareStatement("select * from customer_details where status = ?");
	        ps1.setString(1, "active");
	        ResultSet rs1 = ps1.executeQuery();

	        request.setAttribute("resultSet", rs);
	        request.setAttribute("resultSet1", rs1);
	        RequestDispatcher rd = request.getRequestDispatcher("validateCustomer.jsp");
	
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
