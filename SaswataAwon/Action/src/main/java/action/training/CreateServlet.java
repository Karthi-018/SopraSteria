package action.training;

import java.beans.Statement;
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
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
		
		PrintWriter out= response.getWriter();response.getWriter();
		int pr=Integer.parseInt(request.getParameter("price"));
		int q=Integer.parseInt(request.getParameter("qty"));
		
		if(pr>0 && q>0) {
		PreparedStatement ps = connection.prepareStatement("insert into action values(?,?,?,?,?);");
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        ps.setString(2,request.getParameter("pname"));
        ps.setString(3,request.getParameter("pdesc"));
        ps.setInt(4,pr);
        ps.setInt(5,q);
        
        
        ps.executeUpdate();
        request.setAttribute("msg", "Product is added");
        request.getRequestDispatcher("Create.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", "Error Quantity or Price cannot be 0 or neg");
	        request.getRequestDispatcher("Create.jsp").forward(request, response);
			
		}

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			 request.setAttribute("msg", "Error product id cannot be same");
		        request.getRequestDispatcher("Create.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
