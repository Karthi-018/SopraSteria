package training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userActionServlet
 */
@WebServlet("/userActionServlet")
public class userActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String copt= request.getParameter("option");
		RequestDispatcher rd= request.getRequestDispatcher("cart");
		
		 if(copt.equals("view")) {
			 response.sendRedirect("view");
		 }
		 else if(copt.equals("search")) {
			 response.sendRedirect("csearch.jsp");
		 }
		 else if(copt.equals("cart")) {
			 response.sendRedirect("cartview");
		 }
		 else if(copt.equals("wishlist")) {
			 response.sendRedirect("wishlist");
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
