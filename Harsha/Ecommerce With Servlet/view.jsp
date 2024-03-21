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
<%@ include file="menu.jsp" %>
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
	 <td><form action='Edit'><button type="submit" name="edit" value="<%= rs.getInt(1) %>">Edit</button></form></td>
	 <td><form action='Delete'><button type="submit" name="delete" value="<%=   rs.getInt(1) %>">Delete</button></form></td>
	 </tr>
 <%} %>
 </table>
<%} %>

</body>
</html>