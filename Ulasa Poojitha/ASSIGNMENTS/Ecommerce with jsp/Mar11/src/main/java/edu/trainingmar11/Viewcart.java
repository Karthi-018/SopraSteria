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
 * Servlet implementation class Viewcart
 */
@WebServlet("/Viewcart")
public class Viewcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String name=Custaccess.name;
		RequestDispatcher rd= request.getRequestDispatcher("Viewcart.jsp");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select p.pid, p.pname,p.pdesc,p.pprice,c.quant  from cart as c INNER JOIN Eprods as p where c.pid=p.pid and gname ='"+name+"'");         
            	request.setAttribute("resultSet",resultSet);
                rd.forward(request, response);
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
