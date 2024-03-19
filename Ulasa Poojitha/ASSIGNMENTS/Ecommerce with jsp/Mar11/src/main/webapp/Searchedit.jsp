<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.sql.ResultSet"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="Menubar.jsp" %>
<h1>Editing the product</h1>
 
<form action="Edit">
<%ResultSet resultSet = (ResultSet)request.getAttribute("resultSet"); if(resultSet!=null && resultSet.next()) {%>
<label>Product_id</label>
<input type="number" name="pid" value="<%=resultSet.getInt(1)%>"placeholder="Enter product id"/><br><br>
<label>Product_name</label>
<input type="text" name="pname" value="<%=resultSet.getString(2)%>"placeholder="Enter product name"><br><br>
<label>Product_description</label>
<input type="text" name="pdesc" value="<%=resultSet.getString(3)%>"placeholder="Enter product description"><br><br>
<label>Product_price</label>
<input type="number" name="pprice" value="<%=resultSet.getInt(4)%>"placeholder="Enter product price"><br><br>
<label>Product_quantity</label>
<input type="number" name="pqty" value="<%=resultSet.getInt(5)%>"placeholder="Enter quantity"><br><br>
<input type="submit" name="edit" value="edit">
<%} %>
</form>
</body>
</html>