package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/createservlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try
		{
			int pid=Integer.parseInt(request.getParameter("pid"));
			String pname=request.getParameter("pname");
			String pdesc=request.getParameter("pdesc");
			int pprice=Integer.parseInt(request.getParameter("pprice"));;
			int pquantity=Integer.parseInt(request.getParameter("pquantity"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / servlet","root","root");
			PreparedStatement ps=con.prepareStatement("insert into producttable values(?,?,?,?,?)");
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setInt(4, pprice);
			ps.setInt(5, pquantity);
			int result=ps.executeUpdate();
			
			if(result>0)
			{
				request.setAttribute("msg", "<h1 style='color:green;text-align:center'>Product "+pname+" added </h1>");
				request.getRequestDispatcher("CreateProduct.jsp").forward(request, response);
			}
			
		}
		catch(NumberFormatException e)
		{
			request.setAttribute("msg", "<h1 style='color:red;text-align:center>Error Occured in adding the product</h1>");
			request.getRequestDispatcher("CreateProduct.jsp").forward(request, response);
//			System.out.println(e);
		}
		catch(Exception e)
		{
			request.setAttribute("msg", "<h1 style='color:red;text-align:center>Error Occured in adding the product</h1>");
			request.getRequestDispatcher("CreateProduct.jsp").forward(request, response);
//			System.out.println(e);
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
