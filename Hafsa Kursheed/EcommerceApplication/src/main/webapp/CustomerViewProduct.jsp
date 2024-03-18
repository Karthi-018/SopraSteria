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
	<%@ include file = "Customermenubar.jsp" %>
	<h1>VIEW PRODUCTS</h1>
	<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
</center>

<%
	ResultSet rs = (ResultSet)(request.getAttribute("result"));
	if(rs.next())
	{ 
%>
	<center>
		<h3>PRODUCTS ARE</h3>
	<center>
	
	<table>
	<tr>
	<th>PRODUCT NAME</th>
	<th>ADD TO WISHLIST</th>
	<th>ADD TO CART</th>
	<th>BUY PRODUCT</th>
	</tr>
<% do{
	String s = rs.getInt(1) + ":" + rs.getString(2); 
%>
	<tr>
	<td><a href='ProductDetailsServlet?prodid=<%= rs.getInt(1)%>'><%=rs.getString(2)%></a></td>
	<!-- <td><form action ='ProductDetailsServlet'>
		 <button type='submit' name='prodid' value="<%= rs.getInt(1)%>"> <%=rs.getString(2)%> </button>
	</form></td>-->
	
	<td><form action ='AddWishlistServlet'>
		<button type='submit' name='wishprod' value="<%= rs.getInt(1)%>">Add</button>
	</form></td>
	
	<td><form action ='AddCartServlet'>
		<button type='submit' name='cartprod' value="<%= rs.getInt(1)%>">Add</button>
	</form></td>
							
	<td><form action ='BuyProduct.jsp'>
		<button type='submit' name='buyprod' value="<%= s%>">Buy</button></form>
	</td></tr>
	
<% }while(rs.next()); %>

	</table>
	</center>
	
	<% } 
		else { %>
<center>
<h3>NO PRODUCTS ARE AVAILABLE</h3>
<center>
<% 
}	
%>


</body>
</html>