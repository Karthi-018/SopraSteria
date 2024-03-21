<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menubar.jsp" %>
<h1>Creating the product</h1>
 
<form action="AddServlet">
<label>Product_id</label>
<input type="text" name="pid" value=""placeholder="Enter product id"/><br><br>
<label>Product_name</label>
<input type="text" name="pname" value=""placeholder="Enter product name"><br><br>
<label>Product_description</label>
<input type="text" name="pdesc" value=""placeholder="Enter product description"><br><br>
<label>Product_price</label>
<input type="text" name="pprice" value=""placeholder="Enter product price"><br><br>
<label>Product_quantity</label>
<input type="text" name="pqty" value=""placeholder="Enter quantity"><br><br>
<input type="submit" name="add" value="add">
</form>
</body>
</html>