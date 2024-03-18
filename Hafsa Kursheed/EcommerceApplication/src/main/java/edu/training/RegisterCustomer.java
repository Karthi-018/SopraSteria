package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterCustomer
 */
@WebServlet("/RegisterCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().println(request.getParameter("dob"));
		
		Date dob = Date.valueOf(request.getParameter("dob"));
//		response.getWriter().println(dob);
		
		try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from customers where email=?");
            ps.setString(1,request.getParameter("email"));
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	request.setAttribute("msg", "Failed to Register!!! User Already Exists!!!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else
            {
            	PreparedStatement ps1 = conn.prepareStatement("insert into customers(firstname,lastname,email,password,DOB,gender,status) values(?,?,?,?,?,?,?)");
                ps1.setString(1, request.getParameter("firstname"));
                ps1.setString(2, request.getParameter("lastname"));
                ps1.setString(3, request.getParameter("email"));
                ps1.setString(4, request.getParameter("pwd"));
                ps1.setDate(5, dob);
                ps1.setString(6, request.getParameter("gender"));
                ps1.setString(7, "New");
                int rs1 = ps1.executeUpdate();
                if(rs1>0)
                {
                    request.setAttribute("msg", "Registered Successfully");
                    request.getRequestDispatcher("Customerlogin.jsp").forward(request, response);
                }
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
