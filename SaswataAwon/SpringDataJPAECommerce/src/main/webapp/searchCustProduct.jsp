<%@page import="java.util.List"%>
<%@page import="edu.sopra.training.SpringBootMVC.model.product"%>
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
<%@include file="custIndex.jsp" %></center>

<% List<product> pro= (List<product>) request.getAttribute("products") ;%>

<center><h1 class="display-5">Searched Product</h1></center><br><br>

<table class="table">
  <thead>
    <tr>
      
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      
      <th scope="col">Buy</th>
      <th scope="col">Cart</th>
      <th scope="col">WishList</th>
      
    </tr>
  </thead>
<tbody>
<% for(product p:pro) { %>
<tr>
<td><%= p.getPname()%></td>
<td><%= p.getPdesc()%></td>
<td><%= p.getPprice()%></td>

<td><form action = "Buy">
<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-warning">Buy</button>
</form></td>
<td><form action = "Cart">
<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-primary">Add to Cart</button>
</form></td>
<td><form action = "Wishlist">
<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-success">Add to Wishlist</button>
</form></td>

</tr>

<% } %>
</body>
</html>