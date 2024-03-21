<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.SpringBootMVC.model.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="CustomerMenubar.jsp" %></center>
 
<%
List<Cart> product = (List<Cart>)request.getAttribute("cart_list");
%>
 
<table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
 
<%
for(Cart p:product){
%>
 
  <tbody>
    <tr>
      <th scope="row"><%= p.getProdName() %></th>
      <td><%= p.getQuantity() %></td>
      <td><%=p.getPrice() %></td>
      <td>
        <form action='DeleteFromCart'>
          <button name='delete' value="<%= p.getProductId() %>">Delete</button>
        </form>
        <form action='BuyFromCart'>
          <button name='buy' value="<%= p.getProductId() %>">Buy</button>
        </form>
         <form action='MoveToWishlist'>
          <button name='move' value="<%= p.getProductId() %>">Move To Wishlist</button>
        </form>
      </td>
    </tr>
  </tbody>
 
<%
}
%>
</table>
		<br>
		<br>
         <form action='CustomerBuyAll'>
          <button name='buy' value="buy">Buy All</button>
        </form>
</body>
</html>