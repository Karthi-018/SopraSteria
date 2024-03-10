package sopra.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public List<Product> products = new ArrayList<Product>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        PrintWriter out= response.getWriter();

		//Page repopulation
        out.println("<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>\r\n"
        		+ "<meta charset=\"ISO-8859-1\">\r\n"
        		+ "<title>Insert title here</title>\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+ "	<form action = \"products\" method = \"post\">\r\n"
        		+ "	<label>PRODUCT ID</label>\r\n"
        		+ "	<input type = \"text\" name = \"productId\"   placeholder = \"Enter Product Id:\"><br>\r\n"
        		+ "	<label>PRODUCT NAME</label>\r\n"
        		+ "	<input type = \"text\" name = \"productName\"   placeholder = \"Enter Product Name:\"><br>\r\n"
        		+ "	<label>PRODUCT DESCRIPTION</label>\r\n"
        		+ "	<input type = \"text\" name = \"productDesc\"   placeholder = \"Enter Product Description:\"><br>\r\n"
        		+ "	<label>PRODUCT PRICE</label>\r\n"
        		+ "	<input type = \"text\" name = \"productPrice\"   placeholder = \"Enter Product Price:\"><br>\r\n"
        		+ "	<label>PRODUCT QUANTITY</label>\r\n"
        		+ "	<input type = \"text\" name = \"productQuantity\"   placeholder = \"Enter Product Quantity:\"><br>\r\n"
        		+ "	\r\n"
        		+ "	<input type = \"submit\" name=\"opr\" value = \"ADD\" >\r\n"
        		+ "	\r\n"
        		+ "	<input type=\"reset\"><br><br>\r\n"
        		+ "	<!--<input type = \"text\" name = \"search\" placeholder = \"Enter Product to Search:\">\r\n"
        		+ "	\r\n"
        		+ "	<input type = \"submit\" name=\"opr\" value = \"SEARCH\" ><br>-->\r\n"
        		+ "	</form> \r\n"
        		+ "	\r\n"
        		+ "	<form action = \"products\" method = \"post\">\r\n"
        		+ "	<input type=\"text\" name=\"search\" placeholder=\"Enter the PRODUCT to search\">\r\n"
        		+ "	<input type=\"submit\" name=\"opr\" value=\"SEARCH\">\r\n"
        		+ "	</form> \r\n"
        		+ "	\r\n"
        		+ "\r\n"
        		+ "</body>\r\n"
        		+ "</html>");
		String opr = request.getParameter("opr");
		
		if(opr.equals("ADD"))
		{
			//Getting form data
	        int productId = Integer.parseInt(request.getParameter("productId"));
	        String productName = request.getParameter("productName");
	        String productDesc = request.getParameter("productDesc");
	        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
	        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
	        
	        //Creating Product object
	        Product newProduct = new Product();
	        newProduct.setProductId(productId);
	        newProduct.setProductName(productName);
	        newProduct.setProductDesc(productDesc);
	        newProduct.setProductPrice(productPrice);
	        newProduct.setProductQuantity(productQuantity);
	        
	        //Adding products to list
	        products.add(newProduct);
	        
	        
	        
	        //Printing Products Table
	        out.println("<br>");
	        out.println("<table border='1'>");
	        out.println("<tr><th>ID</th><th>Name</th><th>Description</th><th>Price</th><th>Quantity</th><th>Action</th></tr>");
	        for (Product p : products) {
	            out.println("<tr>");
	            out.println("<td>" + p.getProductId() + "</td>");
	            out.println("<td>" + p.getProductName() + "</td>");
	            out.println("<td>" + p.getProductDesc() + "</td>");
	            out.println("<td>" + p.getProductPrice() + "</td>");
	            out.println("<td>" + p.getProductQuantity() + "</td>");
	            out.println("<td><input type = \"submit\" value = \"DELETE\" ></td>");
	            out.println("</tr>");}
	        
//	        String op = request.getParameter("op");
//	        if(op.equals("DELETE"))
//	        {
//	        	out.println("----DELETE----");
//	        }
		}
		
		else //if(opr.equals("SEARCH"))
		{
			 //Searching Product using Id
	        Product foundProduct = null;
	        String num = request.getParameter("search");
	       
	        int productIdToSearch = Integer.parseInt(num);
	        foundProduct = searchProduct(productIdToSearch);
	        if(foundProduct==null && productIdToSearch != 0)
	        {
	        	out.println("Product not found!!!<br>");
	        }
	        else if(productIdToSearch != 0)
	        {
	        	out.println("Product Found!!!<br>");
	        	out.println("ID: "+foundProduct.getProductId()+"<br>");
	        	out.println("Name: "+foundProduct.getProductName()+"<br>");
	        	out.println("Description: "+foundProduct.getProductDesc()+"<br>");
	        	out.println("Price: "+foundProduct.getProductPrice()+"<br>");
	        	out.println("Quantity: "+foundProduct.getProductQuantity()+"<br>");
	        }
		}
        //out.println("Product added successfully!");
	}
	
	
	
	public Product searchProduct(int productId)
	{
		for(Product p:products)
		{
			if(p.getProductId()==productId)
			{
				return p;
			}
		}
		return null;
	}

}
