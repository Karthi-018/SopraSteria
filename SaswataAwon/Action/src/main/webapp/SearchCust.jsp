<%@page import="training.pojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Searching for Customer</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
</head>
<body>
<center><%@include file="MenuBarCust.jsp" %></center><br><br>
<h3 style="text-align: center;">Searching a product</h3>

<% String msg=request.getAttribute("msg").toString();
if(msg=="" || msg.equals("Product is not found")){
%>
<%=msg %>


<dialogue open>
<center>
<div style="height: 660px; width: 397px";>
<fieldset><br><br>

<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <form action= "searchCust" method= "get" class="d-flex" role="search">
      <input class="form-control me-2" type="search" name="pName" placeholder="Enter product Name" aria-label="Search">
      <button class="btn btn-outline-success" value= "search" type="submit">Search</button>
    </form>
  </div>
</nav>
</fieldset>
</div>
</center>
</dialogue>


<%} else if(msg.equals("Product is found")) {%>
<%= msg %>
<center>
<% List<pojo> actionList= (List<pojo>) request.getAttribute("actionlist"); %>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Buy</th>
      <th scope="col">Add to Cart</th>
      <th scope="col">Add to WishList</th>
      
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
			<td><form action = "Cart" method="get">
			<button type="submit" name = "Id" value = "<%= action.getId()%>" class="btn btn-success">Add to Cart</button>
			</form></td>
			<td><form action = "Wishlist" method="get">
			<button type="submit" name = "Id" value = "<%= action.getId()%>" class="btn btn-secondary">Add to WishList</button>
			</form></td>
			
			
		</tr>
	<% } %>
</tbody>
<% } %>
</table>
</center>

</body>
</html>