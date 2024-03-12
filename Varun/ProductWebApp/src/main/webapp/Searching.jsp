<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
<h1>Searching the product</h1>
<form action="SearchServlet">
<input type="text" name="searchproduct" placeholder="Enter the Search product">
<input type="submit" name="search" value="Search">
</form>
<% 
ResultSet rs=(ResultSet)request.getAttribute("rs");
  if(rs != null)
  {  
%>

<table>
<tr>
	<th>product id</th>
	<th>product name</th>
	<th>product desc</th>
	<th>product price</th>
	<th>product quantity</th>
</tr>
<% if(rs.next()){%>
<tr>
	<td><%= rs.getInt(1) %></td>
	<td><%= rs.getString(2) %></td>
	<td><%= rs.getString(3) %></td>
	<td><%= rs.getInt(4) %></td>
	<td><%= rs.getInt(5) %></td>
</tr>

<% } 
else{
%>
<tr><td colspan="5"><h1 style="color:red">Search element not found</h1></td></tr>

<%} %>
</table>
<% } %>
</body>
</html>