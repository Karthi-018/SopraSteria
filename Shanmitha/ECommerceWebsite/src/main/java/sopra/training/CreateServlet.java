package sopra.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		
		try
		{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
	        PreparedStatement ps = connection.prepareStatement("insert into product value(?,?,?,?,?)");
	        ps.setString(1, id);
	        ps.setString(2, name);
	        ps.setString(3, desc);
	        ps.setString(4, price);
	        ps.setString(5, quantity);
	        
	        int n = ps.executeUpdate();

	        if(n>0)
	        {
	        	response.sendRedirect("createProduct.jsp");
	        }
	        else
	        {
	        	response.sendRedirect("home.jsp");
	        }     
	           
		}
		catch(Exception e)
		{
			response.getWriter().println("<h1>"+e.getStackTrace()+"</h1>");
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
