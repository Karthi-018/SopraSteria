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
<form action="edit">
<label>welcome to shuklaKart</label>
<label> enter product price and product quantity</label><br><br>
<%
ResultSet rs=(ResultSet)request.getAttribute("rs");
rs.next();
%>
<label>productid</label>
<input type="number" name="productid" value="<%=rs.getInt(1)%>" hidden/><br><br>
<input type="number" name="productid" value="<%=rs.getInt(1)%>"disabled/><br><br>
<label>product_name</label>
<input type="text" name="productname" value="<%=rs.getString(2)%>" disabled/><br><br>
<label>product_desc</label>
<input type="text" name="productdesc" value="<%=rs.getString(3)%>"disabled/><br><br>
<label>product price</label>
<input type="text" name="productprice" value="<%=rs.getInt(5)%>"><br><br>
<label>product quantity</label>
<input type="text" name="productquantity" value="<%=rs.getInt(4)%>"><br><br>
<input type="submit"><br><br>
</form>

</body>
</html>