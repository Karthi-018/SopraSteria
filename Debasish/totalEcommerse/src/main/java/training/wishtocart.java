package training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class wishtocart
 */
@WebServlet("/wishtocart")
public class wishtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wishtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		PrintWriter out=response.getWriter();
		String email=userLogin.email;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
	        Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from cart where email ='"+email+"'"+" and pid= "+pid);
            	
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
            
            PreparedStatement ps = connection.prepareStatement("delete from wishlist where pid ="+pid+" and email= '"+email+"'");
	        ps.executeUpdate();
	        RequestDispatcher rd= request.getRequestDispatcher("wishlist");
	        rd.forward(request, response);
}
		catch(ClassNotFoundException e)
	    {
	        out.println(e);
	    }catch (SQLException e){
            out.println(e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
