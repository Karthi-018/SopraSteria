package action.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import training.pojo;

/**
 * Servlet implementation class RemoveWish
 */
@WebServlet("/RemoveWish")
public class RemoveWish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveWish() {
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
		List<pojo> list=new ArrayList<>();
		String email=CustLogin.getEmail();
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
		int del=Integer.parseInt(request.getParameter("Id"));
		PreparedStatement ps = connection.prepareStatement("Delete from wishlist where productID="+del+";");
		ps.executeUpdate();
		
		java.sql.Statement statement= connection.createStatement();
		ResultSet rs= statement.executeQuery("Select * from action where productID IN(Select productID from wishlist where email='"+email+"');");
        while(rs.next()){
        	list.add(new pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            
        }
        request.setAttribute("actionlist", list);
        request.getRequestDispatcher("wishlist.jsp").forward(request, response);
        connection.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
