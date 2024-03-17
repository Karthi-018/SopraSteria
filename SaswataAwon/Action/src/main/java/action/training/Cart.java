package action.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cart=Integer.parseInt(request.getParameter("Id"));
		String email=CustLogin.getEmail();

		try {
			List<pojo> list=new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
		Statement statement= connection.createStatement();        
		
		ResultSet r= statement.executeQuery("Select * from cart where productID="+cart+";");
		if(!r.next()) {
		PreparedStatement pr= connection.prepareStatement("Insert into Cart values(?,?,?)");
		pr.setString(1,email);
		pr.setInt(2,cart);
		pr.setInt(3, 1);
		pr.executeUpdate();
		}
		
		
		ResultSet rs= statement.executeQuery("Select * from action where productID IN(Select productID from Cart where email='"+email+"');");
        while(rs.next()){
        	list.add(new pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            
        }
        request.setAttribute("actionlist", list);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
