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
<title>Customers</title>
</head>
<body>

<%
	ResultSet rs = (ResultSet)(request.getAttribute("result"));
	if(rs.next())
	{ 
%>
	<center><br>
	<%@ include file = "menubar.jsp" %>
	<br><br><br>
		<h3>REGISTERED CUSTOMERS</h3>
	
	
	<table>
	<tr>
	<th>CUSTOMER ID</th>
	<th>FIRST NAME</th>
	<th>LAST NAME</th>
	<th>EMAIL</th>
	<th>DATE OF BIRTH</th>
	<th>GENDER</th>
	<th>STATUS</th>
	<th>CHANGE STATUS</th>
	</tr>
<% do{
	
%>
	<tr>
	<td><%= rs.getInt(7)%></td>
	<td><%= rs.getString(1)%></td>
	<td><%= rs.getString(2)%></td>
	<td><%= rs.getString(3)%></td>
	<td><%= rs.getDate(5)%></td>
	<td><%= rs.getString(6)%></td>
	<td><%= rs.getString(8)%></td>
	
	<%
	 String st = rs.getString(8);
	 if(st.equals("Active"))
	 {%>
		 <td><form action="ActivateServlet"><button name="status" value="<%= rs.getInt(7)%>">In-activate</button></form></td>
	 <%}
	 	else{
	 %>
	 	<td><form action="ActivateServlet"><button name="status" value="<%= rs.getInt(7)%>">Activate</button></form></td>
	 	<% }%>
</tr>
	
<% }while(rs.next()); %>

	</table>

	
	<% } 
		else { %>

<h3>NO CUSTOMERS</h3>

<% 
}	
%>

</center>
</body>
</html>