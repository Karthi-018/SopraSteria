package sopra.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerActionServlet
 */
@WebServlet("/CustomerActionservlet")
public class CustomerActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choice = request.getParameter("choice");
        
		switch(choice)
		{
		case "Search":
			response.sendRedirect("customerSearchProduct.jsp");
			break;
		case "View":
			RequestDispatcher rd = request.getRequestDispatcher("/CustomerViewServlet");
			rd.forward(request, response);
			break;
		case "Cart":
			RequestDispatcher rd1 = request.getRequestDispatcher("/DisplayCartServlet");
			rd1.forward(request, response);
			break;
		case "Wishlist":
			RequestDispatcher rd2 = request.getRequestDispatcher("/DisplayWishlistServlet");
			rd2.forward(request, response);
			break;
		case "Logout":
			response.sendRedirect("index.jsp");
			break;
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
