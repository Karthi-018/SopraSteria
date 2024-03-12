package edu.training;

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

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String name=request.getParameter("search");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","ROOT");
        PreparedStatement s=c.prepareStatement("select * from pro where pname = ?");
        s.setString(1,name);
        ResultSet rs=s.executeQuery();
        request.setAttribute("resultSet",rs);
//        request.setAttribute("flag",true);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
        
//        else if(rs==null){
//        	out.println(0);
//        	request.setAttribute("msg","Product is Unavailable");
//        	request.getRequestDispatcher("/search.jsp").forward(request, response);
//        	
//        }
	}
	catch(Exception e)
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
