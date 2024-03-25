<%@page import="java.util.List"%>
<%@page import="edu.sopra.training.SpringBootMVC.model.product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<%@include file="custIndex.jsp" %></center><br>

<h3 style = "text-align:center;">YOUR CART</h3><br><br>
<center>
<% List<product> actionList= (List<product>) request.getAttribute("products"); %>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Buy</th>
      <th scope="col">Cart</th>
      <th scope="col">WishList</th>
      
    </tr>
  </thead>
  
  <tbody>
  <% for(product p:actionList) { %>
  
		<tr>
			
			<td><%= p.getPname() %></td>
			<td><%= p.getPdesc() %></td>
			<td><%= p.getPprice() %></td>
			
			<form>
			<td>
				<input type="number" name="qty" value="1">
		
				
			</td>
			</form>
			
			<td><form action = "Buy">
			<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-warning">Buy</button>
			</form></td>
			<td><form action = "RemoveCart">
			<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-success">Remove</button>
			</form></td>
			<td><form action = "Wishlist">
			<button type="submit" name = "pid" value = "<%= p.getPid()%>" class="btn btn-secondary">Add to WishList</button>
			</form></td>
			
		</tr>
	<% } %>
</tbody>
  
	

</table> 
</center>

<center><br><br>

<form action="BuyAll" method="get">
<button type="submit" name= "buyall" class="btn btn-primary btn-lg">BUY ALL</button>
</form>

</center>

<center><p style="color: red;" class="lead">
  ${msg}
</p></center>

</body>
</html>