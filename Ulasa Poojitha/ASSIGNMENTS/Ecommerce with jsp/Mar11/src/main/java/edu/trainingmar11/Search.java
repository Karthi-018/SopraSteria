package edu.trainingmar11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int pid=Integer.parseInt(request.getParameter("pid"));
		PrintWriter out=response.getWriter();
		RequestDispatcher rd= request.getRequestDispatcher("Search.jsp");
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Root");
			//PreparedStatement ps = connection.prepareStatement("select*from Eprods where pid="+pid+"");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from Eprods where pid ='"+pid+"'");
            request.setAttribute("resultSet",resultSet);
            rd.forward(request, response);
//            while(resultSet.next()){
//                out.println("<html><table border =\"1px\">"
//                		+ "<thead><tr>\r\n"
//        				+ " <th>Product Id</th>\r\n"
//        				+ " <th>Product Name</th>\r\n"
//        				+ " <th>Product Description</th>\r\n"
//        				+ " <th>Product Price</th>\r\n"
//        				+ " <th>Quantity</th>\r\n"
//        				+ "</tr> "
//        				+"</thead>"
//        				+"<tbody>");
//                out.println("<tr>\r\n"
//						+ " <td>"+resultSet.getInt(1)+"</td>\r\n"
//						+ " <td>"+resultSet.getString(2)+"</td>\r\n"
//						+ " <td>"+resultSet.getString(3)+"</td>\r\n"
//						+ " <td>"+resultSet.getInt(4)+"</td>\r\n"
//						+ " <td>"+resultSet.getInt(5)+"</td>\r\n"				
//						+ "</tr>");
//
//			out.println("</tbody></table>");
//                //out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getInt(4)+" "+resultSet.getInt(5));
//            
//            }  
            
        }
		catch(ClassNotFoundException e)
	    {
	        out.println(e);
	    }catch (SQLException e){
            out.println(e);}
        
//		RequestDispatcher rd= request.getRequestDispatcher("Search.jsp");
		
        
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
