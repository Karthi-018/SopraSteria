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
 * Servlet implementation class Qty
 */
@WebServlet("/Qty")
public class Qty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<PCart> qlist=new ArrayList<>();
		List<pojo> list=new ArrayList<>();
		int q=Integer.parseInt(request.getParameter("qty"));
		String email=CustLogin.getEmail();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
		Statement statement= connection.createStatement();   
		
		PreparedStatement ps= connection.prepareStatement("Update cart set quantity=? where email='"+email+"'");
		
		ps.setInt(1, q);
		
		ResultSet rs= statement.executeQuery("Select * from action where productID IN(Select productID from Cart where email='"+email+"');");
        while(rs.next()){
        	list.add(new pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            
        }
        
        ResultSet ra= statement.executeQuery("Select * from cart where productID IN(Select productID from Cart where email='"+email+"');");
        while(ra.next()){
        	qlist.add(new PCart(ra.getString(1),ra.getInt(2),ra.getInt(3)));
            
        }
        
        
        request.setAttribute("actionlist", list);
        request.setAttribute("qlist", q);
        request.getRequestDispatcher("Cart3.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
