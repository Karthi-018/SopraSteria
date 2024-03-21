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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		String descript=request.getParameter("pdesc");
		int pprice=Integer.parseInt(request.getParameter("pprice"));
		int pquantity=Integer.parseInt(request.getParameter("pqty"));
		//Products pro=new Products(pid,pname,descript,prodprice,pquantity);
		//String copt=request.getParameter("option");
		PrintWriter out=response.getWriter();
	
	try
    {
    Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
        PreparedStatement ps = connection.prepareStatement("insert into Eprods values(?,?,?,?,?)");
        ps.setInt(1, pid);
        ps.setString(2,pname);
        ps.setString(3, descript);
        ps.setInt(4, pprice);
        ps.setInt(5, pquantity);
        int res=ps.executeUpdate();
        if(res>0) {
        response.sendRedirect("Createproduct.jsp");
        }
        else {
        	response.sendRedirect("Index.jsp");
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
