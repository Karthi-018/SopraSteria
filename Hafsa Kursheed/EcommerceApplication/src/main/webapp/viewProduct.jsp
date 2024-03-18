<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<center>
	<%@ include file = "menubar.jsp" %>
	<h1>VIEW PRODUCTS</h1>
	<%= request.getAttribute("msg")== null ?"":request.getAttribute("msg") %>
</center>

<%
		ResultSet rs = (ResultSet)(request.getAttribute("result"));

			if(rs.next())
			{
				out.println("<center><h3>PRODUCTS ARE</h3><center>");
				out.println("<table><tr><th>PRODUCT ID</th>" +
						"<th>PRODUCT NAME</th>" +
						"<th>PRODUCT DESC</th>" +
						"<th>PRODUCT PRICE</th>" +
						"<th>PRODUCT QUANTITY</th>"+
						"<th>EDIT PRODUCT</th>"+
						"<th>DELETE PRODUCT</th>"+
						"</tr>"
					);
				do{
					out.println("<tr><td>"+rs.getInt(1)+ "</td>" +
							"<td>"+rs.getString(2)+ "</td>" +
							"<td>"+rs.getString(3)+ "</td>" +
							"<td>"+rs.getInt(4)+ "</td>" +
							"<td>"+rs.getInt(5)+ "</td>" +
							"<td><form action ='searchEditServlet'><button type='submit' name='editprod' value='" + rs.getInt(1)+"'>Edit</button></form></td>" +
							"<td><form action ='deleteServlet'><button type='submit' name = 'delprodid' value ='" + rs.getInt(1)+"'>Delete</button></form></td></tr>");
				}	
				while(rs.next());
				
				out.println("</table></center>");
				
			}
			else
			{
				out.println("<center><h3>NO PRODUCTS ARE AVAILABLE</h3><center>");
			}
		
	%>


</body>
</html>