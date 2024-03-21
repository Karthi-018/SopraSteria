package edu.learning;

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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String submit=request.getParameter("submit");
		if(submit.equals("edit"))
		{
		int pid=Integer.parseInt(request.getParameter("pid"));
		int price=Integer.parseInt(request.getParameter("pprice"));
		int qty=Integer.parseInt(request.getParameter("pqty"));
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
		    Statement s = connection.createStatement();
		    int result = s.executeUpdate("UPDATE productdb SET product_price = " + price + ", product_qty = " + qty +" where product_id ="+pid);
		    if (result > 0) {
		        request.setAttribute("msg", "<h1>Product is updated</h1>");
		        request.getRequestDispatcher("View").forward(request, response);
		    }
		} catch (Exception e) {
		    request.setAttribute("msg", "<h1>Error occurred</h1>");
		    request.getRequestDispatcher("View").forward(request, response);
		}
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
