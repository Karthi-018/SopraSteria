<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="sopra.edu.training.SpringDataJPA.models.Product"%>
    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<center><%@include file= "cusmenu.jsp" %></center>
 <h5 style = "text-align:center;">Searching the product</h5>
 <center>
 <div class = "container"><div class = "col"> <%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %></div></div>
 <form action = "Search3">
<br><input type = "text" name = "pname" placeholder = "Enter product Name" required><br><br>
<input type = "submit" class="btn btn-outline-success" name = "method" value = "Search">
 </form>
<%! List<Product> list = new ArrayList<>();  %>
 <% list = (List<Product>)request.getAttribute("products");%> 
<br>

 <table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Product Desc</th>
      <th scope="col">Product price</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
     <%
    if(list != null){
   for(Product p:list){
	   out.println("<tr>");
	   out.println("<td>"+p.getProductName()+"</td>");
	   out.println("<td>"+p.getProductDesc()+"</td>");
	   out.println("<td>"+p.getProductPrice()+"</td>");
	   out.println("<td><form action = 'buy.jsp'>");
	   out.println("<button name = 'pid'  class='btn btn-primary' value = " + "'"+ p.getpId()+"'"+ ">Buy</button><br></form>");
	   out.println("<form action = 'addwishlist'>");
	   out.println("<br><button name = 'pid'  class='btn btn-primary' value = " + "'"+ p.getpId()+"'"+ ">Add To Wishlist</button><br></form>");
	   out.println("<form action = 'addcart'>");
	   out.println("<br><button name = 'pid'  class='btn btn-primary' value = " + "'"+ p.getpId()+"'"+ ">Add TO Cart</button><br></form></td>");
	   out.println("<tr>");
   }}
   %>
  </tbody>
</table>
 </center>
</body>
</html>