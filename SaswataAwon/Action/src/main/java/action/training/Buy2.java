package action.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import training.pojo;

/**
 * Servlet implementation class Buy2
 */
@WebServlet("/Buy2")
public class Buy2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buy=request.getParameter("pName");
		try {
			List<pojo> actionlist=new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
		Statement statement= connection.createStatement();
	
		
		ResultSet rs= statement.executeQuery("Select * from action where product_name='"+buy+"'");
		if(rs.next()) {
			actionlist.add(new pojo(rs.getString(2),rs.getString(3),rs.getInt(4)));
			request.setAttribute("actionlist", actionlist);
            request.getRequestDispatcher("Buy.jsp").forward(request, response);
		}
		
		
		
		
		} 
	
		catch(Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
