<%@page import="java.util.List"%>
<%@page import="edu.sopra.training.SpringBootMVC.model.product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="custIndex.jsp" %></center><br>

<h3 style = "text-align:center;">YOUR Wishlist</h3><br><br>
<center>
<% List<product> actionList= (List<product>) request.getAttribute("products"); %>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Buy</th>
      <th scope="col">Remove</th>
      <th scope="col">Cart</th>
      
    </tr>
  </thead>
  
  <tbody>
  <% for(product p:actionList) { %>
  
		<tr>
			
			<td><%= p.getPname() %></td>
			<td><%= p.getPdesc() %></td>
			<td><%= p.getPprice() %></td>
			
			
			<td><form action = "Buy">
			<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-warning">Buy</button>
			</form></td>
			<td><form action = "RemoveWishlist">
			<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-success">Remove</button>
			</form></td>
			<td><form action = "Cart">
			<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-secondary">Add to Cart</button>
			</form></td>
			
		</tr>
	<% } %>
</tbody>
  
	

</table> 
</center>


</body>
</html>