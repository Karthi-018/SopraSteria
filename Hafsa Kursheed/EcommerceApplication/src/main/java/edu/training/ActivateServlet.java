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
 * Servlet implementation class ActivateServlet
 */
@WebServlet("/ActivateServlet")
public class ActivateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("status"));
		try
        {
            conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("select status from customers where cid = ?");
            pst.setInt(1,cid);
            ResultSet rst = pst.executeQuery();
            rst.next();
            PreparedStatement ps = conn.prepareStatement("update customers set status=? where cid = ?");
            if(rst.getString(1).equals("Active"))
            {
            	 ps.setString(1,"Inactive");
            }
            else 
            {
            	ps.setString(1,"Active");
            }
           
            ps.setInt(2,cid);
            int r = ps.executeUpdate();
            if(r>0)
            {
                request.getRequestDispatcher("CustomersListServlet").forward(request, response);
            }
            else
            {
            	response.getWriter().println("Error Occured To Activate");
            }
        }

        catch (SQLException e)
        {
        	request.setAttribute("msg", "Error Encountered While Registeration");
            request.getRequestDispatcher("register.jsp").forward(request, response);
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
