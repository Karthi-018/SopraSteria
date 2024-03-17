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
</head>
<body>

<center><h3 style="text-align: center;">Editing a product</h3></center>

<% List<pojo> actionList= (List<pojo>) request.getAttribute("actionlist");
	for(pojo p : actionList){
%>
<dialogue open>
<center>
<div style="height: 660px; width: 397px";>
<fieldset>
<legend>Product Details:</legend>
<form action="Edit2" method="get">
	<table>
		<tr> 
			<th style="text-align: left;">Product ID</th>
			<th><input type="number" name="id" value="<%= p.getId()%>" />
		</tr>
		<tr> 
			<th style="text-align: left;">Product Name</th>
			<th><input type="text" name="pname" value="<%= p.getName()%>" />
		</tr>
		<tr> 
			<th style="text-align: left;">Product Desc</th>
			<th><input type="text" name="pdesc" value="<%=p.getDesc()%>" />
		</tr>
		<tr> 
			<th style="text-align: left;">Product Price</th>
			<th><input type="number" name="price" value="<%= p.getPrice()%>" />
		</tr>
		<tr> 
			<th style="text-align: left;">Product Quantity</th>
			<th><input type="text" name="qty" value="<%=p.getQty()%>" />
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