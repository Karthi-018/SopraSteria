package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class buyall
 */
@WebServlet("/buyall")
public class buyall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	RequestDispatcher rd = request.getRequestDispatcher("/viewCart");

		try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select quantity,pid from cart where cusemail = '"+ActionServlet.customerEmail+"'");
            while(rs.next()) {
            	PreparedStatement ps = connection.prepareStatement("update product set quantity = quantity - ? where pid = ?");
            	ps.setInt(1, rs.getInt(1));
            	ps.setInt(2, rs.getInt(2));
            	ps.executeUpdate();
            }
            statement.executeUpdate("delete from cart where cusemail = '" + ActionServlet.customerEmail+"'");
		}catch(Exception e) {
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
