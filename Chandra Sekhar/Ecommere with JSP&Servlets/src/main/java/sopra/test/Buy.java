package sopra.test;

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
 * Servlet implementation class Buy
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("buy"));
		response.getWriter().print("Item Bought Successfully");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
			
			PreparedStatement preparedStatement = c.prepareStatement("select * from product where pid = ?");
			preparedStatement.setInt(1,pid);
			
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			if(rs.getInt(5) == 0) {
				PreparedStatement ps = c.prepareStatement("delect from product where pid = ?");
				ps.setInt(1,pid);
				ps.executeUpdate();
				out.println(rs.getString(2) + "Product is out of Stock");
				}
			else
			{
				out.println("Item" + rs.getString(2) + "is purchased successfully \n .....will be delevired to you in a day");
				int new_quant = rs.getInt(5) -1;
				PreparedStatement ps2 = c.prepareStatement("update product set pquant = ? WHERE pid = ?");
				ps2.setInt(1,new_quant);
				ps2.setInt(2,pid);
				ps2.executeUpdate();
				out.println(new_quant + " " + pid);
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
