package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String pdesc = request.getParameter("pdesc");
		int pquant = Integer.parseInt(request.getParameter("pquant"));
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		
        RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
        if(pquant<0 || pprice<0) {
        	request.setAttribute("msg", "<h2 style = 'color:red'>failed<h2>");
        	rd.forward(request, response);
        }
        else {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            PreparedStatement ps = connection.prepareStatement("insert into product values(?,?,?,?,?)");
            ps.setInt(1, pid);
            ps.setString(2, pname);
            ps.setString(3, pdesc);
            ps.setInt(4, pquant);
            ps.setInt(5, pprice);
            int res = ps.executeUpdate();
            if (res>0) {
            	request.setAttribute("msg", "<h2 style = 'color:green'>Succeed<h2>");
            	rd.forward(request, response);
            }else {
            	request.setAttribute("msg", "<h2 style = 'color:red'>failed<h2>");
            	rd.forward(request, response);
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
