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
<title>Cart</title>
</head>
<body>
<center>

	<%@ include file = "Customermenubar.jsp" %>
	
	<h1>VIEW CART PRODUCTS</h1>

	<% int totPrice = 0; %>

<%
		ResultSet rs = (ResultSet)(request.getAttribute("result"));
		//ResultSet quantrs = (ResultSet)(request.getAttribute("res"));
		
		

			if(rs.next())
			{%>
				

				<h3>PRODUCTS ARE</h3>
				<table><tr>
				<th>PRODUCT NAME</th>
				<th>PRODUCT DESCRIPTION</th>
				<th>SINGLE PRODUCT PRICE</th>
				<th>QUANTITY</th>
				<th>AVAILABILITY</th>
				<th>REMOVE FROM CART</th>
				<th>MOVE TO WISHLIST</th>
				<th>BUY PRODUCT</th>
				</tr>
				
				<% 
				do{
					
					String s = rs.getInt(1) + ":" + rs.getString(2);
					
					if(rs.getString(6).equals("Available"))
					{	
						totPrice += rs.getInt(4)*rs.getInt(5);
					}
					
					%>
					
					<tr><td><%=rs.getString(2) %></td>
					<td><%=rs.getString(3) %></td>
					<td><%=rs.getInt(4) %></td>
					<td><%=rs.getInt(5) %></td>
					<td><%=rs.getString(6) %></td>
					<form action='UpdateCartServlet'>
					<td><button type='submit' name='choice' value="r:<%=rs.getInt(1) %>">Remove</button></td>
					<td><button type='submit' name='choice' value="a:<%=rs.getInt(1) %>">Move</button></td></form>
					<td><form action ='BuyProduct.jsp'><button type='submit' name='buyprod' value="<%=s%>">Buy</button>
					</form>
					</td>
					</tr>
				<%}	
				while(rs.next()); 
				
				%>
				
				
				</table>
				<br><br><br>
				
				<form action='BuyAllServlet'>
					<b>Total Price For Available Products: <%=totPrice %></b><br><br>
					<input type="submit" value="Buy Available Products"/>
				</form>
				</center>
				
			<% }
			else
			{ %>
			
				<h3>NO PRODUCTS ARE AVAILABLE</h3>
			<%} %>
		
		


</center>
</body>
</html>