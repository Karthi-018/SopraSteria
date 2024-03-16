package edu.servletTraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    
    public ActionServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String result1=request.getParameter("adm");
		String result2=request.getParameter("cus");
		
	if(result1!=null)
	{
		HttpSession s=request.getSession();
		s.getAttribute("type");
		switch(result1)
		{
		case "create":
			response.sendRedirect("Create.jsp");
			break;
		case "search":
            RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
			rd.forward(request, response);
			break;
		case "view":
			RequestDispatcher rd1=request.getRequestDispatcher("View.jsp");
			rd1.forward(request, response);
			break;
		case "customerList":
			response.sendRedirect("CustomerList.jsp");
			break;
		case "LogOut":
			s.invalidate();
			response.sendRedirect("LogIn.jsp");
		}
	}
	else if(result2!=null)
	{
		    HttpSession session=request.getSession();
		    session.getAttribute("username");
			request.setAttribute("type", "customer");
			switch(result2)
			{
			case "cart":
				response.sendRedirect("Cart.jsp");
				break;
			case "search":
	            RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
				rd.forward(request, response);
				break;
			case "view":
				RequestDispatcher rd1=request.getRequestDispatcher("View.jsp");
				rd1.forward(request, response);
			case "wishList":
				response.sendRedirect("WishList.jsp");
				break;
			case "LogOut":
				session.invalidate();
				response.sendRedirect("LogIn.jsp");	
		}
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
