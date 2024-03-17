
<%@page import="training.pojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of products</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<center>
<%@include file="menubar.jsp" %></center><br>
<center><h1 class="display-5">Viewing The Product</h1></center><br><br>
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
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
      
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
			<td><form action = "Edit" method="get">
			<button type="submit" name = "pid" value = "<%= action.getId()%>" class="btn btn-warning">Edit</button>
			</form></td>
			<td><form action = "Delete" method="get">
			<button type="submit" name = "pid" value = "<%= action.getId()%>" class="btn btn-danger">Delete</button>
			</form></td>
			
		</tr>
	<% } %>
</tbody>
  <!-- <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody> -->
<!-- </table> -->
	<%-- <% List<pojo> actionList= (List<pojo>) request.getAttribute("actionlist"); %>
	<% for(training.pojo action:actionList){ %>
		<tr>
			<td><%= action.getId() %></td>
			<td><%= action.getName() %></td>
			<td><%= action.getDesc() %></td>
			<td><%= action.getPrice() %></td>
			<td><%= action.getQty() %></td>
			
		</tr>
	<% } %> --%>
	
</center>
</table> 
<%-- <%! List<Integer> id= new ArrayList<>(); 
List<String> pname = new ArrayList<>();
List<String> pdescs = new ArrayList<>();
List<Integer> prices = new ArrayList<>();
List<Integer> qty = new ArrayList<>(); %>
<% List<Integer> pid = (ArrayList<Integer>)request.getAttribute("id");%>
<% List<String> pname = (ArrayList<String>)request.getAttribute("pname");%>
<% List<String> pdescs = (ArrayList<String>)request.getAttribute("pdescs");%>
<% List<Integer> pprices = (ArrayList<Integer>)request.getAttribute("prices");%>
<% List<Integer> pqty = (ArrayList<Integer>)request.getAttribute("qty");%>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Desc.</th>
      <th scope="col">Product price</th>
      <th scope="col">Product </th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
   <tbody>
   <% for(int i=0;i<pid.size();i++){ 
	   out.println("<tr>");
	   out.println("<td>"+ pid.get(i)+"</td>");
	   out.println("<td>"+ pname.get(i)+"</td>");
	   out.println("<td>"+ pdescs.get(i)+"</td>");
	   out.println("<td>"+ pprices.get(i)+"</td>");
	   out.println("<td>"+ pqty.get(i)+"</td>");
	   out.println("<td><form action = 'Delete'>");
	   out.println("<button name = 'pid' value = " + " '"+ pid.get(i)+"'"+ ">Delete</button><br></form>");
	   out.println("<form action = 'Edit'>");
	   out.println("<button name = 'pid' value = " + " '"+ pid.get(i)+"'"+ ">Edit</button><br></form></td>");
	   out.println("<tr>");
   };%>
   
  </tbody>
</table>  --%>
</body>
</html>