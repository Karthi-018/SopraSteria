<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Ecommerce">
<label>Product Id</label><input type="number" name="proId" value=""placeholder="Enter product Id"/><br><br>
<label>Product Name</label><input type="text" name="proName" value=""placeholder="Enter Product Name:"/><br><br>
<label>Product description</label><input type="text" name="proDescription" value=""placeholder="Enter Product description"/><br><br>
<label>Product price</label><input type="number" name="proPrice" value=""placeholder="Enter Product price"/><br><br>
<label>Quantity</label><input type="number" name="proQuantity" value=""placeholder="Enter total quantity"/><br><br>
<input type="submit" name="option"value="Add">
<input type="Reset">
<input type="number" placeholder="Type Product Id to search" name="search"/>
<input type="submit" name="option" value="Search"/><br><br>
</form>
</body>
</html>