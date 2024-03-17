<%@page import="training.pojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

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
<center>
<%@include file="menubar.jsp" %></center>

<% String msg=request.getAttribute("msg").toString();
if(msg==null){
%>
<center><h1 class="display-5">Creating The Product</h1></center><br><br>
<dialogue open>
<center>
<div style="height: 660px; width: 397px";>
<fieldset>
<legend>Product Details:</legend>
<form action="CreateServlet" method="get">
	<table>
		<tr> 
			<th style="text-align: left;">Product ID</th>
			<th><input type="number" name="id" placeholder="Enter id"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Name</th>
			<th><input type="text" name="pname" placeholder="Enter name"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Desc</th>
			<th><input type="text" name="pdesc" placeholder="Enter description"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Price</th>
			<th><input type="number" name="price" placeholder="Enter price"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Quantity</th>
			<th><input type="text" name="qty" placeholder="Enter quantity"/>
		</tr>
		
	</table><br><br>
	<div class="col-12">
    <button class="btn btn-primary" type="submit" value="Submit Details">Submit Details</button>
  </div>
	<!-- <input type="submit" value="Submit Details"/> -->
</form>
</fieldset>
</div>

</center>
</dialogue>



<% }else {%>
<center><h1 class="display-5">Creating The Product</h1></center><br><br>
<%= msg %>

<dialogue open>
<center>
<div style="height: 660px; width: 397px";>
<fieldset>
<legend>Product Details:</legend>
<form action="CreateServlet" method="get">
	<table>
		<tr> 
			<th style="text-align: left;">Product ID</th>
			<th><input type="number" name="id" placeholder="Enter id"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Name</th>
			<th><input type="text" name="pname" placeholder="Enter name"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Desc</th>
			<th><input type="text" name="pdesc" placeholder="Enter description"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Price</th>
			<th><input type="number" name="price" placeholder="Enter price"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Quantity</th>
			<th><input type="text" name="qty" placeholder="Enter quantity"/>
		</tr>
		
	</table><br><br>
	<div class="col-12">
    <button class="btn btn-primary" type="submit" value="Submit Details">Submit Details</button>
  </div>
	<!-- <input type="submit" value="Submit Details"/> -->
</form>
</fieldset>
</div>
</center>
</dialogue>

<% } %>
</body>
</html>