package training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class finalUpdate
 */
@WebServlet("/finalUpdate")
public class finalUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finalUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("pid"));
		int pprice=Integer.parseInt(request.getParameter("pprice"));
		int pquantity=Integer.parseInt(request.getParameter("pqty"));
		
		PrintWriter out=response.getWriter();
		
		try
	    {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
	        PreparedStatement ps = connection.prepareStatement("update Eprods set quantity="+ pquantity+", price= "+pprice +" where pid ="+pid);
	        int res=ps.executeUpdate();
	        if(res>0) {
	        response.sendRedirect("List	");
	        }
	        else {
	        	response.sendRedirect("Editsearch.jsp");
	        	}
	    }
	    catch(ClassNotFoundException e)
	    {
	        out.println(e);
	    }
	    catch(SQLException e)
	    {
	    	
	        out.println(e);
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
