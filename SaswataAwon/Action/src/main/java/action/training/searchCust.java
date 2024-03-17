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
 * Servlet implementation class searchCust
 */
@WebServlet("/searchCust")
public class searchCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchCust() {
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
			String search=request.getParameter("pName");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
			Statement statement= (Statement) connection.createStatement();
		
			
			ResultSet rs= statement.executeQuery("Select * from action where product_name='"+search+"';");
            if(rs.next()){
                actionlist.add(new pojo(rs.getInt(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4))));
                request.setAttribute("actionlist", actionlist);
                request.setAttribute("msg", "Product is found");
                request.getRequestDispatcher("SearchCust.jsp").forward(request, response);
                
            }
            
            else
            {
            	request.setAttribute("msg", "Product is not found");
            	
            	request.getRequestDispatcher("SearchCust.jsp").forward(request, response);
            }

			
			
			
			
			            
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
