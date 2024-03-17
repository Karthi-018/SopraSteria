package action.training;

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
 * Servlet implementation class CustReg
 */
@WebServlet("/CustReg")
public class CustReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String email=request.getParameter("email");
//		String pass=request.getParameter("password");
//		String fname=request.getParameter("fname");
//		String lname=request.getParameter("lname");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
		
		PreparedStatement ps = connection.prepareStatement("insert into cust values(?,?,?,?);");
        ps.setString(1,request.getParameter("email"));
        ps.setString(4,request.getParameter("password"));
        ps.setString(2,request.getParameter("fname"));
        ps.setString(3,request.getParameter("lname"));
        
        ps.executeUpdate();
        
//        request.setAttribute("msg", "Now, please try to login");
        request.getRequestDispatcher("CustLogin.jsp").forward(request, response);
        
		}
		
		catch(Exception e) {
			request.setAttribute("msg", "Account already Exists!!!");
        	request.getRequestDispatcher("LogReg.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
