package edu.learning;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        int pid=Integer.parseInt(request.getParameter("pid"));
	        String pname=request.getParameter("pname");
	        int pprice=Integer.parseInt(request.getParameter("pprice"));
	        int pqty=Integer.parseInt(request.getParameter("pqty"));
	       
	        	try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
	                Statement s = connection.createStatement();
	                int result=s.executeUpdate("Insert into productdb values(" + pid + ", '" + pname + "', '" + pprice + "', " + pqty + ")");
	                if(result>0)
	                {
	                	request.setAttribute("msg","<h1>Product "+pname+" is added</h1>");
	                	request.getRequestDispatcher("create.jsp").forward(request,response);
	                }
	                
	            }
	            catch(Exception e)
	        	{
	            	request.setAttribute("msg","<h1>Error occured</h1>");
                	request.getRequestDispatcher("create.jsp").forward(request,response);
	            	
	        	}
	        

	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
