package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class movewishlist
 */
@WebServlet("/movewishlist")
public class movewishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movewishlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uemail = ActionServlet.customerEmail;
		int pid =Integer.parseInt(request.getParameter("pid"));
    	RequestDispatcher rd = request.getRequestDispatcher("/viewwishlist");
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from cart where pid ="+pid+" and cusemail = "+"'"+ActionServlet.customerEmail+"'");
            statement.executeUpdate("delete from wishlist where pid ="+pid+" and cusemail = "+"'"+ActionServlet.customerEmail+"'");
        	PreparedStatement ps = connection.prepareStatement("insert into wishlist values(?,?)");
        	ps.setString(1, uemail);
        	ps.setInt(2, pid);
        	ps.executeUpdate();
            }
		catch(Exception e) {
			System.out.println(e);
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
