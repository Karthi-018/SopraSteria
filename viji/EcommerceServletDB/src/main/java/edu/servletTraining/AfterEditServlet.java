package edu.servletTraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfterEditServlet
 */
@WebServlet("/AfterEditServlet")
public class AfterEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfterEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
			PreparedStatement ps=c.prepareStatement("update productData set price=? ,quant=? where id=? ");
			ps.setDouble(1,Double.parseDouble(request.getParameter("price")) );
 		    ps.setInt(2, Integer.parseInt(request.getParameter("quan")));
     		ps.setString(3, request.getParameter("id"));
 		    int rs=ps.executeUpdate();	    
		}
		catch(Exception e)
		{
			out.println(e);
		}
		//request.setAttribute(, CreateServlet.productList);
		request.setAttribute("type", "admin");
		RequestDispatcher rd=request.getRequestDispatcher("ViewServlet");
		
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
