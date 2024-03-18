<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
</head>

<body>
<center>
	<%@ include file = "menubar.jsp" %>
	<h1>CREATING THE PRODUCT</h1><br>
	<h3>
	<%= request.getAttribute("msg")== null ?"":request.getAttribute("msg")%>
	</h3>


<form action = "createServlet">

	<label>Enter Product ID:</label>
	<input type = "number" name = "pid" placeholder ="Product ID" required/><br><br>
	
	<label>Enter Product Name:</label>
	<input type="text" name="pname" placeholder = "Product Name" required/><br><br>
	
	<label>Enter Product Description:</label>
	<input type="text" name="pdesc" placeholder = "Product Description" required/><br><br>
	
	<label>Enter Product Price:</label>
	<input type="number" name="pprice" placeholder = "Product Price" required/><br><br>
	
	<label>Enter Product Quantity:</label>
	<input type="number" name="pquant" placeholder = "Product Quantity" required/><br><br>
	
<input type="submit" value="Add Product"/>
<input type="reset" value="Reset"/>

</form>
</center>
</body>
</html>