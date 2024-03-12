<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@include file="home.jsp"%></center>
<h1 style="text-align:center">Creating new Product</h1>
<form action="create" method="get">
<label>Product Id:  </label>
<input type="number" name="id"/><br><br>
<label>Product Name:  </label>
<input type="text" name="name"/><br><br>
<label>Product Description: </label>
<input type="text" name="descp"/><br><br>
<label>Product Price: </label>
<input type="number" name="price"/><br><br>
<label>Product Quantity: </label>
<input type="number" name="quan"/><br><br>
<input type="submit" value="Add" name="act"/>
<input type="reset" value="Reset"/><br><br>
</form>
</body>
</html>