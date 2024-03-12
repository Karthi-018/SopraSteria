package edu.training;

import java.io.IOException;
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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		int temp=Integer.parseInt(request.getParameter("pid"));
//		String button=request.getParameter("Edit");
//		if(button.equals("Edit"))
//		{
//			response.sendRedirect("edit.jsp");
//		}
//		else
//		{
//			
//		}
		
		try
		{
			int pid=Integer.parseInt(request.getParameter("pid"));
//			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / servlet","root","root");
			PreparedStatement ps=con.prepareStatement("select * from producttable where pid=?");
			
			
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			request.setAttribute("pid", pid);
			request.setAttribute("pname", rs.getString(2));
			request.setAttribute("pdesc", rs.getString(3));
			request.setAttribute("pprice", rs.getInt(4));
			request.setAttribute("pquantity", rs.getInt(5));
			
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
			
		}
		catch(Exception e)
		{
			
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
