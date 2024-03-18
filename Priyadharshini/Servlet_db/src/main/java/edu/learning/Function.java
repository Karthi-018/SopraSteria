package edu.learning;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Function
 */
@WebServlet("/Function")
public class Function extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Function() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choice=request.getParameter("option");
		if(choice.equals("View"))
		{
			  request.getRequestDispatcher("View1").forward(request,response);
		}
		else if(choice.equals("Search"))
		{
			request.getRequestDispatcher("search1.jsp").forward(request,response);
		}
		else if(choice.equals("Mycart"))
		{
			request.getRequestDispatcher("Mycart").forward(request,response);
		}
		else
		{
			request.getRequestDispatcher("Mywishlist").forward(request,response);
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
