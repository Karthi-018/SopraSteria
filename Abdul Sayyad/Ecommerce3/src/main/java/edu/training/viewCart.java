package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class viewCart
 */
@WebServlet("/viewCart")
public class viewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int cost = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from product where pid in "
            		+ "(select pid from cart where cusemail = "+"'"+ ActionServlet.customerEmail+"'" +")");
//            ResultSet rs1 = statement.executeQuery("select quantity from cart");
            ArrayList<Integer> pids = new ArrayList<Integer>();
            ArrayList<String> pnames = new ArrayList<String>();
            ArrayList<String> pdescs = new ArrayList<String>();
            ArrayList<Integer> pquants = new ArrayList<Integer>();
            ArrayList<Integer> pprices = new ArrayList<Integer>();
           // ResultSet rs1 = statement.executeQuery("select quantity from cart where cusemail ="+"'"+ActionServlet.customerEmail+"'");
            while(rs.next()) {
            	pids.add(rs.getInt(1));
            	pnames.add(rs.getString(2));
            	pdescs.add(rs.getString(3));
            	//pquants.add(rs1.getInt(1));
            	pprices.add(rs.getInt(5));
            	
            }
            ResultSet rs1 = statement.executeQuery("select quantity from cart where cusemail ="+"'"+ActionServlet.customerEmail+"'");
           int i = 0;
            while(rs1.next()) {
            	pquants.add(rs1.getInt(1));
            	cost+=(rs1.getInt(1)*pprices.get(i));
            	i++;
            	
            }
            RequestDispatcher rd = request.getRequestDispatcher("viewcart.jsp");
            request.setAttribute("pids", pids);
            request.setAttribute("pnames", pnames);
            request.setAttribute("pdescs", pdescs);
            request.setAttribute("pquants", pquants);
            request.setAttribute("pprices", pprices);
            request.setAttribute("totalcost", cost);
            rd.forward(request, response);
		}catch(Exception e) {
			response.getWriter().println(e);
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
