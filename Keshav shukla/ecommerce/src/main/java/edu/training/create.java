package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class create
 */
@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost: 3306/ecommerce","root","Sumit@123");
			PreparedStatement ps =connection.prepareStatement("insert into customer values(?,?,?,?,?)");
			ps.setInt(1,Integer.parseInt(request.getParameter("productid")));
			ps.setString(2,request.getParameter("productname"));
			ps.setString(3,request.getParameter("productdesc"));
			ps.setInt(4,Integer.parseInt(request.getParameter("productquantity")));
			ps.setInt(5,Integer.parseInt(request.getParameter("productprice")));
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.getWriter().println("Not Found");
			response.getWriter().println(e);
		}
		
		

	}

	private PrintWriter PrintWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
