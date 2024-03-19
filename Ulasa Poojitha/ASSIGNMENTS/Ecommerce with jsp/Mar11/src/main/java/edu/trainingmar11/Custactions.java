package edu.trainingmar11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Custactions
 */
@WebServlet("/Custactions")
public class Custactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Custactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String opt=request.getParameter("option");
		PrintWriter out=response.getWriter();
		if(opt.equals("Search")) {
			response.sendRedirect("Csearch.jsp");
		} else if(opt.equals("Home"))
		 {
			 response.sendRedirect("Index.jsp");
		 }
		else if(opt.equals("Wishlist")){
			response.sendRedirect("Wish");
		}else if(opt.equals("Cart")) {
			response.sendRedirect("Viewcart");
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
