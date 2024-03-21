package training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("cart"));
		String email=userLogin.email;
		
		PrintWriter out=response.getWriter();
		
		try
	    {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
	        Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from cart where email ='"+email+"'"+" and pid= "+pid);
            
            Statement st=connection.createStatement();
            ResultSet re=st.executeQuery("select * from Eprods where pid ='"+pid+"'");
            re.next();
            if(re.getInt(4)>0) 
            {
            	
            if(!resultSet.next()){
            	 PreparedStatement ps = connection.prepareStatement("insert into cart values (?,?,?);");
            	 ps.setString(1, email);
            	 ps.setInt(2, pid);
            	 ps.setInt(3, 1);
            	 ps.execute();           
            	 }
	       
            else {
            	PreparedStatement ps1 = connection.prepareStatement("update cart set quant=quant+1 where email ='"+email+"' and pid= "+pid+";");
            	ps1.execute();
            }
          }
            response.sendRedirect("view");
            
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
