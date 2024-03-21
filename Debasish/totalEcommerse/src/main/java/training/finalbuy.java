package training;

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
 * Servlet implementation class finalbuy
 */
@WebServlet("/finalbuy")
public class finalbuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finalbuy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     int quant=Integer.parseInt(request.getParameter("amt"));
	     int pid=Integer.parseInt(request.getParameter("buy"));
	     PrintWriter out=response.getWriter();
			RequestDispatcher rd= request.getRequestDispatcher("buy");
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
	            Statement statement=connection.createStatement();
	            ResultSet resultSet=statement.executeQuery("select * from Eprods where pid ='"+pid+"'");
	            resultSet.next();
	            int avail=resultSet.getInt(4);
	            if(avail >= quant) {
	            	 PreparedStatement ps = connection.prepareStatement("update Eprods set quantity=quantity - "+quant+" where pid ="+pid);
	            	 ps.execute();
	            	 response.sendRedirect("view.jsp");
	            }
	            else if(avail < quant){
	            	request.setAttribute("resultSet",resultSet);
//	            	request.setAttribute("err", "out of stuck!!");
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
