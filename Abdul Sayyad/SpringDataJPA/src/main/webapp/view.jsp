<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sopra.edu.training.SpringDataJPA.models.Product"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<center><%@include file= "adminmenu.jsp" %></center>
 <h3 style = "text-align:center;">Viewing the products</h3>
 <%! List<Product> list = new ArrayList<>();  %>
 <% list = (List<Product>)request.getAttribute("products");%> 

  <center>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Desc</th>
      <th scope="col">Product quant</th>
      <th scope="col">Product price</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
   <tbody>
   <%
   for(Product p:list){
	   out.println("<tr>");
	   out.println("<td>"+p.getpId()+"</td>");
	   out.println("<td>"+p.getProductName()+"</td>");
	   out.println("<td>"+p.getProductDesc()+"</td>");
	   out.println("<td>"+p.getProductQuant()+"</td>");
	   out.println("<td>"+p.getProductPrice()+"</td>");
	   out.println("<td><form action = 'Delete'>");
	   out.println("<button name = 'pid'  class='btn btn-primary' value = " + "'"+ p.getpId()+"'"+ ">Delete</button><br></form>");
	   out.println("<br><form action = 'Search2'>");
	   out.println("<button name = 'pid' class='btn btn-primary' value = " + "'"+ p.getpId()+"'"+ ">Edit</button><br></form></td>");
	   out.println("<tr>");
   }
   
   %>
  </tbody>
</table> 
</center>
</body>
</html>