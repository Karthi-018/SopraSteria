<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="customerMenubar.jsp" %></center>
 
<%
ResultSet rs=(ResultSet)request.getAttribute("resultSet");
%>
 
<table class="table">
  <thead>
    <tr>
      <th scope="col">Product ID</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
    </tr>
  </thead>
 
<%
if(rs!=null) {
    if(rs.next()) {
        do {
%>
 
  <tbody>
    <tr>
      <th scope="row"><%= rs.getInt(1) %></th>
      <td><%= rs.getString(2) %></td>
      <td><%= rs.getString(3) %></td>
      <td><%= rs.getInt(4) %></td>
      <td><%= rs.getInt(5) %></td>
      <td>
        <form action='DeleteFromCartServlet'>
          <button name='delete' value="<%= rs.getInt(1) %>">Delete</button>
        </form>
        <form action='CustomerBuyServlet'>
          <button name='buy' value="<%= rs.getInt(1) %>">Buy</button>
        </form>
         <form action='MoveToWishlistServlet'>
          <button name='move' value="<%= rs.getInt(1) %>">Move To Wishlist</button>
        </form>
      </td>
    </tr>
  </tbody>
 
<%
        } while(rs.next());
    }
}
%>
 
</table>
 
</body>
</html>