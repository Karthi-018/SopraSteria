package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreEdit
 */
@WebServlet("/PreEdit")
public class PreEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreEdit() {
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
		int id=Integer.parseInt(request.getParameter("edit"));
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ROOT");	
        PreparedStatement ps=c.prepareStatement("select * from pro where eid = ?");
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        request.setAttribute("eid",rs.getInt(1));
        request.setAttribute("name",rs.getString(2));
        request.setAttribute("descp",rs.getString(3));
        request.setAttribute("price",rs.getInt(4));
        request.setAttribute("quan",rs.getInt(5));
//        request.setAttribute("flag",true);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
        
//        else if(rs==null){
//        	out.println(0);
//        	request.setAttribute("msg","Product is Unavailable");
//        	request.getRequestDispatcher("/search.jsp").forward(request, response);
//        	
//        }
	}
	catch(Exception e)
	{
		out.println(e);
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
