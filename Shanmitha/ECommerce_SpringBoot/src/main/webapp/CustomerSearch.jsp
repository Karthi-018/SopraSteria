<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.SpringBootMVC.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center><%@ include file="CustomerMenubar.jsp" %></center>
<center><br>
<form action="CustSearchProd">
<label>Name</label>
<input type = "text" name = "search"   placeholder = "Enter product name to search:">
<input type = "submit" value = "search" name="act">
</form>
</center>
<br>
<center>
<h3>${notFound}</h3>
<table>
<thead>
<th>Product ID</th>
<th>Product Name</th>
<th>Description</th>
<th>Price</th>
<th>Quantity</th>
</thead>
<tbody>
<% 
	Product product = (Product)request.getAttribute("product");
%>
<tr>
<% if(product !=null){ %>
<td><%=product.getpId() %></td>
<td><%=product.getName() %></td>
<td><%=product.getDesc() %></td>
<td><%=product.getPrice() %></td>
<td><%=product.getQuantity() %></td>
</tr>
<%} %>
</tbody>
</table>
</center>

</body>
</html>