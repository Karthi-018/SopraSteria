<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="customerlogin.jsp" %>
<h1>View the product</h1>
<%=request.getAttribute("msg") %>
<% ResultSet rs=(ResultSet)request.getAttribute("rs");
if(rs!=null)
{%>
 <table border="1"><tr><th>product_id</th><th>product_name</th><th>product_price</th><th>product_qty</th></tr>
 <% while(rs.next())
	 {
	 %>
	 <tr><td><%= rs.getInt(1)%></td><td><%= rs.getString(2) %></td><td><%= rs.getInt(3) %></td><td><%= rs.getInt(4) %></td>
	 <td><form action='AddToCart'><button type="submit" name="cart" value="<%= rs.getString(2) %>">Add to Cart</button></form></td>
	 <td><form action='AddToWishlist'><button type="submit" name="wish" value="<%= rs.getString(2) %>">Add to Wishlist</button></form></td>
	 <td><form action='Buy'><button type="submit" name="buy" value="<%=rs.getString(2) %>">Buy</button></form></td>
	 </tr>
 <%} %>
 </table>
<%} %>
</body>
</html>