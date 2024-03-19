package edu.training.mar11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bought
 */
@WebServlet("/Bought")
public class Bought extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bought() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int quant=Integer.parseInt(request.getParameter("amount"));
	     int pid=Integer.parseInt(request.getParameter("buy"));
	     PrintWriter out=response.getWriter();
			RequestDispatcher rd= request.getRequestDispatcher("Buy");
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Root");
	            Statement statement=connection.createStatement();
	            ResultSet resultSet=statement.executeQuery("select * from Eprods where pid ='"+pid+"'");
//	            request.setAttribute("resultSet",resultSet);
//	            rd.forward(request, response);
	            resultSet.next();
	           // response.sendRedirect("Csearch.jsp");
	            int available=resultSet.getInt(5);
	            if(available >= quant) {
	            	 PreparedStatement ps = connection.prepareStatement("update Eprods set pqty=pqty - "+quant+" where pid ="+pid);
	            	 ps.execute();
	            	 //response.sendRedirect("Csearch.jsp");
	            	 rd.forward(request, response);
	            }
	            else if(available < quant){
	            	request.setAttribute("resultSet",resultSet);
               	    request.setAttribute("sorry", "out of stock!!");
               	  //  response.sendRedirect("Csearch.jsp");
	                rd.forward(request, response);
	            }
	}
			catch(ClassNotFoundException e)
		    {
		        out.println(e);
		    }catch (SQLException e){
	            out.println(e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
