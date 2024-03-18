package edu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBuyProductServlet
 */
@WebServlet("/SearchBuyProductServlet")
public class SearchBuyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBuyProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		int quant = Integer.parseInt(request.getParameter("pquant"));
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from products where pid = ?");
			ps.setInt(1,pid);
            ResultSet rs = ps.executeQuery();
            rs.next();

            	if(rs.getInt(5)<quant)
            	{
            		out.println("<h1>SORRY!! QUANTITY IS MORE, PRODUCT NOT AVAILABLE<h1>");
            	}
            	else
            	{
            		if(rs.getInt(5)==quant)
            		{
            			PreparedStatement psd1 = conn.prepareStatement("delete from products where pid=?");
    					psd1.setInt(1, pid);
    					psd1.executeUpdate();
    					
    					PreparedStatement psd2 = conn.prepareStatement("update cart set availability = ? where prid = ?");
    					psd2.setString(1, "Not Available");
    					psd2.setInt(2, pid);
    					psd2.executeUpdate();
            		}
            		else
            		{
            			PreparedStatement psd11 = conn.prepareStatement("update products set quantity = quantity - ? where pid = ?");
    					psd11.setInt(1, quant);
    					psd11.setInt(2, pid);
    					psd11.executeUpdate();
    					
    					
    					PreparedStatement psd12 = conn.prepareStatement("update cart set availability = ? where prid = ? and quantity > ?");
    					psd12.setString(1, "Not Available");
    					psd12.setInt(2, pid);
    					psd12.setInt(3,quant);
    					psd12.executeUpdate();
            		}
            		
            		out.println("<html><head><style>\r\n"
            				+ "table, th, td {\r\n"
            				+ "  border: 1px solid black;\r\n"
            				+ "}\r\n"
            				+ "</style></head><body><a href='Customerhome.jsp'>Go To Home</a><center>");

            	
            	out.println("<h1>PRODUCT BOUGHT</h1><h4>Thank You For Purchasing</h4><center>");
				out.println("<table><tr>" +
						"<th>PRODUCT NAME</th>" +
						"<th>PRODUCT DESCRIPTION</th>" +
						"<th>PRODUCT PRICE</th>" +
						"<th>PRODUCT QUANTITY</th></tr>"
					);
					out.println("<tr><td>"+rs.getString(2)+ "</td>" +
							"<td>"+rs.getString(3)+ "</td>" +
							"<td>"+(rs.getInt(4)*quant)+ "</td>" +
							"<td>"+ quant + "</td></tr>");
			
				
				out.println("</table>");
		
            	}
            	out.println("</center></body></html>");
//            request.getRequestDispatcher("BuyProduct.jsp").forward(request, response);
            
		} 
		catch (Exception e) 
		{
//			PrintWriter out = response.getWriter();
			out.println(e);
			//response.getWriter().println(e);
//			request.setAttribute("msg", "NO SUCH PRODUCT HAS FOUND");
//        	request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
//			e.printStackTrace();
		}
		finally
        {
               try
               {
                   conn.close();
               }
               catch (SQLException e)
               {
//            	   PrintWriter out = response.getWriter();
       				out.println(e);
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
