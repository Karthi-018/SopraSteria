package edu.training;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Search
 */
@WebServlet("/Search3")
public class Search3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pname = request.getParameter("pname");
        RequestDispatcher rd = request.getRequestDispatcher("Search3.jsp");

		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from product where pname ="+"'"+pname+"'");
            ArrayList<Integer> pids = new ArrayList<Integer>();
            ArrayList<String> pnames = new ArrayList<String>();
            ArrayList<String> pdescs = new ArrayList<String>();
            ArrayList<Integer> pprices = new ArrayList<Integer>();
            while(rs.next()) {
            	pids.add(rs.getInt(1));
            	pnames.add(rs.getString(2));
            	pdescs.add(rs.getString(3));
            	pprices.add(rs.getInt(5));
            }
            request.setAttribute("pids", pids);
            request.setAttribute("pnames", pnames);
            request.setAttribute("pdescs", pdescs);
            request.setAttribute("pprices", pprices);
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
