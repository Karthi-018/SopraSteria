package edu.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String customerEmail;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choice = request.getParameter("choice");
		String choice1 = request.getParameter("choice1");
        RequestDispatcher rd = request.getRequestDispatcher("/view");
        RequestDispatcher rd1 = request.getRequestDispatcher("/view2");
        RequestDispatcher rd2 = request.getRequestDispatcher("/viewCart");
        RequestDispatcher rd3 = request.getRequestDispatcher("/viewwishlist");
        RequestDispatcher rd4 = request.getRequestDispatcher("/viewaccess");

        choice = choice==null?"0":choice;
        choice1 = choice1==null?"0":choice1;
		switch(choice) {
		case "Create":response.sendRedirect("create.jsp");break;
		case "Search":response.sendRedirect("search.jsp");break;
		case "View":rd.forward(request, response);break;
		case "Customer List" :rd4.forward(request, response);break;
		case "Log Out":response.sendRedirect("identity.jsp");break;
		}
		switch(choice1) {
		case "search":response.sendRedirect("Search3.jsp");break;
		case "view":rd1.forward(request, response);break;
		case "view Cart":rd2.forward(request, response);break;
		case "view WishList":rd3.forward(request, response);break;

		case "log out":response.sendRedirect("identity.jsp");break;
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
