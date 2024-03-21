<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="AdminMenubar.jsp" %><br>
<h1>CREATING THE PRODUCT</h1>
<fieldset style="width:150px;">
<legend>Product</legend>
<form action="CreateServlet" method="post">
<table>
<tr><td><label>ProductID</label></td><td><input type="number" name="pid" value=""></td></tr>
<tr><td><label>ProductName</label></td><td><input type="text" name="pname" value=""></td></tr>
<tr><td><label>ProductCost</label></td><td><input type="number" name="pcost" value=""></td></tr>
<tr><td><label>Quantity</label></td><td><input type="number" name="pquantity" value=""></td></tr>
</table>
<input type="Submit" name="" value="Add">
<input type="Reset">
</form>
</fieldset>
<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
</center>
</body>
</html>