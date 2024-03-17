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
 * Servlet implementation class Edit2
 */
@WebServlet("/Edit2")
public class Edit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<pojo> list=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
			int pr=Integer.parseInt(request.getParameter("price"));
			int q=Integer.parseInt(request.getParameter("qty"));
			int id= Integer.parseInt(request.getParameter("id"));
			
			if(pr>0 && q>0) {
			PreparedStatement ps = connection.prepareStatement("update action set product_name=?, product_desc=?, price=?,qty=? where productID="+id);
	        ps.setString(1,request.getParameter("pname"));
	        ps.setString(2,request.getParameter("pdesc"));
	        ps.setInt(3,pr);
	        ps.setInt(4,q);
			

	        ps.executeUpdate();
			}
			else {
				request.setAttribute("msg", "Error Quantity or Price cannot be 0 or neg");
		        request.getRequestDispatcher("List.jsp").forward(request, response);
				
			}

	        
			java.sql.Statement statement= connection.createStatement();
			ResultSet rs= statement.executeQuery("Select * from action;");
	        while(rs.next()){
	        	list.add(new pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
	            
	        }
	        request.setAttribute("actionlist", list);
	        request.getRequestDispatcher("List.jsp").forward(request, response);
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
