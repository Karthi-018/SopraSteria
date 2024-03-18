<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy</title>
</head>
<body>
<center>
<h1>BUY PRODUCT</h1>
<%  String product = request.getParameter("buyprod")==null?"":request.getParameter("buyprod");
	String[] productList = product.split(":");
	String pid = productList[0];
	String pName = productList[1];
%>
	
<form action="SearchBuyProductServlet">
	
	<input type="number" name="pid" value="<%= pid %>" hidden/>
	
	<label>Product Name:</label><input type="text" name="pname" value="<%= pName %>"" disabled/><br><br>
	
	<label> Enter Quantity:</label><input type="number" name="pquant" value="1" required/><br><br>
	
	<input type="submit" value="Buy Product">
	
</form>

</center>
</body>
</html>