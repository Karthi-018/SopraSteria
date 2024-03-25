<%@page import="edu.sopra.training.SpringBootMVC.model.product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<%@include file="custIndex.jsp" %></center>


<center><h1 class="display-5">List of The Product</h1></center><br><br>


<center><p style="color: red;" class="lead">
  ${msg}
</p></center>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Buy</th>
      <th scope="col">Add to cart</th>
      <th scope="col">Add to Wishlist</th>
      
      
    </tr>
  </thead>
<tbody>
<% List<product> products = (List<product>)request.getAttribute("products");
	for(product s : products){
%>
<tr>
<td><%= s.getPname() %></td>
<td><%= s.getPdesc() %></td>
<td><%= s.getPprice() %></td>
<td><%= s.getQty() %></td>
<td><form action = "Buy">
			<button type="submit" name = "pid" value = "<%= s.getPid() %>" class="btn btn-warning">Buy</button>
	</form></td>
<td><form action = "Cart">
			<button type="submit" name = "pid" value = "<%= s.getPid() %>" class="btn btn-success">Add to Cart</button>
	</form></td>
<td><form action = "Wishlist">
			<button type="submit" name = "pid" value = "<%= s.getPid() %>" class="btn btn-secondary">Add to WishList</button>
	</form></td>

</tr>
<% } %>



</tbody>
</table>



</body>
</html>