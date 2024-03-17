<%@page import="training.pojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

<center>
<%@include file="MenuBarCust.jsp" %></center><br>

<h3 style = "text-align:center;">YOUR WISHLIST</h3><br><br>
<center>
<% List<pojo> actionList= (List<pojo>) request.getAttribute("actionlist"); %>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Buy</th>
      <th scope="col">Remove</th>
      <th scope="col">Cart</th>
      
    </tr>
  </thead>
  <tbody>
  <% for(training.pojo action:actionList){ %>
		<tr>
			
			<td><%= action.getName() %></td>
			<td><%= action.getDesc() %></td>
			<td><%= action.getPrice() %></td>
			
			<td><form action = "Buy2" method="get">
			<button type="submit" name = "pName" value = "<%= action.getName()%>" class="btn btn-warning">Buy</button>
			</form></td>
			<td><form action = "RemoveWish" method="get">
			<button type="submit" name = "Id" value = "<%= action.getId()%>" class="btn btn-success">Remove</button>
			</form></td>
			<td><form action = "Cart" method="get">
			<button type="submit" name = "Id" value = "<%= action.getId()%>" class="btn btn-secondary">Add to Cart</button>
			</form></td>
			
		</tr>
	<% } %>
</tbody>
  
	

</table> 
</center>

</body>
</html>