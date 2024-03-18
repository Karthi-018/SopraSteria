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
<title>Wish list</title>
</head>
<body>
<center>
	<%@ include file = "Customermenubar.jsp" %>
	<h1>VIEW WISHLIST PRODUCTS</h1>


<%
		ResultSet rs = (ResultSet)(request.getAttribute("result"));

			if(rs.next())
			{ %>
				<h3>PRODUCTS ARE</h3>
				<table>
				<tr>
					<th>PRODUCT NAME</th>
					<th>PRODUCT DESCRIPTION</th>
					<th>PRODUCT PRICE</th>
					<th>REMOVE FROM WISHLIST</th>
					<th>MOVE TO CART</th>
					</tr>
<%
				do{
					
					String s = rs.getInt(1) + ":" + rs.getString(2);  %>
					
					<tr>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getInt(4) %></td>
					<form action='UpdateWishlistServlet'>
					<td><button type='submit' name='choice' value="r:<%=rs.getInt(1) %>">Remove</button></td>
					<td><button type='submit' name='choice' value="a:<%=rs.getInt(1) %>">Move</button></td>
					</form></tr>
					<% 
				}	
				while(rs.next()); %>
				
				</table>
				
			<%}
			else
			{ %>
				<h3>NO PRODUCTS ARE AVAILABLE</h3>
			<% }
		
	%>

</center>
</body>
</html>