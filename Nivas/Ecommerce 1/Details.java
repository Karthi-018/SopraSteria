package ecom.pro;
import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
		List<String> prod= new ArrayList<String>(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter PW = response.getWriter();
		String choose = request.getParameter("Epro");
		PW.println("<html><head><title>checksite</title><head><body>");
		switch(choose){
		 case "products":
			 PW.print("<h3>Enter the Product Name</h3><br>");
			 PW.print("<h3><input type = 'text' name = 'addProduct'/></h3><br>");
			 PW.print("<h4><input type = 'submit' name = 'addSubmit' value = 'ADD'/></h4><br>");
		String addp = request.getParameter("addProduct");
			prod.add(addp);
			PW.print("<h4><a href = 'Product.java'>Back</a></h4><br>");
		 case "product1": 
			 PW.print("<h3>Enter the Product Name to edit :</h3><br>");
			 PW.print("<h3><input type = 'text' name = 'editProduct'/></h3><br>");
			 PW.print("<h3>Enter the new name :</h3><br>");
			 PW.print("<h3><input type = 'text' name = 'afteredit'/></h3><br>");
			 PW.print("<h4><input type = 'submit' name = 'editSubmit' value = 'EDIT'/></h4><br>");
			String editp = request.getParameter("editProduct");
			String editaft = request.getParameter("afteredit");
			PW.print("hiiiiiiiiiiiiiii");
			for(String i: prod){if(i.equals(editp)){i = editaft;}}
			prod.add(editp);
			PW.print("<h3><a href = 'index2.jsp'>Back</a></h3><br>");
	    case "product2":
	    	PW.print("<h3>Displaying Products:</h3><br>");
			for(String i: prod){PW.println("<h3>"+ i +"<br>");}
			PW.print("<h3><a href ='index2.jsp'>Back</a></h3><br>");}PW.println("</body></html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
