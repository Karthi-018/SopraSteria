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
 * Servlet implementation class AddToWishlist
 */
@WebServlet("/AddToWishlist")
public class AddToWishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToWishlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("wish"));
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
            Statement s = connection.createStatement();
            ResultSet result=s.executeQuery("Select * from productdb where product_id="+id+"");
            if(result.next()) {
            String pname=result.getString(2);
            int pprice=result.getInt(3);
            ResultSet r = s.executeQuery("SELECT * FROM addtowish WHERE product_name ='" + pname+"'");
            if(!r.next())
            {
            s.executeUpdate("INSERT INTO addtowish VALUES ('" + pname + "'," + pprice + " )");
            }
            ResultSet rs=s.executeQuery("Select * from addtowish");
            request.setAttribute("rs",rs);
            request.setAttribute("msg","<h1>Product is added to wishlist</h1>");
            request.getRequestDispatcher("mywish.jsp").forward(request,response);
            }
          
            
        }
        catch(Exception e)
    	{
        	request.setAttribute("msg","<h1>Error occured</h1>");
        	request.getRequestDispatcher("mywish.jsp").forward(request,response);
        	
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
