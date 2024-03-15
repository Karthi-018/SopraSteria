package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewaccess
 */
@WebServlet("/viewaccess")
public class viewaccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewaccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();

		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");        
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement statement = connection.createStatement();
		    ResultSet rs = statement.executeQuery("select email from customer1 where access = 'deny'");
			RequestDispatcher rd = request.getRequestDispatcher("viewaccess.jsp");
		   while(rs.next()) {
			   list.add(rs.getString(1));
		   }
		    ResultSet rs1 = statement.executeQuery("select email from customer1 where access = 'accept'");
		    while(rs1.next()) {
				   list1.add(rs1.getString(1));
			   }
		   request.setAttribute("emaillist", list);
		   request.setAttribute("emaillist1", list1);

		   rd.forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
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
