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
@WebServlet("/movecart")
public class movecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movecart() {
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
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select quantity from product where pid = "+pid);
            if(rs.next() && pquant <= rs.getInt(1)) {
                ResultSet rs1 = statement.executeQuery("select quantity from cart where pid = "+pid+" and cusemail = '"+ActionServlet.customerEmail+"'");
                int initquant = 0;
                if(rs1.next()) {
                	initquant  = rs1.getInt(1);
                }
                statement.executeUpdate("delete from cart where pid = "+ pid+" and cusemail = '"+ActionServlet.customerEmail+"'");
                statement.executeUpdate("delete from wishlist where pid = "+ pid+" and cusemail = '"+ActionServlet.customerEmail+"'");

            	RequestDispatcher rd = request.getRequestDispatcher("/viewCart");
            	PreparedStatement ps = connection.prepareStatement("insert into cart values(?,?,?)");
            	ps.setString(1,uemail);
            	ps.setInt(2,pid );
            	ps.setInt(3,pquant + initquant);
            	ps.executeUpdate();
                rd.forward(request, response);
            }
            else {
            	RequestDispatcher rd = request.getRequestDispatcher("addcart.jsp");
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
