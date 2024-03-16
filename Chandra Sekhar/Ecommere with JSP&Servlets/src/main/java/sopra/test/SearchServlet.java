package sopra.test;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("sname");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
			
			PreparedStatement ps = c.prepareStatement("select * from product where pname = ?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			List<Product> lst = new ArrayList<Product>();
			while(rs.next())
			{
				lst.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5)));
			}
				
			
			
			request.setAttribute("message", "<h2> : " + lst.get(0).getPid() + " " + lst.get(0).getPname()+ " " + lst.get(0).getPdesc()+ " " + lst.get(0).getPrice() + " " + lst.get(0).getPquant() + " :</h2>");
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			
			c.close();
		}
			
			
			catch(Exception e){out.println(e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
