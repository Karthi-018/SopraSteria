<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="menu.jsp" %>
<h1>Creating the product</h1>
<%=request.getAttribute("msg") %>

<form action="Create">
<label>Product_id</label>
<input type="text" name="pid" value="Enter the product_id"><br>
<label>Product_name</label>
<input type="text" name="pname" value="Enter the product_name"><br>
<label>Product_price</label>
<input type="text" name="pprice" value="Enter the product_price"><br>
<label>Product_quantity</label>
<input type="text" name="pqty" value="Enter the product_qty"><br>
<input type="submit" name="add" value="add">
</form>

</body>
</html>