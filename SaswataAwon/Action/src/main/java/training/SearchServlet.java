package training;

import java.io.IOException;
import java.io.PrintWriter;
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
		// TODO Auto-generated method stub
		
		try {
			
			List<pojo> actionlist=new ArrayList<>();
			int search=Integer.parseInt(request.getParameter("pid"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
			Statement statement= (Statement) connection.createStatement();
		
			
			ResultSet rs= statement.executeQuery("Select * from action where productID="+search+";");
            if(rs.next()){
                actionlist.add(new pojo(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(5))));
                request.setAttribute("actionlist", actionlist);
                request.setAttribute("msg", "Product is found");
                request.getRequestDispatcher("Search.jsp").forward(request, response);
                
            }
            
            else
            {
            	request.setAttribute("msg", "Product is not found");
            	
            	request.getRequestDispatcher("Search.jsp").forward(request, response);
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
