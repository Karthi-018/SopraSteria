<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="header.jsp" %></center>
<form action="Create" >
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