package edu.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArithmeticServlet
 */

public class ArithmeticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArithmeticServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1=Integer.parseInt(request.getParameter("n1"));
		int n2=Integer.parseInt(request.getParameter("n2"));
		String operator=request.getParameter("calc");
		int result=0;
		PrintWriter out=response.getWriter();
		switch(operator)
		{
			case "Add": result=n1+n2; break;
			case "Sub": result=n1-n2; break;
			case "Mul": result=n1*n2; break;
			case "Div": result=n1/n2; break;
			case  "Mod": result=n1%n2; break;
		}
		request.setAttribute("result",result);
		request.setAttribute("operator",operator);	
		RequestDispatcher rd=request.getRequestDispatcher("/SServlet");
		rd.forward(request, response);
		
		
	}

}
