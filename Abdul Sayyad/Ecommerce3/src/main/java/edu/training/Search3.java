package edu.training;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Search
 */
@WebServlet("/Search3")
public class Search3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));
        RequestDispatcher rd = request.getRequestDispatcher("Search3.jsp");

		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from product where pid ="+pid);
            if(!rs.next()) {
            	request.setAttribute("msg", "<h2 style = 'color:red'>Failed<h2>");
            	rd.forward(request, response);
            }
            else {
            	request.setAttribute("msg", "<h2 style = 'color:green'>Succeed<h2>");
            request.setAttribute("pid", rs.getInt(1));
            request.setAttribute("pname", rs.getString(2));
            request.setAttribute("pdesc", rs.getString(3));
            request.setAttribute("pquant", rs.getInt(4));
            request.setAttribute("pprice", rs.getInt(5));
            rd.forward(request, response);
            }
		}catch(Exception e) {
			System.out.println(e);
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
