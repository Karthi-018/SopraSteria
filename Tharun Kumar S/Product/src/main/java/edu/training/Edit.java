package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		int quan = Integer.parseInt(request.getParameter("quan"));
		int price = Integer.parseInt(request.getParameter("price"));
 
RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
if(quan<0 || price<0) {
	request.setAttribute("msg", "Failed");
	rd.forward(request, response);
}
else {
		try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ROOT");
PreparedStatement ps = connection.prepareStatement("update pro set quantity=? , price = ? where eid =?");
ps.setInt(1, quan);
ps.setInt(2, price);
ps.setInt(3, id);

int rs = ps.executeUpdate();
response.sendRedirect("view");
		}
//if (rs>0) {
//	request.setAttribute("msg", "Change Updated");
//	PreparedStatement ps1 = connection.prepareStatement("select * from pro where eid = ?");
//	ps1.setInt(1,id);
//	ResultSet rs1 = ps1.executeQuery();
//	rs1.next();
//	request.setAttribute("id", rs1.getInt(1));
//	request.setAttribute("name", rs1.getString(2));
//	request.setAttribute("descp", rs1.getString(3));
//	request.setAttribute("quan", rs1.getInt(4));
//	request.setAttribute("price", rs1.getInt(5));
//	rd.forward(request, response);
//	
//}else {
//	request.setAttribute("msg", "failed");
//	rd.forward(request, response);
//}
		catch(Exception e) {
			System.out.println(e);
		}
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
