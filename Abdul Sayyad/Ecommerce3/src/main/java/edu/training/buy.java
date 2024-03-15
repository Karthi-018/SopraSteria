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
 * Servlet implementation class buy
 */
@WebServlet("/buy")
public class buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid =Integer.parseInt(request.getParameter("pid"));
		int pquant = Integer.parseInt(request.getParameter("pquant"));
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select quantity from product where pid ="+pid);
            if(rs.next() && pquant <= rs.getInt(1)) {
                RequestDispatcher rd = request.getRequestDispatcher("/view2");

            	PreparedStatement ps = connection.prepareStatement("update product set quantity = ? where pid = ?");
            	ps.setInt(1,rs.getInt(1)-pquant);
            	ps.setInt(2, pid);
            	ps.executeUpdate();
            	request.setAttribute("msg", "<h2 style = 'color:green'>Thank you for purchasing<h2>");
                rd.forward(request, response);

            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("buy.jsp");

            	request.setAttribute("msg", "<h2 style = 'color:red'>Product or quantity Not Available<h2>");
            	rd.forward(request, response);
            }
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
