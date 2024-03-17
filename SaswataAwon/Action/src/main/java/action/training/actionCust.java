package action.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class actionCust
 */
@WebServlet("/actionCust")
public class actionCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public actionCust() {
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
			 case "Search": request.setAttribute("msg", ""); request.getRequestDispatcher("SearchCust.jsp").forward(request, response);break;
			 case "View": response.sendRedirect("viewCust");break;
			 case "Cart": response.sendRedirect("CartShow");break;
			 case "WishList":response.sendRedirect("wishlistshow");break;
			 case "LogOut": request.setAttribute("msg", ""); request.getRequestDispatcher("CustLogin.jsp").forward(request, response);break;
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
