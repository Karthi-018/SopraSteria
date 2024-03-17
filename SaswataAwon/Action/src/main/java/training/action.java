package training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class action
 */
@WebServlet("/action")
public class action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
		 String ch= request.getParameter("choice");
		 switch(ch) {
		 case "create": request.setAttribute("msg", ""); request.getRequestDispatcher("Create.jsp").forward(request, response);break;
		 case "search": request.setAttribute("msg", ""); request.getRequestDispatcher("Search.jsp").forward(request, response);break;
		 case "list": response.sendRedirect("ViewServlet");break;
		 case "LogOut": request.setAttribute("msg", "Logged Out Successfully!!!"); request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);break;
		 }
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
