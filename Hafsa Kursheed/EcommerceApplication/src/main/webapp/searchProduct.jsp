<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
<center>
	<br><br>
	<%@ include file = "menubar.jsp" %>
	<br><br>
	<h1>SEARCH PRODUCT</h1>


<form action="searchServlet">
	<input type="number" placeholder="Enter Product ID to search" name="searchProd"/>  
	<input type="submit" value="Search"/>
</form>

<br><br>

	<%
		String msg = request.getAttribute("msg")== null ?"":request.getAttribute("msg").toString();
		if(!msg.equals(""))
		{
			if(msg.equals("PRODUCT FOUND"))
			{ %>
				
				<h3><%=msg%></h3>
				
				<table>
				<thead><tr>
				<th>PRODUCT ID</th>
				<th>PRODUCT NAME</th>
				<th>PRODUCT DESC</th>
				<th>PRODUCT PRICE</th>
				<th>PRODUCT QUANTITY</th>
				</tr></thead>
				
				<tbody><tr>
				<td><%=request.getAttribute("pid") %></td>
				<td><%=request.getAttribute("pname") %></td>
				<td><%=request.getAttribute("pdesc") %></td>
				<td><%=request.getAttribute("pprice") %></td>
				<td><%=request.getAttribute("pquant") %></td>
				</tr></table>
				
			<%}
			else
			{ %>
				<h3><%=msg %></h3>
			<% }
		}
	%>
</center>
</body>
</html>