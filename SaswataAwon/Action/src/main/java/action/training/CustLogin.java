package action.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustLogin
 */
@WebServlet("/CustLogin")
public class CustLogin extends HttpServlet {
	
	static String email;
	
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		CustLogin.email = email;
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost: 3306/demo","root","Sanjukta@12");
		email=request.getParameter("email");
		String pass=request.getParameter("password");
		
		Statement statement= (Statement) connection.createStatement();
		
		
		ResultSet rs= statement.executeQuery("Select * from cust where email='"+email+"' AND password='"+pass+"';");
        if(rs.next()){
        	request.getRequestDispatcher("CustMain.jsp").forward(request, response);
        }
        
        else
        {	
        	request.setAttribute("msg", "Email or Password input mismatched!!!");
        	request.getRequestDispatcher("LogReg.jsp").forward(request, response);
        	
        }

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
