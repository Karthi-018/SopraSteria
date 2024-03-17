<%@page import="training.pojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy</title>
</head>
<body>

<center>
<%@include file="MenuBarCust.jsp" %></center><br>
<h3 style = "text-align:center;">Billing Page</h3><br><br>
<center>
<% List<pojo> actionList= (List<pojo>) request.getAttribute("actionlist"); %>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Price</th>
      <th scope="col">Confirm</th>
      <th scope="col">Quantity</th>
      <th scope="col">Buy</th>
      
    </tr>
  </thead>
  <tbody>
  <% for(training.pojo action:actionList){ %>
		<tr>
			
			<td><%= action.getName() %></td>
			<td><%= action.getPrice() %></td>
			<form action="Buy" method="get">
			<td><select name="confirm" class="form-select" aria-label="Default select example">
  				<option selected>Confirm</option>
 				 <option value="1">Yes</option>
  				<option value="2">No</option>
				</select>
			</td>
			<td>
				<input type="number" name="qty" placeholder="Enter quantity">
			</td>
			
			<td>
			<button type="submit" name = "pName" value = "<%= action.getName()%>" class="btn btn-secondary">Buy</button>
			</td>
			</form>
			
			
		</tr>
	<% } %>
</tbody>
  
	
</center>
</table> 


</body>
</html>