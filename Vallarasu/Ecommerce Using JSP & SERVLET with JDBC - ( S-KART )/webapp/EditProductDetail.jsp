<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Editing the Product Details</h2><br>
<br>
<form action="UpdateServlet" method="post">
<table>
<tr><input type="hidden" name="pid" value="<%= request.getAttribute("pid")%>"></td></tr>
<tr><td><label>ProductID</label></td><td><input type="number" name="pid" value="<%= request.getAttribute("pid")%>" Disabled></td></tr>
<tr><td><label>ProductName</label></td><td><input type="text" name="pname" value="<%= request.getAttribute("pname")%>" Disabled></td></tr>
<tr><td><label>ProductCost</label></td><td><input type="number" name="pcost" value="<%= request.getAttribute("pcost")%>"></td></tr>
<tr><td><label>Quantity</label></td><td><input type="number" name="pquantity" value="<%= request.getAttribute("pquantity")%>"></td></tr>
</table>
<input type="submit" value="Update">
</form>
</body>
</html>