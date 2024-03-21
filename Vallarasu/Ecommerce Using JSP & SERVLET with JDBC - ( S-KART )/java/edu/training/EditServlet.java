package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
				Connection c = DbConnection.getConnection();
		        Statement statement = c.createStatement();   
		        int pid=Integer.parseInt(request.getParameter("edit"));
		        
		        ResultSet rs=statement.executeQuery("Select * from product where pid="+pid);
		        rs.next();
		       
		        RequestDispatcher rd=request.getRequestDispatcher("EditProductDetail.jsp");
		        request.setAttribute("pid",rs.getInt(1));
		        request.setAttribute("pname",rs.getString(2));
		        request.setAttribute("pcost",rs.getInt(3));
		        request.setAttribute("pquantity",rs.getInt(4));
		        rd.forward(request,response);
        } 
		catch (Exception e) 
		{
            System.out.println(e);
        }
	}
}
