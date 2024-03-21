<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.SpringBootMVC.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid #dee2e6;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #007bff; /* Blue background for headers */
        color: #fff;
    }

    .delete-button, .edit-button {
        padding: 5px 10px;
        border: 1px solid #ccc; /* Remove blue border */
        border-radius: 3px;
        background-color: #fff; /* White background */
        color: #007bff; /* Blue text color */
        cursor: pointer;
    }

    .delete-button:hover, .edit-button:hover {
        background-color: #f8f9fa; /* Change hover background color */
        color: #0056b3; /* Change hover text color */
    }
</style>
</head>
<body>
<center><%@ include file="CustomerMenubar.jsp" %></center>
<center>

<table>
<thead>
<th>Product Name</th>
<th>Description</th>
<th>Price</th>
<th>Quantity</th>
<th>Action</th>
</thead>
<tbody>
<% 
List<Product> product = (List<Product>)request.getAttribute("product_list");
%>
<tr>
<%  for(Product p:product){  %>
<td><%=p.getName() %></td>
<td><%=p.getDesc() %></td>
<td><%=p.getPrice() %></td>
<td><%=p.getQuantity() %></td>
<td><form action='BuyProduct' ><button name= 'buyId' value="<%=p.getpId()%>">BUY</button></form>
<form action='AddToCartProduct' ><button name='cart' value="<%= p.getpId() %>">ADD TO CART</button></form>
<form action='AddToWishlistProduct' ><button name='wishlist' value="<%= p.getpId() %>">ADD TO WISHLIST</button></form></td>
</tr>
<%} %>
</tbody>
</table>
</center>
 
</body>
</html>