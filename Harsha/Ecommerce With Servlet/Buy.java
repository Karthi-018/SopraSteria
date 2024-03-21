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
		String name=request.getParameter("buy");
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
            Statement s = connection.createStatement();
            ResultSet result=s.executeQuery("Select * from productdb where product_name='"+name+"'");
            if (result.next()) {
                int pqty = result.getInt("product_qty");
                if (pqty >= 1) {
                    s.executeUpdate("UPDATE productdb SET product_qty = " + (pqty - 1) + " WHERE product_name='" + name + "'");
                }
            }
           
            request.setAttribute("msg","<h1>Product is bought</h1>");
            request.getRequestDispatcher("View1").forward(request,response);    
           }
        catch(Exception e)
    	{
       	request.setAttribute("msg","<h1>Error occured</h1>");
        	request.getRequestDispatcher("View1").forward(request,response);
        	
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
