package ecom.pro;



import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String pdesc = request.getParameter("pdesc");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		int pquant = Integer.parseInt(request.getParameter("pquant"));
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root");
			
			PreparedStatement preparedStatement = c.prepareStatement("insert into product(pid, pname, pdesc, price, quant) values(?,?,?,?,?)");
			preparedStatement.setInt(1,pid);
			preparedStatement.setString(2,pname);
			preparedStatement.setString(3,pdesc);
			preparedStatement.setInt(4,pprice);
			preparedStatement.setInt(5,pquant);
			int result = preparedStatement.executeUpdate();
			
			if(result > 0) {

				request.setAttribute("message", "<h3>Product " + pname + " created successfully</h3>");
				request.getRequestDispatcher("create.jsp").forward(request, response);
				}
			c.close();

			}
			catch(Exception e){out.println(e);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
