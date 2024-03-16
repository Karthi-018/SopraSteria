package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addcart
 */
@WebServlet("/addcart")
public class addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uemail = ActionServlet.customerEmail;
		int pid =Integer.parseInt(request.getParameter("pid"));
		int pquant = 1;
		response.getWriter().println(pid);
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select quantity from product where pid = "+pid);
        	RequestDispatcher rd = request.getRequestDispatcher("/viewCart");

            if(rs.next() && pquant <= rs.getInt(1)) {
                ResultSet rs1 = statement.executeQuery("select quantity from cart where pid = "+pid+" and cusemail = '"+ActionServlet.customerEmail+"'");
                int initquant = 0;
                if(rs1.next()) {
                initquant  = rs1.getInt(1);
    
            	PreparedStatement ps = connection.prepareStatement("update cart set quantity = quantity + ? where cusemail = ? and pid = ?");
            	ps.setInt(1,1);
            	ps.setString(2,uemail);
            	ps.setInt(3,pid);
            	ps.executeUpdate();
                }else {
                	PreparedStatement ps = connection.prepareStatement("insert into cart values(?,?,?)");
                	ps.setString(1,uemail);
                	ps.setInt(2,pid );
                	ps.setInt(3,1);
                	ps.executeUpdate();
                }
               rd.forward(request, response);

            }
            else {
            	request.setAttribute("msg", "<h2 style = 'color:red'>Product or quantity Not Available<h2>");
                rd.forward(request, response);
            }
		}catch(Exception e) {
			System.out.println(e);
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
