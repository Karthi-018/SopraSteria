<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.SpringBootMVC.model.Wishlist" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="CustomerMenubar.jsp" %></center>
 
<%
List<Wishlist> product = (List<Wishlist>)request.getAttribute("wish_list");
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
for(Wishlist p:product){
%>
 
  <tbody>
    <tr>
      <th scope="row"><%= p.getProdName() %></th>
      <td><%= p.getQuantity() %></td>
      <td><%= p.getPrice() %></td>
      <td>
        <form action='DeleteFromWishlist'>
          <button name='delete' value="<%= p.getProductId() %>">Delete</button>
        </form>
        <form action='MoveToCart'>
          <button name='move' value="<%= p.getProductId() %>">Move To Cart</button>
        </form>
      </td>
    </tr>
  </tbody>
 
<%
}
%>
 
</table>
 
</body>
</html>