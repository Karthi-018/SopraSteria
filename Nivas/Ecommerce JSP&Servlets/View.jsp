<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.*"%>
<%@page import="java.sql.*"%>
<%@page import="ecom.pro.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menubar.jsp" %>
<h1>View the product</h1>
${msg}

<% ResultSet rs=(ResultSet)request.getAttribute("rs");
if(rs!=null)
{%>
<table border="6"><tr><th>product_id</th><th>product_name</th><th>product_desc</th><th>product_price</th><th>product_qty</th></tr>
<% while(rs.next())
	 {
	 %>
	 <tr><td><%= rs.getInt(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td><td><%= rs.getInt(4) %></td><td><%= rs.getInt(5) %></td>
	 <td><form action='Edit'><button type="submit" name="edit" value="<%= rs.getInt(1) %>">Edit</button></form></td>
	 <td><form action='Delete'><button type="submit" name="delete" value="<%= rs.getInt(1) %>">Delete</button></form></td>
	 </tr>
<%} %>
</table>
<%} %>
</body>
</html>