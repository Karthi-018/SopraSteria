package edu.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("pid"));
		int price = Integer.parseInt(request.getParameter("pprice"));
		int quant = Integer.parseInt(request.getParameter("pquant"));
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("update products set price = ? , quantity = ? where pid = ?");
			ps.setInt(1,price);
			ps.setInt(2,quant);
			ps.setInt(3,id);
            
            int rs = ps.executeUpdate();
            

            if(rs>0)
            {
            	PreparedStatement ps1 = conn.prepareStatement("update cart set availability = ? where prid = ? and quantity > ?");
    			ps1.setString(1,"Not Available");
    			ps1.setInt(2, id);
    			ps1.setInt(3, quant);
    			
            	request.setAttribute("msg", "PRODUCT UPDATED SUCCESSFULLY"); 
            	request.getRequestDispatcher("viewServlet").forward(request, response);
            	
            }
            
            
//            request.getRequestDispatcher("viewServlet.jsp").forward(request, response);
            
		} 
		catch (SQLException e) 
		{
			try
			{
				conn = DBConnection.getConnection();
				PreparedStatement ps1 = conn.prepareStatement("select * from products where pid = ?");
                ps1.setInt(1,id);
            	ResultSet rs1 = ps1.executeQuery();
            	rs1.next();
            	request.setAttribute("pname", rs1.getString(2));
            	request.setAttribute("pdesc", rs1.getString(3));
            	request.setAttribute("msg", "ERROR ENCOUNTERED WHILE UPDATING THE PRODUCT");
            	request.setAttribute("pid", id);
            	request.setAttribute("pprice", price);
            	request.setAttribute("pquant", quant);
            	request.getRequestDispatcher("editProduct.jsp").forward(request, response);
			}
			catch (SQLException e1) 
			{
				
				response.getWriter().println(e);
			}
			
//			request.setAttribute("msg", "NO SUCH PRODUCT HAS FOUND");
//        	request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
//			e.printStackTrace();
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
