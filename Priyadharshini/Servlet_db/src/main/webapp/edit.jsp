<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="Update">
<input type="number" name="pid" value="<%=request.getAttribute("id") %>" hidden = "true"><br>
<label>Product_id</label>
<input type="text" name="pid" value="<%=request.getAttribute("id") %>"disabled><br>
<label>Product_name</label>
<input type="text" name="pname" value="<%=request.getAttribute("name") %>"disabled><br>
<label>Product_price</label>
<input type="text" name="pprice" value="<%=request.getAttribute("price") %>"><br>
<label>Product_quantity</label>
<input type="text" name="pqty" value="<%=request.getAttribute("quant") %>"><br>
<input type="submit" name="submit" value="edit">
</form>

</body>
</html>