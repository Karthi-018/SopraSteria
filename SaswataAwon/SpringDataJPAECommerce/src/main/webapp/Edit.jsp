
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<%@include file="index.jsp" %></center>

<center><p style="color: red;" class="lead">
  ${msg}
</p></center>

<center><h1 class="display-5">Editing The Product</h1></center><br><br>
<dialogue open>


<center>
<div style="height: 660px; width: 397px";>
<fieldset>
<legend>Product Details:</legend>
<form action="edit">
	<table>
		
		<tr> 
			<th style="text-align: left;"></th>
			<th><input type="text" name="pid" value= "${products.getPid()}" placeholder="Enter name" hidden="true"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Name</th>
			<th><input type="text" name="pname" value= "${products.getPname()}" placeholder="Enter name" disabled="disabled"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Description</th>
			<th><input type="text" name="pdesc" value="${products.getPdesc()}" placeholder="Enter description" disabled="disabled"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Price</th>
			<th><input type="number" name="pprice" value="${products.getPprice()}" placeholder="Enter price"/>
		</tr>
		<tr> 
			<th style="text-align: left;">Product Quantity</th>
			<th><input type="text" name="qty" value="${products.getQty()}" placeholder="Enter quantity"/>
		</tr>
		
	</table><br><br>
	<div class="col-12">
    <button class="btn btn-primary" type="submit" value="Submit Details">Submit Details</button>
  </div>
	
</form>
</fieldset>
</div>

</center>
</dialogue>


</body>
</html>