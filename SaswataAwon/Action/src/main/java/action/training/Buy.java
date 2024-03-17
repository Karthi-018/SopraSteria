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
try {
			
			List<pojo> actionlist=new ArrayList<>();
			int con=Integer.parseInt(request.getParameter("confirm"));
			int qty= Integer.parseInt(request.getParameter("qty"));
			String name=request.getParameter("pName");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
			Statement statement= (Statement) connection.createStatement();
			PreparedStatement pr= connection.prepareStatement("Select qty from action where product_name=?");
			pr.setString(1, name);
			
			int q= 0;
			ResultSet r= pr.executeQuery();
			if(r.next()) {
				q=r.getInt(1)-qty;
			}
			
			if(con==1 && qty>0) {
				PreparedStatement ps = connection.prepareStatement("update action set qty=? where product_name='"+name+"'");
		        ps.setInt(1,q);
				

		        ps.executeUpdate();
		        
		        
				}
			if(q<=0) {
				PreparedStatement pa = connection.prepareStatement("Delete from action where qty<=0;");
				

		        pa.executeUpdate();
			}
		
			ResultSet rs= statement.executeQuery("Select product_name,product_desc,price from action;");
            while(rs.next()){
            	actionlist.add(new pojo(rs.getString(1),rs.getString(2),rs.getInt(3)));
                
            }
            request.setAttribute("actionlist", actionlist);
            request.getRequestDispatcher("listCust.jsp").forward(request, response);
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
