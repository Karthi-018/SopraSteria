<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
<h1>Creating the product</h1>


<%= request.getAttribute("msg")%>


<form action="createservlet">
<label>Product id :</label>
<input type="number" name="pid" placeholder="Enter the product id">
<br>
<label>Product name</label>
<input type="text" name="pname" placeholder="Enter the product name">
<br>
<label>Product description</label>
<input type="text" name="pdesc" placeholder="Enter the product desc">
<br>
<label>Product price</label>
<input type="number" name="pprice" placeholder="Enter the product price">
<br>
<label>Product quantity</label>
<input type="number" name="pquantity" placeholder="Enter the product quantity">
<br>

<input type="submit" name="add" value="Add">
</form>
</body>
</html>