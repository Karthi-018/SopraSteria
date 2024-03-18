package ecom.pro;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class Delete
*/
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int delete=Integer.parseInt(request.getParameter("delete"));
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Root");
            Statement s = connection.createStatement();
            s.executeUpdate("DELETE FROM product WHERE pid=" + delete );
//            request.setAttribute("msg","<h1>Product "+delete+" is deleted</h1>");
            request.getRequestDispatcher("View.jsp").forward(request,response);    
           }
        catch(Exception e)
    	{
        	response.getWriter().println(e);
//        	response.getWriter().println("product deleted succesfully");
        	
//       	request.setAttribute("msg","<h1>Error occured</h1>");
//       	request.getRequestDispatcher("View").forward(request,response);
    	}
		response.getWriter().println("product deleted succesfully");
 
	}
 
}
