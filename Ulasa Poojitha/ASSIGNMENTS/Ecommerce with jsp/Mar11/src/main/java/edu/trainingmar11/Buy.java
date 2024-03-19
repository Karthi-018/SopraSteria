package edu.trainingmar11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		PrintWriter out=response.getWriter();
		//out.println("Bought");
		int pid=Integer.parseInt(request.getParameter("buy"));
		PrintWriter out=response.getWriter();
		RequestDispatcher rd= request.getRequestDispatcher("Buy.jsp");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from Eprods where pid ='"+pid+"'");
            int qty=0;
            String pname =null;
            String desc = null;
            int price =0;
            int prid =0;
            if(resultSet.next())
            {
            	prid = resultSet.getInt(1);
            	pname = resultSet.getString(2);
            	desc = resultSet.getString(3);
            	price = resultSet.getInt(4);
            	qty = resultSet.getInt(5);
            	
            }
            if(qty>0)
            {
            	request.setAttribute("prid",prid);
            	request.setAttribute("pname",pname);
            	request.setAttribute("desc",desc);
            	request.setAttribute("price",price);
            	rd.forward(request, response);
            }
            else
            {
            	request.setAttribute("prid",prid);
            	request.setAttribute("pname",pname);
            	request.setAttribute("desc",desc);
            	request.setAttribute("price",price);
            	request.setAttribute("Sorry", "Product out of stock!!");
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
