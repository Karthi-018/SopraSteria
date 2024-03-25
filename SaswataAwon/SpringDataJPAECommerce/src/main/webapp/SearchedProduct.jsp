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
<%@include file="index.jsp" %></center>

<center><h1 class="display-5">Searched Product</h1></center><br><br>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Product ID</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
      
    </tr>
  </thead>
<tbody>

<tr>
<td>${products.getPid()}</td>
<td>${products.getPname()}</td>
<td>${products.getPdesc()}</td>
<td>${products.getPprice()}</td>
<td>${products.getQty()}</td>
<td><form action = "Edit">
<button type="submit" name = "pid" value = "${products.getPid()}" class="btn btn-warning">Edit</button>
</form></td>
<td><form action = "Delete">
<button type="submit" name = "pid" value = "${products.getPid()}" class="btn btn-danger">Delete</button>
</form></td>

</tr>
</body>
</html>