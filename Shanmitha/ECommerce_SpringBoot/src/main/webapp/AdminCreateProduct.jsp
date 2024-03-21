<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<center><%@ include file="AdminMenubar.jsp" %></center>
<form action="CreateProduct" method="post">
<label>Product Id:  </label>
<input type="text" name="id"/><br><br>
<label>Product Name:  </label>
<input type="text" name="name"/><br><br>
<label>Product Description: </label>
<input type="text" name="descr"/><br><br>
<label>Product Price: </label>
<input type="text" name="price"/><br><br>
<label>Product Quantity: </label>
<input type="text" name="quantity"/><br><br>
<input type="submit" value="Add" name="act"/>
</form>

</body>
</html>