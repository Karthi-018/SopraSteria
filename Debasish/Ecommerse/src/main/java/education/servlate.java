package education;

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
 * Servlet implementation class servlate
 */
//@WebServlet("/servlate")      
public class servlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List <ecommerse> list=new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter run=response.getWriter();
		run.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form action=\"myservlate\" >\r\n"
				+ "	<lable>Product Id</lable><input type=\"number\" name=\"pId\"><br><br>\r\n"
				+ "	<lable>Product Name</lable><input type=\"text\" name=\"pName\"><br><br>\r\n"
				+ "	<lable>Product Desc</lable><input type=\"text\" name=\"pDes\"><br><br>\r\n"
				+ "	<lable>Product Price</lable><input type=\"number\" name=\"pPrice\"><br><br>\r\n"
				+ "	<lable>Product Quantity</lable><input type=\"number\" name=\"pQuantiity\"><br><br>\r\n"
				+ "	\r\n"
				+ "	<input type=\"submit\" name=\"method\" value=\"add\">\r\n"
				+ "<br><br><br><br>"
				+ "	</form>\r\n"
				+ "\r\n"
				+"<form action=\"myservlate\" >\r\n"
						+ "	<input type=\"number\" name=\"SearchId\">\r\n"
						+ "	<input type=\"submit\" name=\"method\" value=\"search\"><br><br>\r\n"
						+ "</form>"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		String choice=request.getParameter("method");
		if(choice.equals("add")) {
			
			list.add(new ecommerse(Integer.parseInt(request.getParameter("pId")),
					request.getParameter("pName"),
					request.getParameter("pDes"),
					Integer.parseInt(request.getParameter("pQuantiity")),
					Integer.parseInt(request.getParameter("pPrice"))));
			
					
			
		}
		
		else if("search".equals(choice)) {
			//run.println("<h1>searching</h1>");
			boolean flag=false;
			for(ecommerse e:list) {
				if(Integer.parseInt(request.getParameter("SearchId"))==e.getpId()) {
					flag=true;
					run.println("<table border=\"1\">\r\n"
							+ "  <thead>\r\n"
							+ "    <tr>\r\n"
							+ "      <th>ProductId</th>\r\n"
							+ "      <th>ProductName</th>\r\n"
							+ "      <th>ProductDesc</th>\r\n"
							+ "      <th>ProductQuantity</th>\r\n"
							+ "      <th>ProductPrice</th>\r\n"
							+ "    </tr>\r\n"
							+ "  </thead>\r\n"
							+ "  <tbody>\r\n");
					run.println("<tr>\r\n"
							+ "      <td>"+e.getpId()+"</td>\r\n"
							+ "      <td>"+e.getpName()+"</td>\r\n"
							+ "      <td>"+e.getpDesc()+"</td>\r\n"
							+ "      <td>"+e.getpPrice()+"</td>\r\n"
							+ "      <td>"+e.getpQuantity()+"</td>\r\n"
							
							+ "    </tr>");
					run.println("</tbody>\r\n"
							+ "</table>\r\n"
							+ "\r\n"
							+ "</body>\r\n"
							+ "</html>");	
				}
					
			}
			if(flag==false) {
				run.println("product not found !!!");
			}
		}
		
		else{
			//run.println("<h1>hello</h1>");
			int id=Integer.parseInt(request.getParameter("method"));
			for(int i=0;i<list.size();i++) {
				if(id==list.get(i).getpId()) {
					list.remove(i);
					break;
				}
			}
		}
		
		if(list.size()==0) {
			run.println("<div>file empty</div>");
		}
		else if(list.size()>0) {
			run.println("<br><br><table border=\"1\">\r\n"
					+ "  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "      <th>ProductId</th>\r\n"
					+ "      <th>ProductName</th>\r\n"
					+ "      <th>ProductDesc</th>\r\n"
					+ "      <th>ProductQuantity</th>\r\n"
					+ "      <th>ProductPrice</th>\r\n"
					+ "      <th>action</th>\r\n"
					+ "    </tr>\r\n"
					+ "  </thead>\r\n"
					+ "  <tbody>\r\n");
			for(ecommerse e:list)		
			run.println("<tr>\r\n"
					+ "      <td>"+e.getpId()+"</td>\r\n"
					+ "      <td>"+e.getpName()+"</td>\r\n"
					+ "      <td>"+e.getpDesc()+"</td>\r\n"
					+ "      <td>"+e.getpPrice()+"</td>\r\n"
					+ "      <td>"+e.getpQuantity()+"</td>\r\n"
					+ "     <td><form action=''><button type=\"submit\" name=\"method\" value=\""+e.getpId() +"\">delete</button></form></td>"
					+ "    </tr>");
			        
					
			run.println("</tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");	
		}
		
		
	}

}
