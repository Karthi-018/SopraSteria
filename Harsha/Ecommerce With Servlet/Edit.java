package edu.learning;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int edit=Integer.parseInt(request.getParameter("edit"));
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
            Statement s = connection.createStatement();
            ResultSet result=s.executeQuery("SELECT * from productdb WHERE product_id=" + edit );
           if(result.next())
           {
        	   int id = result.getInt(1);
        	    request.setAttribute("id", id);
        	    String name = result.getString(2);
        	    request.setAttribute("name", name);
        	    int price = result.getInt(3);
        	    request.setAttribute("price", price);
        	    int quant = result.getInt(4);
        	    request.setAttribute("quant", quant);
        	    request.getRequestDispatcher("edit.jsp").forward(request, response);
           }
           else
           {
        	   request.setAttribute("msg", "<h1>Product not found</h1>");
        	   request.getRequestDispatcher("edit.jsp").forward(request, response); 
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
