package sopra.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WishList
 */
@WebServlet("/WishList")
public class WishList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		List<Product> wish = new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
			
			PreparedStatement preparedStatement = c.prepareStatement("select * from product where pid = ?");
			preparedStatement.setInt(1,pid);
			
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			
			try {
				PreparedStatement ps = c.prepareStatement("insert into wishlist values(?,?,?,?)");
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, rs.getString(2));
				ps.setString(3, rs.getString(3));
				ps.setInt(4, rs.getInt(4));
				int updated = ps.executeUpdate();
				
				if(updated > 0) {
					response.sendRedirect("WishList.jsp");
				}
			}
			catch(SQLIntegrityConstraintViolationException e){
				out.println("Item already added into Wishlist");
			}
			
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
