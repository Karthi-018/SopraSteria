package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create
 */
@WebServlet("/create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
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
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ROOT");
        PreparedStatement s=c.prepareStatement("insert into pro values(?,?,?,?,?)");
        s.setLong(1,Integer.parseInt(request.getParameter("id")));
        s.setString(2,request.getParameter("name"));
        s.setString(3,request.getParameter("descp"));
        s.setLong(4,Integer.parseInt(request.getParameter("price")));
        s.setLong(5,Integer.parseInt(request.getParameter("quan")));;
        s.executeUpdate();
        
        response.sendRedirect("create.jsp");
		}
		catch(Exception e) {out.println(e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
