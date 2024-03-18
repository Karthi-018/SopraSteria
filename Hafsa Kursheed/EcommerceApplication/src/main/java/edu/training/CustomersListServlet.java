package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomersListServlet
 */
@WebServlet("/CustomersListServlet")
public class CustomersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from customers");
            ResultSet rs = ps.executeQuery();
            request.setAttribute("result", rs); 
            request.getRequestDispatcher("CustomersList.jsp").forward(request, response);
        }

        catch (SQLException e)
        {
//        	request.setAttribute("msg", "Error Encountered While Registeration");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
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
