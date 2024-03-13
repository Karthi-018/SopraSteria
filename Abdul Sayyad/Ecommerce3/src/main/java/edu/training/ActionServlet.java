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
        choice = choice==null?"0":choice;
        choice1 = choice1==null?"0":choice1;

		switch(choice) {
		case "create":response.sendRedirect("create.jsp");break;
		case "search":response.sendRedirect("search.jsp");break;
		case "view":rd.forward(request, response);break;
		case "log out":response.sendRedirect("identity.jsp");break;
		}
		switch(choice1) {
		case "search":response.sendRedirect("Search3.jsp");break;
		case "view":rd1.forward(request, response);break;
		case "buy":response.sendRedirect("buy.jsp");break;
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
