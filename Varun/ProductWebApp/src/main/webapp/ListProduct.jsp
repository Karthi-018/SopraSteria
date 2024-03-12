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
<h1>Listing the product</h1>

<%  ResultSet rs=(ResultSet)request.getAttribute("rs");
if(rs==null)
{ %>
<h1>Element not found</h1>	
<% }else{%>
<table>
<tr>
<th>product id</th>
<th>product name</th>
<th>product desc</th>
<th>product price</th>
<th>product quantity</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<% while(rs.next()){ %>
<tr>
<td><%= rs.getInt(1)%></td>
<td><%= rs.getString(2)%></td>
<td><%= rs.getString(3)%></td>
<td><%= rs.getInt(4)%></td>
<td><%= rs.getInt(5)%></td>
<td><form action="DeleteServlet"><input type="text" value="<%= rs.getInt(1)%>" name="pid" hidden="true"><button type="submit">Delete</button></form></td>
<td><form action="EditServlet"><input type="text" value="<%= rs.getInt(1)%>" name="pid" hidden="true"><button type="submit" value="Edit" name="Edit">Edit</button></form></td>
</tr> 
<% }} %>
</table>
</body>
</html>
