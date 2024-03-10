package sopra.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		PrintWriter out = response.getWriter();
		List<String> lst = new ArrayList<String>();
		String choice = request.getParameter("cv");
		out.println("<html><head><title>checksite</title><head><body>");
		if(choice.equals("Add Product")) {
			out.print("<h3>Enter the Product Name</h3><br>");
			out.print("<h3><input type = 'text' name = 'addProduct'/></h3><br>");
			out.print("<h4><input type = 'submit' name = 'addSubmit' value = 'ADD'/></h4><br>");
			String ap = request.getParameter("addProduct");
			lst.add(ap);
			out.print("<h3><a href = 'AdminHome.html'>Return Back to the Page</a></h3><br>");
			
		}
		else if(choice.equals("Edit Product")) {
			out.print("<h3>Enter the Product Name to edit :</h3><br>");
			out.print("<h3><input type = 'text' name = 'editProduct'/></h3><br>");
			out.print("<h3>Enter the new name :</h3><br>");
			out.print("<h3><input type = 'text' name = 'afteredit'/></h3><br>");
			out.print("<h4><input type = 'submit' name = 'editSubmit' value = 'EDIT'/></h4><br>");
			String ep = request.getParameter("editProduct");
			String eepp = request.getParameter("afteredit");
			for(String i: lst)
			{
				if(i.equals(ep))
				{
					i = eepp;
				}
			}
			lst.add(ep);
			out.print("<h3><a href = 'AdminHome.html'>Return Back to the Page</a></h3><br>");
		}
		else if(choice.equals("Show Products")) {
			out.print("<h3>Displaying Products:</h3><br>");
			for(String i: lst)
			{
				out.println("<h3>"+ i +"<br>");
			}
			out.print("<h3><a href = 'AdminHome.html'>Return Back to the Page</a></h3><br>");
			
		}
		out.println("</body></html>");
		
	}

}
