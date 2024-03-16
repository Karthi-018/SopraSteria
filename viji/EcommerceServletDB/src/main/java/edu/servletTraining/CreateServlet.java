package edu.servletTraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<ProductPojo> productList=new ArrayList<>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECommerce","root","root");
			PreparedStatement ps1=c.prepareStatement("select *from productData");
			ResultSet rs=ps1.executeQuery();
			int flag=0;
			while(rs.next())
			{
				if(Integer.parseInt(request.getParameter("id"))==rs.getInt(1))
				{
					flag=1;
				}
			}
			if(flag==0)
			{
			PreparedStatement ps=c.prepareStatement("insert into productData values(?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(request.getParameter("id")));
			ps.setString(2,request.getParameter("name"));
			ps.setString(3,request.getParameter("descp"));
			ps.setDouble(4, Double.parseDouble(request.getParameter("price")));
			ps.setInt(5, Integer.parseInt(request.getParameter("quan")));
			ps.executeUpdate();
//			ProductPojo p=new ProductPojo(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),request.getParameter("descp"),Double.parseDouble(request.getParameter("price")),Integer.parseInt(request.getParameter("quan")));
//			productList.add(p);
			response.sendRedirect("Create.jsp");
			}
			else {
				out.println("<html><body><h2> Product already exist! Try to add new product</h2></body></html>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
