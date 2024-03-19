package edu.trainingmar11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Custtable
 */
@WebServlet("/Custtable")
public class Custtable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Custtable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String cname=request.getParameter("cname");
		String cemail=request.getParameter("cemail");
		String cdob=request.getParameter("cdob");
		String cpwd=request.getParameter("cpwd");
		PrintWriter out=response.getWriter();
		try
	    {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Root");
	        PreparedStatement ps1=connection.prepareStatement("select * from custtable where cemail=?");
	        ps1.setString(1,cemail);
	        ResultSet rs=ps1.executeQuery();
	        if(rs.next()) {
//	        	out.println("User already exist");
	        	request.setAttribute("msg", "User already exist");
	        	request.getRequestDispatcher("Custreg.jsp").forward(request, response);
	        	
	        }
	        else {
	        PreparedStatement ps = connection.prepareStatement("insert into custtable(cname, cemail , cdob , cpwd ,status) values(?,?,?,?,?)");	       
	        ps.setString(1,cname);
	        ps.setString(2, cemail);
	        ps.setString(3, cdob);
	        ps.setString(4, cpwd);
	        ps.setString(5, "new");
	        int res=ps.executeUpdate();
	        if(res>0) {
	        response.sendRedirect("Customer.jsp");
	        }else {response.sendRedirect("Custreg.jsp");}
	    }}
	    catch(ClassNotFoundException e)
	    {
	        out.println(e);
	    }
	    catch(SQLException e)
	    {
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
