<%@page import="training.pojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Searching</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<center><%@include file="menubar.jsp" %></center><br><br>
<center><h1 class="display-5">Searching The Product</h1></center><br><br>

<% String msg=request.getAttribute("msg").toString();
if(msg=="" || msg.equals("Product is not found")){
%>
<%=msg %>


<dialogue open>
<center>
<div style="height: 660px; width: 397px";>
<fieldset><br><br>

<!-- <form action="SearchServlet" method="get">
	<table>
		<tr> 
			<th style="text-align: left;">Product ID</th>
			<th><input type="number" name="pid" placeholder="Enter id"/>
		</tr>
		<div class="mb-3">
  		<label for="formGroupExampleInput" class="form-label">Product ID</label>
 		 <input type="number" name="pid" class="form-control" id="formGroupExampleInput" placeholder="Enter product ID to search">
		</div>
		
	</table><br><br>
	<div class="col-12">
    <button class="btn btn-primary" type="submit" value="Search">Submit Details</button>
  </div>
	<input type="submit" value="Search"/>
</form> -->

<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <form action= "SearchServlet" method= "get" class="d-flex" role="search">
      <input class="form-control me-2" type="search" name="pid" placeholder="Enter product ID" aria-label="Search">
      <button class="btn btn-outline-success" value= "search" type="submit">Search</button>
    </form>
  </div>
</nav>
</fieldset>
</div>
</center>
</dialogue>


<%} else if(msg.equals("Product is found")) {%>
<%= msg %>
<center>
<% List<pojo> actionList= (List<pojo>) request.getAttribute("actionlist"); %>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Product ID</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
    </tr>
  </thead>
  <tbody>
  <% for(training.pojo action:actionList){ %>
		<tr>
			<td><%= action.getId() %></td>
			<td><%= action.getName() %></td>
			<td><%= action.getDesc() %></td>
			<td><%= action.getPrice() %></td>
			<td><%= action.getQty() %></td>
			
		</tr>
	<% } %>
</tbody>
<% } %>
</table>
</center>
<%-- % else {%>
<%=msg %>
<dialogue open>
<div style="height: 660px; width: 397px;">
<fieldset>
<legend>Enter product ID</legend>
<form action="SearchServlet" method="get">
	<table>
		<tr> 
			<th style="text-align: left;">Product ID</th>
			<th><input type="number" name="pid" placeholder="Enter id"/>
		</tr>
		
	</table><br><br>
	<input type="submit" value="Search"/>
</form>
</fieldset>
</div>
</dialogue>
<% } %> --%>

</body>
</html>