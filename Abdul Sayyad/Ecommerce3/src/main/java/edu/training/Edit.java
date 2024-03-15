package edu.training;

import java.io.IOException;
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

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));
		int pquant = Integer.parseInt(request.getParameter("pquant"));
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		
        RequestDispatcher rd = request.getRequestDispatcher("/view");
        RequestDispatcher rd1 = request.getRequestDispatcher("edit.jsp");

        if(pquant<0 || pprice<0) {
        	try {
        	request.setAttribute("msg", "<h2 style = 'color:red'>failed<h2>");
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
        	PreparedStatement ps1 = connection.prepareStatement("select * from product where pid = ?");
        	ps1.setInt(1,pid);
        	ResultSet rs1 = ps1.executeQuery();
        	rs1.next();
        	request.setAttribute("pid", rs1.getInt(1));
        	request.setAttribute("pname", rs1.getString(2));
        	request.setAttribute("pdesc", rs1.getString(3));
        	request.setAttribute("pquant", pquant);
        	request.setAttribute("pprice", pprice);
        	rd1.forward(request, response);
        	}
        	catch(Exception e) {
        		System.out.println(e);
        	}
        }
        else {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            PreparedStatement ps = connection.prepareStatement("update product set quantity=? , price = ? where pid =" + pid);
            ps.setInt(1, pquant);
            ps.setInt(2, pprice);
            int res = ps.executeUpdate();
            if (res>0) {
            	request.setAttribute("msg", "<h2 style = 'color:green'>Succeed<h2>");
            	PreparedStatement ps1 = connection.prepareStatement("select * from product where pid = ?");
            	ps1.setInt(1,pid);
            	ResultSet rs1 = ps1.executeQuery();
            	rs1.next();
            	request.setAttribute("pid", rs1.getInt(1));
            	request.setAttribute("pname", rs1.getString(2));
            	request.setAttribute("pdesc", rs1.getString(3));
            	request.setAttribute("pquant", rs1.getInt(4));
            	request.setAttribute("pprice", rs1.getInt(5));
            	rd.forward(request, response);
            	
            }else {
            	request.setAttribute("msg", "<h2 style = 'color:red'>failed<h2>");
            	rd1.forward(request, response);
            }
		}catch(Exception e) {
			System.out.println(e);
		}
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
